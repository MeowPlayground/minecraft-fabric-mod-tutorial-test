package com.example;

import com.example.block.ModBlocks;
import com.example.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class CustomGroup {
    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.CUSTOM_ITEM))
            .displayName(Text.translatable("itemGroup.tutorial.test_group"))
            .entries(((displayContext, entries) -> {
                entries.add(ModItems.CUSTOM_ITEM);
                entries.add(ModItems.CUSTOM_MATERIAL_HELMET);
                entries.add(ModItems.CUSTOM_MATERIAL_CHESTPLATE);
                entries.add(ModItems.CUSTOM_MATERIAL_LEGGINGS);
                entries.add(ModItems.CUSTOM_MATERIAL_BOOTS);
                entries.add(ModItems.CUSTOM_MATERIAL_SHOVEL);
                entries.add(ModItems.CUSTOM_MATERIAL_PICKAXE);
                entries.add(ModItems.CUSTOM_MATERIAL_AXE);
                entries.add(ModItems.CUSTOM_MATERIAL_HOE);
                entries.add(ModItems.CUSTOM_MATERIAL_SWORD);
                entries.add(ModBlocks.CUSTOM_BLOCK);
                entries.add(ModBlocks.CHARGEABLE_BLOCK);
                entries.add(ModBlocks.SOUND_BLOCK);
                entries.add(ModItems.TOMATO);
                entries.add(ModItems.TOMATO_SEEDS);
                entries.add(ModItems.CORN);
                entries.add(ModItems.CORN_SEEDS);
                entries.add(ModBlocks.DAHLIA);
                entries.add(ModItems.MUSIC_DISC_HNO);
                entries.add(ModItems.PORCUPINE_SPAWN_EGG);
                entries.add(ModItems.MOMODOGGY_SPAWN_EGG);
            }))
            .build();

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(TutorialMod.MODID, "test_group"), ITEM_GROUP);
    }
}

