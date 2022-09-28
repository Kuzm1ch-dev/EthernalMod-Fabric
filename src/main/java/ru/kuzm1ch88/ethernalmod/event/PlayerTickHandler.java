package ru.kuzm1ch88.ethernalmod.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import ru.kuzm1ch88.ethernalmod.utils.IEntityDataSaver;
import ru.kuzm1ch88.ethernalmod.utils.ManaData;

import java.util.Random;

public class PlayerTickHandler implements ServerTickEvents.StartTick{
    @Override
    public void onStartTick(MinecraftServer server) {
        for(ServerPlayerEntity player : server.getPlayerManager().getPlayerList())
        {
            if (new Random().nextFloat() <= 0.05f){
                IEntityDataSaver dataPlayer = ((IEntityDataSaver) player);
                ManaData.addMana(dataPlayer, 1);
                player.sendMessage(Text.literal("Mana restore! " + ManaData.getMana(dataPlayer)));
            }
        }
    }
}
