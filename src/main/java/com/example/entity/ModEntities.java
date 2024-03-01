package com.example.entity;

import com.example.TutorialMod;
import com.example.entity.custom.MomodoggyEntity;
import com.example.entity.custom.PorcupineEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<PorcupineEntity> PORCUPINE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MODID, "porcupine"),
            FabricEntityTypeBuilder.create(
                    SpawnGroup.CREATURE, PorcupineEntity::new
            ).dimensions(EntityDimensions.fixed(1f, 1f)).build()
    );

    public static final EntityType<MomodoggyEntity> MOMODOGGY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MODID, "momodoggy"),
            FabricEntityTypeBuilder.create(
                    SpawnGroup.CREATURE, MomodoggyEntity::new
            ).dimensions(EntityDimensions.fixed(1f, 1f)).build()
    );

    public static void register() {
        TutorialMod.LOGGER.info("Register Entities for" + TutorialMod.MODID);
        FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.MOMODOGGY, MomodoggyEntity.createMomodoggyAttributes());
    }
}
