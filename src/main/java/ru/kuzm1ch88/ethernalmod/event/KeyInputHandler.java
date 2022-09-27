package ru.kuzm1ch88.ethernalmod.event;


import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.impl.networking.client.ClientPlayNetworkAddon;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;
import ru.kuzm1ch88.ethernalmod.networking.ModMessages;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_ETHERNAL = "key.categoty.ethernalmod";
    public static final String KEY_ITEM_USE = "key.item_use";


    public static KeyBinding useItemKey;


    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(useItemKey.wasPressed()){
                ClientPlayNetworking.send(ModMessages.MANA_USE_ID, PacketByteBufs.create());
            }
        });
    }

    public static void register(){
        useItemKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
           KEY_ITEM_USE,
           InputUtil.Type.KEYSYM,
           GLFW.GLFW_KEY_O,
           KEY_CATEGORY_ETHERNAL
        ));
    }
}
