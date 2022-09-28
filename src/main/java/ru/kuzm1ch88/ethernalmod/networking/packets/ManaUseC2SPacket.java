package ru.kuzm1ch88.ethernalmod.networking.packets;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import ru.kuzm1ch88.ethernalmod.utils.IEntityDataSaver;
import ru.kuzm1ch88.ethernalmod.utils.ManaData;

public class ManaUseC2SPacket {
    public static  void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                                PacketByteBuf buf, PacketSender responseSender){
        ServerWorld world = player.getWorld();
        world.playSound(null,player.getBlockPos(), SoundEvents.AMBIENT_CAVE, SoundCategory.PLAYERS,
                0.5f, world.random.nextFloat() * 0.1f + 0.9f);
        ManaData.removeMana((IEntityDataSaver) player, 1);

        player.sendMessage(Text.literal("Mana:" + ((IEntityDataSaver)player).getPersistentData().getInt("mana")));

        ManaData.syncMana(((IEntityDataSaver) player).getPersistentData().getInt("mana"), player);
    }
}
