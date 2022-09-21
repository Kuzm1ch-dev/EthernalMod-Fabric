package ru.kuzm1ch88.ethernalmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import ru.kuzm1ch88.ethernalmod.EthernalMod;
import ru.kuzm1ch88.ethernalmod.block.custom.OnionCrop;
import ru.kuzm1ch88.ethernalmod.item.ModItemsGroup;

public class ModBlocks {


    // Ore's
    public static Block ALATY_STONE_ORE = registerBlock("alaty_stone_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    public static Block AUMENTIT_ORE = registerBlock("aumentit_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    public static Block TIN_ORE = registerBlock("tin_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    public static Block COLD_IRON_ORE = registerBlock("cold_iron_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    public static Block CLEOMENIS_ORE = registerBlock("cleomenis_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    public static Block EROBI_ORE = registerBlock("erobi_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    public static Block FILIOT_ORE = registerBlock("filiot_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    public static Block HROZ_ORE = registerBlock("hroz_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    public static Block MORIUT_ORE = registerBlock("moriut_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    public static Block TARGARIT_ORE = registerBlock("targarit_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    public static Block TRAWITIN_ORE = registerBlock("trawitin_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool(),
            UniformIntProvider.create(3,7)),ModItemsGroup.ETHERNAL_RESOURCE);
    // Ingot block's
    public static Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    public static Block TIN_BLOCK = registerBlock("tin_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    public static Block COLD_ITEM_BLOCK = registerBlock("cold_iron_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    public static Block ALATY_STONE_BLOCK = registerBlock("alaty_stone_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(1f).requiresTool()),ModItemsGroup.ETHERNAL_RESOURCE);

    // Crop's

    public static Block ONION_CROP = registerBlockWithoutItem("onion_crop",
            new OnionCrop(FabricBlockSettings.copy(Blocks.WHEAT)));


    private static Block registerBlockWithoutItem(String name, Block block){
        return Registry.register(Registry.BLOCK, new Identifier(EthernalMod.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Block block,  ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(EthernalMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(EthernalMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModItems(){
        EthernalMod.LOGGER.info("Register Ethernal Mod blocks");
    }
}
