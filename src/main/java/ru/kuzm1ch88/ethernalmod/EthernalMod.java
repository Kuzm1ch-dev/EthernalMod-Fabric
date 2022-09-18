package ru.kuzm1ch88.ethernalmod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kuzm1ch88.ethernalmod.block.ModBlocks;
import ru.kuzm1ch88.ethernalmod.item.ModItems;

public class EthernalMod implements ModInitializer {
	public static final String MOD_ID = "ethernalmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocks.registerModItems();
		ModItems.registerModItems();
		LOGGER.info("Ethernal Mod!");
	}
}
