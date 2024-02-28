package com.example.items;

import com.example.TutorialMod;
import com.example.blocks.ModBlocks;
import com.example.items.custom.CustomArmorItem;
import com.example.items.custom.CustomFootComponents;
import com.example.items.materials.CustomArmorMaterial;
import com.example.items.materials.CustomToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CUSTOM_ITEM = registerItem("custom_item",
            new Item(new FabricItemSettings()));

    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new AliasedBlockItem(ModBlocks.TOMATO_CROP, new FabricItemSettings()));
    public static final Item TOMATO = registerItem("tomato",
            new Item(new FabricItemSettings().food(CustomFootComponents.TOMATO)));

    public static final Item CORN_SEEDS = registerItem("corn_seeds",
            new AliasedBlockItem(ModBlocks.CORN_CROP, new FabricItemSettings()));
    
    public static final Item CORN = registerItem("corn",
            new Item(new FabricItemSettings().food(CustomFootComponents.CORN)));
    //custom armor
    public static final Item CUSTOM_MATERIAL_HELMET = registerItem("custom_material_helmet",
            new CustomArmorItem(CustomArmorMaterial.CUSTOM_ITEM, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item CUSTOM_MATERIAL_CHESTPLATE = registerItem("custom_material_chestplate",
            new ArmorItem(CustomArmorMaterial.CUSTOM_ITEM, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item CUSTOM_MATERIAL_LEGGINGS = registerItem("custom_material_leggings",
            new ArmorItem(CustomArmorMaterial.CUSTOM_ITEM, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item CUSTOM_MATERIAL_BOOTS = registerItem("custom_material_boots",
            new ArmorItem(CustomArmorMaterial.CUSTOM_ITEM, ArmorItem.Type.BOOTS, new Item.Settings()));

    //custom tool
    public static Item CUSTOM_MATERIAL_SHOVEL = registerItem("custom_material_shovel",
            new ShovelItem(CustomToolMaterial.CUSTOM_ITEM, 1.5F, -3.0F, new Item.Settings()));
    public static Item CUSTOM_MATERIAL_PICKAXE = registerItem("custom_material_pickaxe",
            new PickaxeItem(CustomToolMaterial.CUSTOM_ITEM, 1, -2.8F, new Item.Settings()));
    public static Item CUSTOM_MATERIAL_AXE = registerItem("custom_material_axe",
            new AxeItem(CustomToolMaterial.CUSTOM_ITEM, 6.0F, -3.0F, new Item.Settings()));
    public static Item CUSTOM_MATERIAL_HOE = registerItem("custom_material_hoe",
            new HoeItem(CustomToolMaterial.CUSTOM_ITEM, -3, 0.0F, new Item.Settings()));
    public static Item CUSTOM_MATERIAL_SWORD = registerItem("custom_material_sword",
            new SwordItem(CustomToolMaterial.CUSTOM_ITEM, 3, -2.4F, new Item.Settings()));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MODID, name), item);
    }

    public static void register() {
        CompostingChanceRegistry.INSTANCE.add(CUSTOM_ITEM, 0.5F);
        FuelRegistry.INSTANCE.add(CUSTOM_ITEM, 300);
    }
}