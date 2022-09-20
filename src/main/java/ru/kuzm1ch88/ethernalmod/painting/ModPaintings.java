package ru.kuzm1ch88.ethernalmod.painting;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.kuzm1ch88.ethernalmod.EthernalMod;

public class ModPaintings {

    public static final PaintingVariant MONA_LISA = registerPainting("mona_list", new PaintingVariant(32,48));

    public static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant){
        return Registry.register(Registry.PAINTING_VARIANT, new Identifier(EthernalMod.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings(){
        EthernalMod.LOGGER.info("Register Ethernal Mod paintings");
    }
}
