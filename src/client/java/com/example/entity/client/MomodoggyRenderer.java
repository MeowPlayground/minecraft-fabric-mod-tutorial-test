package com.example.entity.client;

import com.example.TutorialMod;
import com.example.entity.custom.MomodoggyEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MomodoggyRenderer extends MobEntityRenderer<MomodoggyEntity, MomodoggyModel<MomodoggyEntity>> {
    private final static Identifier TEXTURE = new Identifier(TutorialMod.MODID, "textures/entity/momodoggy.png");

    public MomodoggyRenderer(EntityRendererFactory.Context context) {
        super(context, new MomodoggyModel<>(context.getPart(ModModelLayers.MOMODOGGY)), 0.06f);
    }

    @Override
    public Identifier getTexture(MomodoggyEntity entity) {
        return TEXTURE;
    }


    @Override
    public void render(MomodoggyEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
