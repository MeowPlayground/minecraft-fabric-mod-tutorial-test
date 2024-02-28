package com.example.items.custom;

import com.example.items.materials.CustomArmorMaterial;
import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Map;

public class CustomArmorItem extends ArmorItem {

    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(CustomArmorMaterial.CUSTOM_ITEM, new StatusEffectInstance(StatusEffects.HASTE,
                            200, 0, false, false, true))
                    .build();

    public CustomArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player && hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();
            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapStatusEffect);
            }

        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, StatusEffectInstance statusEffect) {
        boolean hasPlayerEffect = player.hasStatusEffect(statusEffect.getEffectType());
        if (!hasPlayerEffect) {
            player.addStatusEffect(new StatusEffectInstance(statusEffect));
        }

    }

    public boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !(boots.isEmpty() || leggings.isEmpty() || breastplate.isEmpty() || helmet.isEmpty());
    }

    public boolean hasCorrectArmorOn(ArmorMaterial armorMaterial, PlayerEntity player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem breastplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();

        return helmet.getMaterial() == armorMaterial && breastplate.getMaterial() == armorMaterial
                && leggings.getMaterial() == armorMaterial && boots.getMaterial() == armorMaterial;
    }
}
