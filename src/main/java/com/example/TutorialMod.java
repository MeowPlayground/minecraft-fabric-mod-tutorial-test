package com.example;

import com.example.block.ModBlocks;
import com.example.enchantment.RegisterEnchantments;
import com.example.entity.ModEntities;
import com.example.entity.custom.PorcupineEntity;
import com.example.item.ModItems;
import com.example.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TutorialMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("template-mod");
    public static final String MODID = "tutorial";


    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        CustomGroup.register();
        ModBlocks.register();
        ModItems.register();
        RegisterEnchantments.register();
        ModSounds.register();
        ModEntities.register();

        FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
        LOGGER.info("Hello Fabric world!");
    }


}