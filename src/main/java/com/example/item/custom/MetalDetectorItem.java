package com.example.item.custom;

import com.example.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        if (player == null) {
            return ActionResult.FAIL;
        }
        if (!context.getWorld().isClient()) {
            BlockPos blockClickedPos = context.getBlockPos();
            boolean foundBlock = false;

            for (int i = 0; i < blockClickedPos.getY() + 63; i++) {
                BlockState state = context.getWorld().getBlockState(blockClickedPos.down(i));
                if (isValuableBlock(state)) {
                    foundBlock = true;
                    context.getWorld().playSound(null, blockClickedPos, ModSounds.METAL_DETECTOR_FOUND_ORE, SoundCategory.BLOCKS, 1f, 1f);
                    outputValuableCoordinates(blockClickedPos.down(i), player, state.getBlock());
                    break;
                }
            }
            if (!foundBlock) {
                player.sendMessage(Text.literal("No Valuables Found"), false);
            }
        }
        context.getStack().damage(1, context.getPlayer(), (playerEntity) -> playerEntity.sendToolBreakStatus(context.getHand()));

        return ActionResult.SUCCESS;

    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal(
                "Found" + block.asItem().asItem().getName().getString() +
                        "at" + "[" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + "]"
        ), false);
    }


    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.DIAMOND_ORE) || state.isOf(Blocks.IRON_ORE);
    }
}
