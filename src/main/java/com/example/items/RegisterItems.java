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
    public static final Item CUSTOM_ITEM = new CustomItem(new FabricItemSettings());

    //custom armor
    public static final Item CUSTOM_MATERIAL_HELMET = new ArmorItem(CUSTOM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item CUSTOM_MATERIAL_CHESTPLATE = new ArmorItem(CUSTOM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item CUSTOM_MATERIAL_LEGGINGS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item CUSTOM_MATERIAL_BOOTS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());

    //custom tool
    public static ToolItem CUSTOM_MATERIAL_SHOVEL = new ShovelItem(CustomToolMaterials.INSTANCE, 1.5F, -3.0F, new Item.Settings());
    public static ToolItem CUSTOM_MATERIAL_PICKAXE = new CustomPickaxeItem(CustomToolMaterials.INSTANCE, 1, -2.8F, new Item.Settings());
    public static ToolItem CUSTOM_MATERIAL_AXE = new CustomAxeItem(CustomToolMaterials.INSTANCE, 6.0F, -3.0F, new Item.Settings());
    public static ToolItem CUSTOM_MATERIAL_HOE = new CustomHoeItem(CustomToolMaterials.INSTANCE, -3, 0.0F, new Item.Settings());
    public static ToolItem CUSTOM_MATERIAL_SWORD = new SwordItem(CustomToolMaterials.INSTANCE, 3, -2.4F, new Item.Settings());


    public static void register() {


        CompostingChanceRegistry.INSTANCE.add(CUSTOM_ITEM, 0.5F);
        FuelRegistry.INSTANCE.add(CUSTOM_ITEM, 300);

        Registry.register(Registries.ITEM, new Identifier(MODID, "custom_item"), CUSTOM_ITEM);
        Registry.register(Registries.ITEM, new Identifier(MODID, "custom_material_helmet"), CUSTOM_MATERIAL_HELMET);
        Registry.register(Registries.ITEM, new Identifier(MODID, "custom_material_chestplate"), CUSTOM_MATERIAL_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier(MODID, "custom_material_leggings"), CUSTOM_MATERIAL_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier(MODID, "custom_material_boots"), CUSTOM_MATERIAL_BOOTS);

        Registry.register(Registries.ITEM, new Identifier(MODID, "custom_material_shovel"), CUSTOM_MATERIAL_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier(MODID, "custom_material_pickaxe"), CUSTOM_MATERIAL_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier(MODID, "custom_material_axe"), CUSTOM_MATERIAL_AXE);
        Registry.register(Registries.ITEM, new Identifier(MODID, "custom_material_hoe"), CUSTOM_MATERIAL_HOE);
        Registry.register(Registries.ITEM, new Identifier(MODID, "custom_material_sword"), CUSTOM_MATERIAL_SWORD);
    }
}
