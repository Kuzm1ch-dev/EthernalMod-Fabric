package ru.kuzm1ch88.ethernalmod.utils;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;
import ru.kuzm1ch88.ethernalmod.item.ModItems;

public class ModLootTableModifiers {
    private static final Identifier GRASS_BLOCK
            = new Identifier("minecraft","blocks/grass");

    private static final Identifier DESERT_PYRAMID
            = new Identifier("minecraft","chests/desert_pyramid");


    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {

            // GRASS
            if(GRASS_BLOCK.equals(id)){
                LootPool.Builder poolBuilder_gralic = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // 35%
                        .with(ItemEntry.builder(ModItems.GARLIC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build());

                LootPool.Builder poolBuilder_onion = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f)) // 35%
                        .with(ItemEntry.builder(ModItems.ONION))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build());

                LootPool.Builder poolBuilder_rutabaga = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.RUTABAGA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build());

                LootPool.Builder poolBuilder_radish = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.RADISH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build());

                tableBuilder.pool(poolBuilder_onion.build());
                tableBuilder.pool(poolBuilder_gralic.build());
                tableBuilder.pool(poolBuilder_rutabaga.build());
                tableBuilder.pool(poolBuilder_radish.build());
            }

            // DESERT PYRAMID

            if(DESERT_PYRAMID.equals(id)){
                LootPool.Builder poolBuilder_bible = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // 1%
                        .with(ItemEntry.builder(ModItems.HOLY_BIBLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build());

                LootPool.Builder poolBuilder_cross = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.01f)) // 1%
                        .with(ItemEntry.builder(ModItems.HOLY_BIBLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build());

                tableBuilder.pool(poolBuilder_bible.build());
                tableBuilder.pool(poolBuilder_cross.build());
            }

        });
    }
}
