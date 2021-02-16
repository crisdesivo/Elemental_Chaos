package com.example.elementalchaos.elementalItems;

import com.example.elementalchaos.magic.ManaPool;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;


public abstract class ElementalItem extends TieredItem implements IVanishable {
    public  String currentManaIdentifier = "currentMana";
    public  ManaPool maxMana;
    public ManaPool manaRequirement;

    public ElementalItem(IItemTier tier, Properties builderIn) {
        super(tier, builderIn);
    }

    public void saveMaxMana(ItemStack stack){
        maxMana.saveToStack(stack, currentManaIdentifier);
    }

    public void initializeItem(ItemStack stack){
        maxMana = defineMaxMana();
        manaRequirement = defineManaCost();
        saveMaxMana(stack);
        stack.getOrCreateTag().putBoolean("Created", true);
    }

    public abstract ManaPool defineMaxMana();
    public abstract ManaPool defineManaCost();

    @Override
    public abstract void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn);

    public abstract void updateOnPlayerInventory(ItemStack stack, World worldIn, PlayerEntity playerIn);

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn){
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (!worldIn.isRemote()){
            if (!stack.getOrCreateTag().getBoolean("Created")) {
                initializeItem(stack);
                onCreated(stack, worldIn, (PlayerEntity) entityIn);
            }
            else {
                if (entityIn instanceof PlayerEntity) {
                    updateOnPlayerInventory(stack, worldIn, (PlayerEntity) entityIn);
                }
            }
        }
    }
}

