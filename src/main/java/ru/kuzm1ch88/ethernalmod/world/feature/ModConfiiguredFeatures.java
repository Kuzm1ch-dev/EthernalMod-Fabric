package ru.kuzm1ch88.ethernalmod.world.feature;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import ru.kuzm1ch88.ethernalmod.EthernalMod;
import ru.kuzm1ch88.ethernalmod.block.ModBlocks;
import ru.kuzm1ch88.ethernalmod.item.ModItems;

import java.util.List;

public class ModConfiiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_ALATY_STONE_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ALATY_STONE_ORE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> OVERWORLD_COLD_IRON_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.COLD_IRON_ORE.getDefaultState()));


    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ALATY_STONE_ORE =
            ConfiguredFeatures.register("alaty_stone_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_ALATY_STONE_ORE, 9)); // Максимальный размер жилы

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> COLD_IRON_ORE =
            ConfiguredFeatures.register("cold_iron_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_ALATY_STONE_ORE, 3));
    public static void registerConfiguredFeatures(){
        EthernalMod.LOGGER.info("Register Ethernal Mod FeaturesConfigure!");
    }
}
