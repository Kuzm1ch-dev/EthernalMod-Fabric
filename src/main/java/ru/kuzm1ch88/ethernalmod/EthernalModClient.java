package ru.kuzm1ch88.ethernalmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import ru.kuzm1ch88.ethernalmod.block.ModBlocks;
import ru.kuzm1ch88.ethernalmod.block.entity.ModBlockEntities;
import ru.kuzm1ch88.ethernalmod.block.entity.client.ErobiAnvilEntityRenderer;
import ru.kuzm1ch88.ethernalmod.screen.ModScreenHandlers;
import ru.kuzm1ch88.ethernalmod.screen.OtherWorldlyMelterScreen;

public class EthernalModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ONION_CROP, RenderLayer.getCutout());

        HandledScreens.register(ModScreenHandlers.OTHERWORLDLY_MELTER_SCREEN_HANDLER, OtherWorldlyMelterScreen::new);

        BlockEntityRendererRegistry.register(ModBlockEntities.EROBI_ANVIL, ErobiAnvilEntityRenderer::new);
    }
}
