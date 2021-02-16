package com.example.elementalchaos.elementalItems;

import com.example.elementalchaos.magic.ManaPool;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public abstract class PassiveElementalSpell extends ElementalItem{
    public int refreshRate;

    public PassiveElementalSpell(IItemTier tier, Properties builderIn) {
        super(tier, builderIn);
        refreshRate = defineRefreshRate();
        manaRequirement = defineManaCost();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (!worldIn.isRemote()){
            ItemStack stack = playerIn.getHeldItem(handIn);
            if (!stack.getOrCreateTag().getBoolean("active")) {
                ManaPool currentMana = new ManaPool(stack, currentManaIdentifier);
                if (currentMana.contains(manaRequirement)) {
                    stack.getOrCreateTag().putBoolean("active", true);
                    System.out.println("Activated");
                    passiveEffect(stack, worldIn, playerIn);
                }
                else{
                    System.out.println("Not enough mana to activate.");
                }
            }
            else{
                System.out.println("Deactivated");
                stack.getOrCreateTag().putBoolean("active", false);
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public abstract int defineRefreshRate();
    public abstract void passiveEffect(ItemStack stack, World worldIn, PlayerEntity playerIn);

    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn){
    }

    public void updateOnPlayerInventory(ItemStack stack, World worldIn, PlayerEntity playerIn){
        long gameTicks = worldIn.getGameTime();
        if (gameTicks % refreshRate == 0) {
            if (stack.getOrCreateTag().getBoolean("active")) {
                ManaPool currentMana = new ManaPool(stack, currentManaIdentifier);
                if(currentMana.contains(manaRequirement)){
                    currentMana.consume(manaRequirement);
                    currentMana.saveToStack(stack, currentManaIdentifier);
                    passiveEffect(stack, worldIn, playerIn);
                }
                else{
                    stack.getOrCreateTag().putBoolean("active", false);
                    System.out.println("Not enough mana.");
                    System.out.println("Current mana:");
                    currentMana.print();
                    System.out.println("Necessary mana:");
                    manaRequirement.print();
                }
            }
        }
    }
}

