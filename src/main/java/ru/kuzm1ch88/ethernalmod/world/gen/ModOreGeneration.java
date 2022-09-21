package ru.kuzm1ch88.ethernalmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import ru.kuzm1ch88.ethernalmod.world.feature.ModPlacedFeatures;

public class ModOreGeneration {
    public static void generateOre(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ALATY_STONE_ORE_PLACED.getKey().get());

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FROZEN_OCEAN, BiomeKeys.FROZEN_PEAKS, BiomeKeys.FROZEN_RIVER, BiomeKeys.SNOWY_BEACH, BiomeKeys.SNOWY_PLAINS, BiomeKeys.SNOWY_SLOPES, BiomeKeys.SNOWY_TAIGA),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ALATY_STONE_ORE_PLACED.getKey().get()); // Холодное железо спавниться только в Зимних биомах
    }
}
