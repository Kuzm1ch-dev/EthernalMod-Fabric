package ru.kuzm1ch88.ethernalmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import ru.kuzm1ch88.ethernalmod.EthernalMod;

public class OtherWorldlyMelterScreen extends HandledScreen<OtherWorldlyMelterScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(EthernalMod.MOD_ID, "textures/gui/otherworldly_melter_gui.png");

    public OtherWorldlyMelterScreen(OtherWorldlyMelterScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(matrices, x, y);
        renderFuelArrow(matrices, x, y);
    }

    private void renderProgressArrow(MatrixStack matrices, int x, int y) {
        if(handler.isCrafting()) {
            drawTexture(matrices, x + 67, y + 19, 176, 0, 36, handler.getScaledProgress());
        }
    }

    private void renderFuelArrow(MatrixStack matrices, int x, int y) {
        if(handler.isBurning()) {
            int scale = handler.getScaledFuel();
            drawTexture(matrices, x + 85, y + 49 - scale + 14, 212, 0 - scale + 14, 15, handler.getScaledFuel()); // 14 is texture height
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}