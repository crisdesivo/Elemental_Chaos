package com.example.elementalchaos.elementalItems.recipes;

import com.example.elementalchaos.ElementalChaos;
import com.example.elementalchaos.RegistryHandler;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModRecipes {
    public static final RegistryObject<IRecipeSerializer<?>> RECHARGE = register(new ResourceLocation("elementalchaos:recharge"), () -> new SpecialRecipeSerializer<>(RechargeRecipe::new));


    private static RegistryObject<IRecipeSerializer<?>> register(ResourceLocation id, Supplier<IRecipeSerializer<?>> serializer) {

        return RegistryHandler.RECIPE_SERIALIZERS.register(id.getPath(), serializer);
    }

}
