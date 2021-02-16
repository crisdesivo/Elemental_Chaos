package com.example.elementalchaos.elementalItems.recipes;

import net.minecraft.data.*;
import net.minecraft.item.crafting.SpecialRecipeSerializer;

import java.rmi.registry.RegistryHandler;
import java.util.function.Consumer;

public class ModRecipesProvider extends RecipeProvider {
    public ModRecipesProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    public String getName() {
        return "Elemental Chaos - Recipes";
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        CustomRecipeBuilder.customRecipe((SpecialRecipeSerializer<?>) ModRecipes.RECHARGE.get()).build(consumer, "elementalchaos:recharge");
    }

}
