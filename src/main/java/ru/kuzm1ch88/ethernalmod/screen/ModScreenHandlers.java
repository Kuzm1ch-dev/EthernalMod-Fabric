package ru.kuzm1ch88.ethernalmod.screen;

import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<OtherWorldlyMelterScreenHandler> OTHERWORLDLY_MELTER_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        OTHERWORLDLY_MELTER_SCREEN_HANDLER = new ScreenHandlerType<>(OtherWorldlyMelterScreenHandler::new);
    }
}
