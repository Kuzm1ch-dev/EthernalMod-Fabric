package ru.kuzm1ch88.ethernalmod.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import ru.kuzm1ch88.ethernalmod.EthernalMod;
import ru.kuzm1ch88.ethernalmod.networking.packets.ExampleC2SPacket;
import ru.kuzm1ch88.ethernalmod.networking.packets.ItemStackSyncS2CPacket;
import ru.kuzm1ch88.ethernalmod.networking.packets.ManaSyncDataS2CPacket;
import ru.kuzm1ch88.ethernalmod.networking.packets.ManaUseC2SPacket;

public class ModMessages {
        public static final Identifier MANA_USE_ID = new Identifier(EthernalMod.MOD_ID, "mana_use");
        public static final Identifier MANA_SYNC_ID = new Identifier(EthernalMod.MOD_ID, "mana_sync");
        public static final Identifier EXAMPLE_ID = new Identifier(EthernalMod.MOD_ID, "example");
        public static final Identifier ITEM_SYNC = new Identifier(EthernalMod.MOD_ID, "item_sync");




        public static void registerC2SPackets(){
            ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::receive);
            ServerPlayNetworking.registerGlobalReceiver(MANA_USE_ID, ManaUseC2SPacket::receive);
        }

        public static void registerS2CPackets(){
            ClientPlayNetworking.registerGlobalReceiver(MANA_SYNC_ID, ManaSyncDataS2CPacket::receive);
            ClientPlayNetworking.registerGlobalReceiver(ITEM_SYNC, ItemStackSyncS2CPacket::receive);
        }
}
