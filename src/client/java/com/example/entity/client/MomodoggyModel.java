package com.example.entity.client;

import com.example.entity.animation.MomodoggyAnimations;
import com.example.entity.custom.MomodoggyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class MomodoggyModel<T extends MomodoggyEntity> extends SinglePartEntityModel<T> {
    private final ModelPart momodoggy;
    private final ModelPart head;

    public MomodoggyModel(ModelPart root) {
        this.momodoggy = root.getChild("momodoggy");
        this.head = momodoggy.getChild("body").getChild("torso").getChild("head");

    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData momodoggy = modelPartData.addChild("momodoggy", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 22.0F, -5.0F));

        ModelPartData body = momodoggy.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head = torso.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -7.75F, 1.0F));

        ModelPartData skull = head.addChild("skull", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -10.0F, -4.0F, 6.0F, 6.0F, 5.0F, new Dilation(0.0F))
                .uv(3, 18).cuboid(-1.25F, -6.75F, -6.75F, 2.5F, 2.75F, 2.75F, new Dilation(0.0F))
                .uv(28, 24).cuboid(-0.5F, -6.85F, -7.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 7.75F, -1.0F));

        ModelPartData right_ear = skull.addChild("right_ear", ModelPartBuilder.create().uv(0, 11).cuboid(-4.0F, -3.0F, 0.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-5.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -9.0F, -2.0F, 0.0F, 0.0F, 1.9199F));

        ModelPartData left_ear = skull.addChild("left_ear", ModelPartBuilder.create().uv(0, 11).cuboid(0.0F, -3.0F, 0.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(4.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -9.0F, -2.0F, 0.0F, 0.0F, -1.9199F));

        ModelPartData body2 = torso.addChild("body2", ModelPartBuilder.create().uv(4, 16).cuboid(-2.0F, -8.0F, 1.0F, 4.0F, 6.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData left_front_led = torso.addChild("left_front_led", ModelPartBuilder.create().uv(24, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.25F, -3.0F, 2.75F));

        ModelPartData right_front_led = torso.addChild("right_front_led", ModelPartBuilder.create().uv(24, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.25F, -3.0F, 2.75F));

        ModelPartData right_behind_led = torso.addChild("right_behind_led", ModelPartBuilder.create().uv(24, 0).mirrored().cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(1.25F, -3.0F, 9.5F));

        ModelPartData left_behind_led = torso.addChild("left_behind_led", ModelPartBuilder.create().uv(24, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.25F, -3.0F, 9.5F));

        ModelPartData tail = torso.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -7.25F, 10.25F));

        ModelPartData cube_r1 = tail.addChild("cube_r1", ModelPartBuilder.create().uv(0, 19).cuboid(-0.5F, 0.25F, 0.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.75F, -0.25F, 0.4363F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }


    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);
        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        momodoggy.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return momodoggy;
    }

    @Override
    public void setAngles(MomodoggyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);
        this.animateMovement(MomodoggyAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);

    }
}