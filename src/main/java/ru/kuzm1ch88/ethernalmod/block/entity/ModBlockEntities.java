package ru.kuzm1ch88.ethernalmod.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ru.kuzm1ch88.ethernalmod.EthernalMod;
import ru.kuzm1ch88.ethernalmod.block.ModBlocks;

public class ModBlockEntities {
    public static BlockEntityType<OtherworldlyMelterEntity> OTHER_WORLDLY_MELTER;

    public static void registerBlockEntities() {
        OTHER_WORLDLY_MELTER = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(EthernalMod.MOD_ID, "other_worldly_melter"),
                FabricBlockEntityTypeBuilder.create(OtherworldlyMelterEntity::new,
                        ModBlocks.OTHERWORLDLY_MELTER).build(null));
    }
}
