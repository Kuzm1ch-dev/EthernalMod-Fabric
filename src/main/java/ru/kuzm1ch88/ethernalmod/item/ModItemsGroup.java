package ru.kuzm1ch88.ethernalmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import ru.kuzm1ch88.ethernalmod.EthernalMod;

public class ModItemsGroup {
    public static final ItemGroup ETHERNAL_RESOURCE = FabricItemGroupBuilder.build(new Identifier(EthernalMod.MOD_ID,
            "ethernal_resource"), () -> new ItemStack(ModItems.HROZIFIL_INGOT));

    public static final ItemGroup ETHERNAL_FOOD = FabricItemGroupBuilder.build(new Identifier(EthernalMod.MOD_ID,
            "ethernal_food"), () -> new ItemStack(ModItems.PIECE_OF_CHEESE));

    public static final ItemGroup ETHERNAL_WEAPON = FabricItemGroupBuilder.build(new Identifier(EthernalMod.MOD_ID,
            "ethernal_weapon"), () -> new ItemStack(ModItems.FROZEN_MAGMATIC_IRON_PICKAXE));

    public static final ItemGroup ETHERNAL_ARTIFACT = FabricItemGroupBuilder.build(new Identifier(EthernalMod.MOD_ID,
            "ethernal_artifact"), () -> new ItemStack(ModItems.HOLY_BIBLE));
}
