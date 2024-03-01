package com.example.datagen;

import com.example.block.ModBlocks;
import com.example.block.custom.ChargeableBlock;
import com.example.block.custom.CornCropBlock;
import com.example.block.custom.TomatoCropBlock;
import com.example.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

import static net.minecraft.data.client.BlockStateModelGenerator.createBooleanModelMap;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CUSTOM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);
        registerChargeableBlock(blockStateModelGenerator);

        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_CROP, TomatoCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerCrop(ModBlocks.CORN_CROP, CornCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.DAHLIA, ModBlocks.POTTED_DAHLIA, BlockStateModelGenerator.TintType.NOT_TINTED);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CUSTOM_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.MUSIC_DISC_HNO, Models.GENERATED);

        itemModelGenerator.register(ModItems.PORCUPINE_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.MOMODOGGY_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CUSTOM_MATERIAL_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CUSTOM_MATERIAL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CUSTOM_MATERIAL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CUSTOM_MATERIAL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CUSTOM_MATERIAL_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.CUSTOM_MATERIAL_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.CUSTOM_MATERIAL_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.CUSTOM_MATERIAL_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.CUSTOM_MATERIAL_BOOTS);


    }

    private void registerChargeableBlock(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = TexturedModel.CUBE_ALL.upload(ModBlocks.CHARGEABLE_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(ModBlocks.CHARGEABLE_BLOCK, "_charged", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.CHARGEABLE_BLOCK).coordinate(createBooleanModelMap(ChargeableBlock.CHARGED, identifier2, identifier)));
    }
}
