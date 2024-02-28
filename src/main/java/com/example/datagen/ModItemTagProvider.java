package com.example.datagen;

import com.example.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }


    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(
                        ModItems.CUSTOM_MATERIAL_HELMET,
                        ModItems.CUSTOM_MATERIAL_CHESTPLATE,
                        ModItems.CUSTOM_MATERIAL_LEGGINGS,
                        ModItems.CUSTOM_MATERIAL_BOOTS
                );
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS).add(ModItems.MUSIC_DISC_HNO);
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS).add(ModItems.MUSIC_DISC_HNO);
    }
}
