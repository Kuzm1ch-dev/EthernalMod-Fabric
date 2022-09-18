package ru.kuzm1ch88.ethernalmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import ru.kuzm1ch88.ethernalmod.EthernalMod;

public class ModItemsGroup {
    public static final ItemGroup ETHERNAL_MOD = FabricItemGroupBuilder.build(new Identifier(EthernalMod.MOD_ID,
            "ethernal"), () -> new ItemStack(ModItems.BRONZE_INGOT));
}
