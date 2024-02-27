package com.example.items;

import com.example.items.tools.CustomAxeItem;
import com.example.items.tools.CustomHoeItem;
import com.example.items.tools.CustomPickaxeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterItems {
    public static final String MODID = "tutorial";

    public static final ArmorMaterial CUSTOM_ARMOR_MATERIAL = new CustomArmorMaterial();
    public static final Item CUSTOM_ITEM = registerItem("custom_item", new CustomItem(new FabricItemSettings()));

    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings().food(CustomFootComponents.TOMATO)));
    //custom armor
    public static final Item CUSTOM_MATERIAL_HELMET = registerItem("custom_material_helmet", new ArmorItem(CUSTOM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item CUSTOM_MATERIAL_CHESTPLATE = registerItem("custom_material_chestplate", new ArmorItem(CUSTOM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item CUSTOM_MATERIAL_LEGGINGS = registerItem("custom_material_leggings", new ArmorItem(CUSTOM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item CUSTOM_MATERIAL_BOOTS = registerItem("custom_material_boots", new ArmorItem(CUSTOM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()));

    //custom tool
    public static Item CUSTOM_MATERIAL_SHOVEL = registerItem("custom_material_shovel", new ShovelItem(CustomToolMaterials.INSTANCE, 1.5F, -3.0F, new Item.Settings()));
    public static Item CUSTOM_MATERIAL_PICKAXE = registerItem("custom_material_pickaxe", new CustomPickaxeItem(CustomToolMaterials.INSTANCE, 1, -2.8F, new Item.Settings()));
    public static Item CUSTOM_MATERIAL_AXE = registerItem("custom_material_axe", new CustomAxeItem(CustomToolMaterials.INSTANCE, 6.0F, -3.0F, new Item.Settings()));
    public static Item CUSTOM_MATERIAL_HOE = registerItem("custom_material_hoe", new CustomHoeItem(CustomToolMaterials.INSTANCE, -3, 0.0F, new Item.Settings()));
    public static Item CUSTOM_MATERIAL_SWORD = registerItem("custom_material_sword", new SwordItem(CustomToolMaterials.INSTANCE, 3, -2.4F, new Item.Settings()));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MODID, name), item);
    }

    public static void register() {
        CompostingChanceRegistry.INSTANCE.add(CUSTOM_ITEM, 0.5F);
        FuelRegistry.INSTANCE.add(CUSTOM_ITEM, 300);
    }
}