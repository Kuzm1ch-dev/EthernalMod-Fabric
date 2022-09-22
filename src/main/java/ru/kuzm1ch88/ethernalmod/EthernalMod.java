package ru.kuzm1ch88.ethernalmod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kuzm1ch88.ethernalmod.block.ModBlocks;
import ru.kuzm1ch88.ethernalmod.block.entity.ModBlockEntities;
import ru.kuzm1ch88.ethernalmod.item.ModItems;
import ru.kuzm1ch88.ethernalmod.painting.ModPaintings;
import ru.kuzm1ch88.ethernalmod.recipe.ModRecipes;
import ru.kuzm1ch88.ethernalmod.screen.ModScreenHandlers;
import ru.kuzm1ch88.ethernalmod.utils.ModLootTableModifiers;
import ru.kuzm1ch88.ethernalmod.villager.ModVillagers;
import ru.kuzm1ch88.ethernalmod.world.feature.ModConfiiguredFeatures;
import ru.kuzm1ch88.ethernalmod.world.gen.ModOreGeneration;

public class EthernalMod implements ModInitializer {
	public static final String MOD_ID = "ethernalmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModItems();

		ModItems.registerModItems();

		ModVillagers.registerVillagers();

		ModVillagers.registerTrades();

		ModPaintings.registerPaintings();

		ModConfiiguredFeatures.registerConfiguredFeatures();

		ModOreGeneration.generateOre();

		ModLootTableModifiers.modifyLootTables();

		ModBlockEntities.registerBlockEntities();

		ModScreenHandlers.registerAllScreenHandlers();

		ModRecipes.registerRecipes();

		LOGGER.info("Ethernal Mod!");
	}
}
