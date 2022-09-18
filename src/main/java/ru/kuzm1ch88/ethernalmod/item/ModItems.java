package ru.kuzm1ch88.ethernalmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.kuzm1ch88.ethernalmod.EthernalMod;

public class ModItems {


    // Ingot's
    public static final Item CLEOMENIS_INGOT = registerItem("cleomenis_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item EROBI_INGOT = registerItem("erobi_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item FILIOT_INGOT = registerItem("filiot_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item HROZ_INGOT = registerItem("hroz_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item MORIUT_INGOT = registerItem("moriut_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item TARGARIT_INGOT = registerItem("targarit_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item TRAWITIN_INGOT = registerItem("trawitin_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item AUMENTIT_INGOT = registerItem("aumentit_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item COLD_IRON_INGOT = registerItem("cold_iron_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item TIN_INGOT = registerItem("tin_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    // Resource
    public static final Item ALATY_STONE = registerItem("alaty_stone",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));
    // Fabric

    public static final Item FABRIC = registerItem("fabric",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item GOLDEN_STRING = registerItem("golden_string",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item GOLDEN_FABRIC = registerItem("golden_fabric",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    // Raw's

    public static final Item RAW_TRAWITIN = registerItem("raw_trawitin",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item RAW_TARGARIT = registerItem("raw_targarit",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item RAW_CLEOMENIS = registerItem("raw_cleomenis",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item RAW_MORIUT = registerItem("raw_moriut",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item RAW_HROZ = registerItem("raw_hroz",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item RAW_FILIOT = registerItem("raw_filiot",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item RAW_EROBI = registerItem("raw_erobi",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item RAW_AUMENTIT = registerItem("raw_aumentit",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item RAW_TIN = registerItem("raw_tin",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    public static final Item RAW_COLD_IRON = registerItem("raw_cold_iron",
            new Item(new FabricItemSettings().group(ModItemsGroup.ETHERNAL_MOD)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(EthernalMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        EthernalMod.LOGGER.info("Register Ethernal Mod items");
    }
}
