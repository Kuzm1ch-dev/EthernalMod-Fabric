package ru.kuzm1ch88.ethernalmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kuzm1ch88.ethernalmod.block.ModBlocks;
import ru.kuzm1ch88.ethernalmod.block.entity.ModBlockEntities;
import ru.kuzm1ch88.ethernalmod.event.KeyInputHandler;
import ru.kuzm1ch88.ethernalmod.event.PlayerTickHandler;
import ru.kuzm1ch88.ethernalmod.item.ModItems;
import ru.kuzm1ch88.ethernalmod.networking.ModMessages;
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

		KeyInputHandler.registerKeyInputs();

		ModMessages.registerC2SPackets();

		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());

		LOGGER.info("Ethernal Mod!");
	}
}
