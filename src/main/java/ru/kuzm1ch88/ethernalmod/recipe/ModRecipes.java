package ru.kuzm1ch88.ethernalmod.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.kuzm1ch88.ethernalmod.EthernalMod;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(EthernalMod.MOD_ID, OtherWorldlyMelterRecipe.Serializer.ID),
                OtherWorldlyMelterRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(EthernalMod.MOD_ID, OtherWorldlyMelterRecipe.Type.ID),
                OtherWorldlyMelterRecipe.Type.INSTANCE);
    }
}
