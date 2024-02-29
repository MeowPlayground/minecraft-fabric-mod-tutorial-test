package com.example.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class CustomFootComponents {
    public static final FoodComponent TOMATO = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200), 0.8f)
            .build();

    public static final FoodComponent CORN = new FoodComponent.Builder()
            .hunger(2)
            .saturationModifier(0.2f)
            .build();
}
