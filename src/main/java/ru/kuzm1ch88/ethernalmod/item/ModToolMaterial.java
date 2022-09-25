package ru.kuzm1ch88.ethernalmod.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    BRONZE(2, 400, 3.0F, 6.0F, 20,
            () -> Ingredient.ofItems(ModItems.BRONZE_INGOT)),

    EROBI(4, 1000, 6.5F, 7.0F, 15,
            () -> Ingredient.ofItems(ModItems.EROBI_INGOT)),
    MORIUT(5, 1800, 7.0F, 10.0F, 15,
                      () -> Ingredient.ofItems(ModItems.MORIUT_INGOT)),
    TARGARIT(5, 500, 10.0F, 7.0F, 15,
                   () -> Ingredient.ofItems(ModItems.TARGARIT_INGOT)),
    HROZ(5, 1500, 8.0F, 7.0F, 30,
            () -> Ingredient.ofItems(ModItems.HROZ_INGOT)),
    TRAWITIN(5, 1200, 7.0F, 5.0F, 30,
            () -> Ingredient.ofItems(ModItems.TRAWITIN_INGOT)),
    MOROBI(6, 2400, 12.0F, 8.0F, 30,
            () -> Ingredient.ofItems(ModItems.MOROBI_INGOT)),
    FILIOT(6, 3000, 14.0F, 7.0F, 30,
            () -> Ingredient.ofItems(ModItems.FILIOT_INGOT)),
    CLEOMENIS(6, 6000, 6.0F, 14.0F, 30,
            () -> Ingredient.ofItems(ModItems.CLEOMENIS_INGOT)),
    COLD_IRON(6, 800, 20.0F, 20.0F, 30,
            () -> Ingredient.ofItems(ModItems.COLD_IRON_INGOT)),
    HROZIFIL(6, 2400, 12.0F, 8.0F, 30,
            () -> Ingredient.ofItems(ModItems.HROZIFIL_INGOT)),
    TARFILIOT(6, 3500, 16.0F, 6.0F, 30,
            () -> Ingredient.ofItems(ModItems.TARFILIOT_INGOT)),
    FROZEN_MAGMATIC_IRON(7, 7000, 18, 12.0F, 30,
            () -> Ingredient.ofItems(ModItems.FROZEN_MAGMATIC_IRON_INGOT));


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    private ModToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage,
                            int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
