package ru.kuzm1ch88.ethernalmod.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.kuzm1ch88.ethernalmod.EthernalMod;

@Mixin(TitleScreen.class)
public class EthernalMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		EthernalMod.LOGGER.info("This line is printed by an example mod mixin!");
	}
}
