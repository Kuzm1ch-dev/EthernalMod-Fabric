package ru.kuzm1ch88.ethernalmod.block.custom;

import com.google.common.collect.ImmutableClassToInstanceMap;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.kuzm1ch88.ethernalmod.EthernalMod;
import ru.kuzm1ch88.ethernalmod.block.entity.ErobiAnvilEntity;
import ru.kuzm1ch88.ethernalmod.block.entity.ModBlockEntities;

import java.util.stream.Stream;

public class ErobiAnvil extends BlockWithEntity implements BlockEntityProvider {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    private static VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(13, 9, 5, 15, 11, 11),
            Block.createCuboidShape(3, 0, 5, 13, 2, 11),
            Block.createCuboidShape(5, 2, 6, 11, 8, 10),
            Block.createCuboidShape(3, 8, 4, 13, 11, 12),
            Block.createCuboidShape(0, 9, 6, 3, 11, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    public ErobiAnvil(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }


    /* BLOCK ENTITY */

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ErobiAnvilEntity) {
                ItemScatterer.spawn(world, pos, (ErobiAnvilEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {

        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        ErobiAnvilEntity blockEntity = (ErobiAnvilEntity) world.getBlockEntity(pos);
        ItemStack itemStack = player.getStackInHand(hand);

        if(blockEntity.getStack(0).isEmpty())//Если наковальня пустая
        {
            blockEntity.setStack(0, new ItemStack(itemStack.getItem(), 1));
            if (!player.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
        }
        else if (itemStack.isEmpty()){ //Если наковальня не пустая
            player.getInventory().insertStack(blockEntity.getItems().get(0));
            blockEntity.removeStack(0);
        }

        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ErobiAnvilEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ModBlockEntities.EROBI_ANVIL, ErobiAnvilEntity::tick);
    }
}
