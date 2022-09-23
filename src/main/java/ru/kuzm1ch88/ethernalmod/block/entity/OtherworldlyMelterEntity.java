package ru.kuzm1ch88.ethernalmod.block.entity;

import com.google.common.collect.Maps;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.kuzm1ch88.ethernalmod.block.ModBlocks;
import ru.kuzm1ch88.ethernalmod.block.custom.OtherworldlyMelter;
import ru.kuzm1ch88.ethernalmod.item.ModItems;
import ru.kuzm1ch88.ethernalmod.recipe.OtherWorldlyMelterRecipe;
import ru.kuzm1ch88.ethernalmod.screen.OtherWorldlyMelterScreenHandler;

import java.util.Map;
import java.util.Optional;

public class OtherworldlyMelterEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory{
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;
    int burnTime = 0;
    int fuelTime = 0;

    public static Map<Item, Integer> createFuelTimeMap() {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        addFuel(map, ModItems.ALATY_STONE, 2000);
        addFuel(map, ModBlocks.ALATY_STONE_BLOCK.asItem(), 18000);
        return map;
    }

    private static void addFuel(Map<Item, Integer> fuelTimes, Item item, int fuelTime) {
            fuelTimes.put(item, fuelTime);
    }

    protected int getFuelTime(ItemStack fuel) {
        if (fuel.isEmpty()) {
            return 0;
        } else {
            Item item = fuel.getItem();
            return (Integer)createFuelTimeMap().getOrDefault(item, 0);
        }
    }

    private boolean isBurning() {
        return this.burnTime > 0;
    }

    public OtherworldlyMelterEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OTHER_WORLDLY_MELTER, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0: return OtherworldlyMelterEntity.this.progress;
                    case 1: return OtherworldlyMelterEntity.this.maxProgress;
                    case 2: return OtherworldlyMelterEntity.this.burnTime;
                    case 3: return OtherworldlyMelterEntity.this.fuelTime;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: OtherworldlyMelterEntity.this.progress = value; break;
                    case 1: OtherworldlyMelterEntity.this.maxProgress = value; break;
                    case 2: OtherworldlyMelterEntity.this.burnTime = value; break;
                    case 3: OtherworldlyMelterEntity.this.fuelTime = value; break;
                }
            }

            public int size() {
                return 4;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Other Worldly Melter");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new OtherWorldlyMelterScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("other_worldly_melter.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
        progress = nbt.getInt("other_worldly_melter.progress");
    }

    private void resetProgress() {
        this.progress = 0;
    }

    public static void tick(World world, BlockPos blockPos, BlockState state, OtherworldlyMelterEntity entity) {
        if(world.isClient()) {
            return;
        }

        ItemStack itemStack = (ItemStack)entity.inventory.get(3);
        boolean fuel = !itemStack.isEmpty();

        if (entity.isBurning()) {
            --entity.burnTime;
        }

        if(hasRecipe(entity) && !entity.isBurning() && fuel) {
            entity.burnTime = entity.getFuelTime(itemStack);
            entity.fuelTime = entity.burnTime;
            entity.removeStack(3, 1);
        }

        if(hasRecipe(entity) && entity.isBurning()) {
            entity.progress++;
            state = (BlockState)state.with(OtherworldlyMelter.LIT, true);
            world.setBlockState(blockPos, state, 3);
            markDirty(world, blockPos, state);
            if(entity.progress >= entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            state = (BlockState)state.with(OtherworldlyMelter.LIT, false);
            world.setBlockState(blockPos, state, 3);
            markDirty(world, blockPos, state);
        }
    }

    private static void craftItem(OtherworldlyMelterEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<OtherWorldlyMelterRecipe> recipe = entity.getWorld().getRecipeManager()
                .getFirstMatch(OtherWorldlyMelterRecipe.Type.INSTANCE, inventory, entity.getWorld());

        if(hasRecipe(entity)) {
            entity.removeStack(0, 1);
            entity.removeStack(1, 1);

            entity.setStack(2, new ItemStack(recipe.get().getOutput().getItem(),
                    entity.getStack(2).getCount() + 1));

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(OtherworldlyMelterEntity entity) {
        SimpleInventory inventory = new SimpleInventory(entity.size());
        for (int i = 0; i < entity.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<OtherWorldlyMelterRecipe> match = entity.getWorld().getRecipeManager()
                .getFirstMatch(OtherWorldlyMelterRecipe.Type.INSTANCE, inventory, entity.getWorld());

        return match.isPresent() && canInsertAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput().getItem());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, Item output) {
        return inventory.getStack(2).getItem() == output || inventory.getStack(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleInventory inventory) {
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }
}