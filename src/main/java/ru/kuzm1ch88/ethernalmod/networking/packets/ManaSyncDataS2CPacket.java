package ru.kuzm1ch88.ethernalmod.networking.packets;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import ru.kuzm1ch88.ethernalmod.utils.IEntityDataSaver;

public class ManaSyncDataS2CPacket {
    public static  void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                                PacketByteBuf buf, PacketSender responseSender){
        if (client.player != null){
            ((IEntityDataSaver) client.player).getPersistentData().putInt("mana", buf.readInt());
        }
    }
}
