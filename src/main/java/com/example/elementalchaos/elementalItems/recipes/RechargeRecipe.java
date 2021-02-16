package com.example.elementalchaos.elementalItems.recipes;


import com.example.elementalchaos.ModItemTier;
import com.example.elementalchaos.RegistryHandler;
import com.example.elementalchaos.elementalItems.items.HasteSpell;
import com.google.gson.JsonObject;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.SpecialRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.*;

import static com.example.elementalchaos.RegistryHandler.CHAOS_NUGGET;

public class RechargeRecipe extends SpecialRecipe {
    public RechargeRecipe(ResourceLocation idIn) {
        super(idIn);
    }

    @Override
    public boolean matches(CraftingInventory inv, World worldIn) {
        Set<Item> itemSet = new HashSet();
        itemSet.add(CHAOS_NUGGET.get());
        return inv.hasAny(itemSet);
    }

    @Override
    public ItemStack getCraftingResult(CraftingInventory inv) {
        return new HasteSpell(ModItemTier.FIRE_STAFF, (new Item.Properties()).group(ItemGroup.COMBAT)).getDefaultInstance();
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInventory inv) {
        return NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);
    }

    @Override
    public boolean canFit(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public ResourceLocation getId() {
        return new ResourceLocation("elementalchaos:recharge");
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return RegistryHandler.RECHARGE.get();
    }

    public static final class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<RechargeRecipe> {
        @Override
        public RechargeRecipe read(ResourceLocation recipeId, JsonObject json) {
            return new RechargeRecipe(recipeId);
        }

        @Override
        public RechargeRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            return new RechargeRecipe(recipeId);
        }

        @Override
        public void write(PacketBuffer buffer, RechargeRecipe recipe) {}
    }
}
