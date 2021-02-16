package com.example.elementalchaos.elementalItems.items;

import com.example.elementalchaos.elementalItems.PassiveElementalSpell;
import com.example.elementalchaos.magic.ManaPool;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import static net.minecraft.potion.Effects.HASTE;

public class HasteSpell extends PassiveElementalSpell {
    public HasteSpell(IItemTier tier, Properties builderIn) {
        super(tier, builderIn);
    }

    public ManaPool defineMaxMana(){
        return new ManaPool(8, 4, 4, 6, 0);
    }

    public ManaPool defineManaCost(){
        ManaPool manaCost = new ManaPool(2, 1, 1, 1, 0);
        return manaCost;
    }

    public void passiveEffect(ItemStack stack, World worldIn, PlayerEntity playerIn){
        EffectInstance eff = new EffectInstance(HASTE, 100);
        playerIn.addPotionEffect(eff);
    }

    public int defineRefreshRate(){
        return 100;
    }

}
