package ru.kuzm1ch88.ethernalmod.networking;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import ru.kuzm1ch88.ethernalmod.EthernalMod;
import ru.kuzm1ch88.ethernalmod.networking.packets.ExampleC2SPacket;

public class ModMessages {
        public static final Identifier MANA_USE_ID = new Identifier(EthernalMod.MOD_ID, "mana_use");
        public static final Identifier MANA_SYNC_ID = new Identifier(EthernalMod.MOD_ID, "mana_sync");
        public static final Identifier EXAMPLE_ID = new Identifier(EthernalMod.MOD_ID, "example");


        public static void registerC2SPackets(){
            ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::receive);
        }

        public static void registerS2CPackets(){

        }
}
