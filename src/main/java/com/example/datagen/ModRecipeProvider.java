package com.example.datagen;


import com.example.blocks.RegisterBlocks;
import com.example.items.RegisterItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;


public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, RegisterItems.CUSTOM_ITEM, RecipeCategory.DECORATIONS, RegisterBlocks.CHARGEABLE_BLOCK);

        offer2x2CompactingRecipe(exporter, RecipeCategory.MISC, RegisterBlocks.SOUND_BLOCK, RegisterItems.CUSTOM_ITEM);

        
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.CUSTOM_MATERIAL_PICKAXE, 1)
                .pattern("SSS")
                .pattern(" T ")
                .pattern(" T ")
                .input('S', RegisterItems.CUSTOM_ITEM)
                .input('T', Items.STICK)
                .criterion(hasItem(RegisterItems.CUSTOM_ITEM), conditionsFromItem(RegisterItems.CUSTOM_ITEM))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterItems.CUSTOM_MATERIAL_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.CUSTOM_MATERIAL_SWORD, 1)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" T ")
                .input('S', RegisterItems.CUSTOM_ITEM)
                .input('T', Items.STICK)
                .criterion(hasItem(RegisterItems.CUSTOM_ITEM), conditionsFromItem(RegisterItems.CUSTOM_ITEM))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterItems.CUSTOM_MATERIAL_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.CUSTOM_MATERIAL_SHOVEL, 1)
                .pattern(" S ")
                .pattern(" T ")
                .pattern(" T ")
                .input('S', RegisterItems.CUSTOM_ITEM)
                .input('T', Items.STICK)
                .criterion(hasItem(RegisterItems.CUSTOM_ITEM), conditionsFromItem(RegisterItems.CUSTOM_ITEM))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterItems.CUSTOM_MATERIAL_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.CUSTOM_MATERIAL_AXE, 1)
                .pattern("SS ")
                .pattern("ST ")
                .pattern(" T ")
                .input('S', RegisterItems.CUSTOM_ITEM)
                .input('T', Items.STICK)
                .criterion(hasItem(RegisterItems.CUSTOM_ITEM), conditionsFromItem(RegisterItems.CUSTOM_ITEM))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterItems.CUSTOM_MATERIAL_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.CUSTOM_MATERIAL_HOE, 1)
                .pattern("SS ")
                .pattern(" T ")
                .pattern(" T ")
                .input('S', RegisterItems.CUSTOM_ITEM)
                .input('T', Items.STICK)
                .criterion(hasItem(RegisterItems.CUSTOM_ITEM), conditionsFromItem(RegisterItems.CUSTOM_ITEM))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterItems.CUSTOM_MATERIAL_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.CUSTOM_MATERIAL_HELMET, 1)
                .pattern("SSS")
                .pattern("S S")
                .input('S', RegisterItems.CUSTOM_ITEM)
                .criterion(hasItem(RegisterItems.CUSTOM_ITEM), conditionsFromItem(RegisterItems.CUSTOM_ITEM))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterItems.CUSTOM_MATERIAL_HELMET)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.CUSTOM_MATERIAL_CHESTPLATE, 1)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', RegisterItems.CUSTOM_ITEM)
                .criterion(hasItem(RegisterItems.CUSTOM_ITEM), conditionsFromItem(RegisterItems.CUSTOM_ITEM))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterItems.CUSTOM_MATERIAL_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.CUSTOM_MATERIAL_LEGGINGS, 1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', RegisterItems.CUSTOM_ITEM)
                .criterion(hasItem(RegisterItems.CUSTOM_ITEM), conditionsFromItem(RegisterItems.CUSTOM_ITEM))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterItems.CUSTOM_MATERIAL_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, RegisterItems.CUSTOM_MATERIAL_BOOTS, 1)
                .pattern("S S")
                .pattern("S S")
                .input('S', RegisterItems.CUSTOM_ITEM)
                .criterion(hasItem(RegisterItems.CUSTOM_ITEM), conditionsFromItem(RegisterItems.CUSTOM_ITEM))
                .offerTo(exporter, new Identifier(getRecipeName(RegisterItems.CUSTOM_MATERIAL_BOOTS)));


    }
}
