package com.example.blocks;

import com.example.TutorialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class RegisterBlocks {
    public static final String MODID = "tutorial";
    public static final Block CUSTOM_BLOCK = registerBlock("custom_block",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(2, 5),
                    FabricBlockSettings.copyOf(Blocks.STONE).strength(4.0f))
    );
    public static final Block CHARGEABLE_BLOCK =
            registerBlock("chargeable_block", new ChargeableBlock(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block SOUND_BLOCK =
            registerBlock("sound_block", new SoundBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL)));

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MODID, name), block);
    }

    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(MODID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void register() {
        TutorialMod.LOGGER.info("register Blocks");
    }

}
