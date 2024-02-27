package com.example.datagen;

import com.example.blocks.RegisterBlocks;
import com.example.items.RegisterItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(RegisterBlocks.CHARGEABLE_BLOCK);
        addDrop(RegisterBlocks.SOUND_BLOCK);
        addDrop(RegisterBlocks.CUSTOM_BLOCK, copperOreLikeDrops(RegisterBlocks.CUSTOM_BLOCK, RegisterItems.CUSTOM_ITEM));
    }

    public LootTable.Builder copperOreLikeDrops(Block drop, Item item) {
        return dropsWithSilkTouch(drop,
                this.applyExplosionDecay(drop, ItemEntry.builder(item)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }


}
