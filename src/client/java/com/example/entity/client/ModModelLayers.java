package com.example.entity.client;

import com.example.TutorialMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer PORCUPINE =
            new EntityModelLayer(new Identifier(TutorialMod.MODID, "porcupine"), "main");

    public static final EntityModelLayer MOMODOGGY =
            new EntityModelLayer(new Identifier(TutorialMod.MODID, "momo_doggy"), "main");
}
