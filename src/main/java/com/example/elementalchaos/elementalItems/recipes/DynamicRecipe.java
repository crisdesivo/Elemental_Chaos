package com.example.elementalchaos.elementalItems.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class DynamicRecipe {
    private final ResourceLocation id;

    public DynamicRecipe(ResourceLocation idIn) {
        this.id = idIn;
    }

    public ResourceLocation getId() {
        return this.id;
    }


    public boolean isDynamic() {
        return true;
    }


    public ItemStack getRecipeOutput() {
        return ItemStack.EMPTY;
    }
}
