package ru.kuzm1ch88.ethernalmod.utils;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import ru.kuzm1ch88.ethernalmod.networking.ModMessages;

public class ManaData {

    public static int getMana(IEntityDataSaver player){
        NbtCompound nbt = player.getPersistentData();
        return nbt.getInt("mana");
    }

    public static int addMana(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int mana = nbt.getInt("mana");
        if(mana + amount >= 10) {
            mana = 10;
        } else {
            mana += amount;
        }

        nbt.putInt("mana", mana);
        syncMana(mana, (ServerPlayerEntity) player);
        return mana;
    }

    public static int removeMana(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int mana = nbt.getInt("mana");
        if(mana - amount < 0) {
            mana = 0;
        } else {
            mana -= amount;
        }

        nbt.putInt("mana", mana);
        syncMana(mana, (ServerPlayerEntity) player);
        return mana;
    }


    public static void syncMana(int mana, ServerPlayerEntity player){
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(mana);
        ServerPlayNetworking.send(player, ModMessages.MANA_SYNC_ID, buffer);
    }
}
