package ru.kuzm1ch88.ethernalmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.kuzm1ch88.ethernalmod.EthernalMod;
import ru.kuzm1ch88.ethernalmod.block.ModBlocks;
import ru.kuzm1ch88.ethernalmod.item.custom.HolyBible;
import ru.kuzm1ch88.ethernalmod.item.custom.HolyCross;

public class ModItems {

    //Artifacts

    public static final Item HOLY_BIBLE = registerItem("holy_bible",
            new HolyBible(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_ARTIFACT).maxCount(1)));

    public static final Item HOLY_CROSS = registerItem("holy_cross",
            new HolyCross(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_ARTIFACT).maxCount(1)));

    //Food's

    public static final Item RADISH = registerItem("radish",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_FOOD).food(ModFoodComponents.RADISH)));

    public static final Item ONION = registerItem("onion",
            new AliasedBlockItem(ModBlocks.ONION_CROP, new FabricItemSettings().group(ModItemsGroup.ETHERNAL_FOOD).food(ModFoodComponents.ONION)));

    public static final Item GARLIC = registerItem("garlic",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_FOOD).food(ModFoodComponents.GARLIC)));

    public static final Item RUTABAGA = registerItem("rutabaga",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_FOOD).food(ModFoodComponents.RUTABAGA)));
    public static final Item PIECE_OF_CHEESE = registerItem("piece_of_cheese",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_FOOD).food(ModFoodComponents.PIECE_OF_CHEESE)));


    // Ingot's
    public static final Item TARFILIOT_INGOT = registerItem("tarfiliot_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item MOROBI_INGOT = registerItem("morobi_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item HROZIFIL_INGOT = registerItem("hrozifil_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item FROZEN_MAGMATIC_IRON_INGOT = registerItem("frozen_magmatic_iron_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item CLEOMENIS_INGOT = registerItem("cleomenis_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item EROBI_INGOT = registerItem("erobi_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item FILIOT_INGOT = registerItem("filiot_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item HROZ_INGOT = registerItem("hroz_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item MORIUT_INGOT = registerItem("moriut_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item TARGARIT_INGOT = registerItem("targarit_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item TRAWITIN_INGOT = registerItem("trawitin_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item AUMENTIT_INGOT = registerItem("aumentit_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item COLD_IRON_INGOT = registerItem("cold_iron_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item TIN_INGOT = registerItem("tin_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    // Resource
    public static final Item ALATY_STONE = registerItem("alaty_stone",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));
    // Fabric

    public static final Item FABRIC = registerItem("fabric",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item GOLDEN_STRING = registerItem("golden_string",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item GOLDEN_FABRIC = registerItem("golden_fabric",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    // Raw's

    public static final Item RAW_TRAWITIN = registerItem("raw_trawitin",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item RAW_TARGARIT = registerItem("raw_targarit",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item RAW_CLEOMENIS = registerItem("raw_cleomenis",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item RAW_MORIUT = registerItem("raw_moriut",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item RAW_HROZ = registerItem("raw_hroz",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item RAW_FILIOT = registerItem("raw_filiot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item RAW_EROBI = registerItem("raw_erobi",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item RAW_AUMENTIT = registerItem("raw_aumentit",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item RAW_TIN = registerItem("raw_tin",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    public static final Item RAW_COLD_IRON = registerItem("raw_cold_iron",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_RESOURCE)));

    // Tools

        //PickAxe

    public static final Item HROZ_PICKAXE = registerItem("hroz_pickaxe",
            new PickaxeItem(ModToolMaterial.HROZ, (int) (ModToolMaterial.HROZ.getAttackDamage() - 2f),2f,
                    new FabricItemSettings().group(ModItemsGroup.ETHERNAL_WEAPON).maxCount(1)));

    public static final Item MORIUT_PICKAXE = registerItem("moriut_pickaxe",
            new PickaxeItem(ModToolMaterial.MORIUT, (int) (ModToolMaterial.MORIUT.getAttackDamage() - 2f),2f,
                    new FabricItemSettings().group(ModItemsGroup.ETHERNAL_WEAPON).maxCount(1)));

    public static final Item TARGARIT_PICKAXE = registerItem("targarit_pickaxe",
            new PickaxeItem(ModToolMaterial.TARGARIT, (int) (ModToolMaterial.TARGARIT.getAttackDamage() - 2f),2f,
                    new FabricItemSettings().group(ModItemsGroup.ETHERNAL_WEAPON).maxCount(1)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(EthernalMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        EthernalMod.LOGGER.info("Register Ethernal Mod items");
    }
}
