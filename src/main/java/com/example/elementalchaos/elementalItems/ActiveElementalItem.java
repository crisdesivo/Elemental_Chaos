package com.example.elementalchaos.elementalItems;

import com.example.elementalchaos.magic.ManaPool;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public abstract class ActiveElementalItem extends ElementalItem{

    public ActiveElementalItem(IItemTier tier, Properties builderIn) {
        super(tier, builderIn);
        initializeMana();
    }

    //float chaos, float order, float wind, float fire, float ice,
    public void initializeMana(){
        maxMana = defineMaxMana();
        manaRequirement = defineManaCost();
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        ManaPool currentMana = new ManaPool(stack, currentManaIdentifier);

        if(currentMana.contains(manaRequirement)){
            rightClickAction(worldIn, playerIn, handIn, stack);
            currentMana.consume(manaRequirement);
            currentMana.saveToStack(stack, currentManaIdentifier);
        }
        else{
            System.out.println("Not enough mana.");
            System.out.println("Current mana:");
            currentMana.print();
            System.out.println("Necessary mana:");
            manaRequirement.print();
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public abstract void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn, ItemStack stack);
}
