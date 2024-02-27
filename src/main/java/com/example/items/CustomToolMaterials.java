package com.example.items;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class CustomToolMaterials implements ToolMaterial {
    public static final CustomToolMaterials INSTANCE = new CustomToolMaterials();

    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6.0F;
    }

    @Override
    public float getAttackDamage() {
        return 3.0F;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RegisterItems.CUSTOM_ITEM);
    }
}
