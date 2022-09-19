package ru.kuzm1ch88.ethernalmod.item.custom;


import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HolyCross extends Item {

    public HolyCross(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()){
            tooltip.add((Text.literal("Traditionally, it is a religious symbol of Christianity and an object of religious veneration in a number of Christian denominations. The cross is made of pure gold. Clearly worth a lot!").formatted(Formatting.YELLOW)));
        }else{
            tooltip.add((Text.translatable("item.ethernalmod.holy_cross.tooltip").formatted(Formatting.YELLOW)));
        }


        super.appendTooltip(stack, world, tooltip, context);
    }
}