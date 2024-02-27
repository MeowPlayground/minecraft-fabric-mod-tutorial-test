package com.example.datagen;

import com.example.blocks.ChargeableBlock;
import com.example.blocks.RegisterBlocks;
import com.example.items.RegisterItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import static net.minecraft.data.client.BlockStateModelGenerator.createBooleanModelMap;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.CUSTOM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.SOUND_BLOCK);
        registerChargeableBlock(blockStateModelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(RegisterItems.CUSTOM_ITEM, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.CUSTOM_MATERIAL_AXE, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.CUSTOM_MATERIAL_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.CUSTOM_MATERIAL_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.CUSTOM_MATERIAL_SWORD, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.CUSTOM_MATERIAL_HOE, Models.GENERATED);

        itemModelGenerator.register(RegisterItems.CUSTOM_MATERIAL_HELMET, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.CUSTOM_MATERIAL_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.CUSTOM_MATERIAL_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(RegisterItems.CUSTOM_MATERIAL_BOOTS, Models.GENERATED);
    }

    private void registerChargeableBlock(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = TexturedModel.CUBE_ALL.upload(RegisterBlocks.CHARGEABLE_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(RegisterBlocks.CHARGEABLE_BLOCK, "_charged", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(RegisterBlocks.CHARGEABLE_BLOCK).coordinate(createBooleanModelMap(ChargeableBlock.CHARGED, identifier2, identifier)));
    }
}