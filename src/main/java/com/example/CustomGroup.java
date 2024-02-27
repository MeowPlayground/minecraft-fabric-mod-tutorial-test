package com.example;

import com.example.blocks.RegisterBlocks;
import com.example.items.RegisterItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class CustomGroup {
    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(RegisterItems.CUSTOM_ITEM))
            .displayName(Text.translatable("itemGroup.tutorial.test_group"))
            .entries(((displayContext, entries) -> {
                entries.add(RegisterItems.CUSTOM_ITEM);
                entries.add(RegisterItems.CUSTOM_MATERIAL_HELMET);
                entries.add(RegisterItems.CUSTOM_MATERIAL_CHESTPLATE);
                entries.add(RegisterItems.CUSTOM_MATERIAL_LEGGINGS);
                entries.add(RegisterItems.CUSTOM_MATERIAL_BOOTS);
                entries.add(RegisterItems.CUSTOM_MATERIAL_SHOVEL);
                entries.add(RegisterItems.CUSTOM_MATERIAL_PICKAXE);
                entries.add(RegisterItems.CUSTOM_MATERIAL_AXE);
                entries.add(RegisterItems.CUSTOM_MATERIAL_HOE);
                entries.add(RegisterItems.CUSTOM_MATERIAL_SWORD);
                entries.add(RegisterBlocks.CUSTOM_BLOCK);
                entries.add(RegisterBlocks.CHARGEABLE_BLOCK);
                entries.add(RegisterBlocks.SOUND_BLOCK);
                entries.add(RegisterItems.TOMATO);
            }))
            .build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(RegisterItems.MODID, "test_group"), ITEM_GROUP);
    }
}

