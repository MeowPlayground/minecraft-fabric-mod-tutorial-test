package com.example.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterBlocks {
    public static final String MODID = "tutorial";
    public static final Block CUSTOM_BLOCK = new CustomBlock(FabricBlockSettings.create().strength(4.0f).requiresTool());
    public static final ChargeableBlock CHARGEABLE_BLOCK = new ChargeableBlock(FabricBlockSettings.copyOf(Blocks.STONE));

    public static void register() {
        Registry.register(Registries.BLOCK, new Identifier(MODID, "custom_block"), CUSTOM_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(MODID, "custom_block"), new BlockItem(CUSTOM_BLOCK, new FabricItemSettings()));
        Registry.register(Registries.BLOCK, new Identifier(MODID, "chargeable_block"), CHARGEABLE_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(MODID, "chargeable_block"), new BlockItem(CHARGEABLE_BLOCK, new FabricItemSettings()));

    }

}
