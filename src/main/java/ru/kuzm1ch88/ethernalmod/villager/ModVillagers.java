package ru.kuzm1ch88.ethernalmod.villager;

import com.google.common.collect.ImmutableSet;
import com.sun.source.tree.IdentifierTree;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterest;
import net.minecraft.world.poi.PointOfInterestType;
import ru.kuzm1ch88.ethernalmod.EthernalMod;
import ru.kuzm1ch88.ethernalmod.block.ModBlocks;
import ru.kuzm1ch88.ethernalmod.item.ModItems;

public class ModVillagers {

    public static final PointOfInterestType PRIEST_POI = registerPOI("priest_poi", ModBlocks.AUMENTIT_ORE);
    public static final VillagerProfession PRIEST = registerProfession("priest",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(EthernalMod.MOD_ID, "priest_poi")));

    public static final PointOfInterestType ANTIQUE_COLLECTOR_POI = registerPOI("antique_collector_poi", Blocks.GOLD_BLOCK);
    public static final VillagerProfession ANTIQUE_COLLECTOR = registerProfession("antique_collector",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(EthernalMod.MOD_ID, "antique_collector_poi")));


    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type){
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(EthernalMod.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(EthernalMod.MOD_ID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_CLERIC).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(EthernalMod.MOD_ID, name),
                1,1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerVillagers(){
        EthernalMod.LOGGER.info("Register Ethernal Mod Villagers");
    }

    public static void registerTrades() {

        //Priest
        TradeOfferHelper.registerVillagerOffers(PRIEST, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.HOLY_CROSS,1),
                            new ItemStack(Items.BREAD,1),
                            6,  2,0.02f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(PRIEST, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.HOLY_BIBLE,1),
                            new ItemStack(Items.BREAD,1),
                            6,  2,0.02f
                    )));
                });

        // Antique Collector

        TradeOfferHelper.registerVillagerOffers(ANTIQUE_COLLECTOR, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.HOLY_BIBLE,1),
                            new ItemStack(Items.EMERALD,32),
                            6,  2,0.02f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(ANTIQUE_COLLECTOR, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.HOLY_CROSS,1),
                            new ItemStack(Items.EMERALD,24),
                            6,  2,0.02f
                    )));
                });


        //Farmer
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD,1),
                            new ItemStack(ModItems.ONION,4),
                            6,  2,0.02f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD,3),
                            new ItemStack(ModItems.RADISH,4),
                            6,  2,0.02f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD,4),
                            new ItemStack(ModItems.RUTABAGA,4),
                            6,  2,0.02f
                    )));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD,8),
                            new ItemStack(ModItems.GARLIC,4),
                            6,  2,0.02f
                    )));
                });
    }
}
