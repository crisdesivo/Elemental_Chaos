package com.example.elementalchaos;
import com.example.elementalchaos.elementalItems.ActiveElementalItem;
import com.example.elementalchaos.magic.ManaPool;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.Hand;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.entity.projectile.FireballEntity;

import static net.minecraft.potion.Effects.HASTE;

public class FireballStaff extends ActiveElementalItem {
    public int maxUses = 7;

    public FireballStaff(IItemTier tier,  Properties builderIn) {
        super(tier, builderIn);
    }

    public ManaPool defineMaxMana(){
        return new ManaPool(8, 4, 4, 6, 0);
    }

    public ManaPool defineManaCost(){
        ManaPool manaCost = defineMaxMana();
        manaCost.chaos /= maxUses;
        manaCost.order /= maxUses;
        manaCost.wind /= maxUses;
        manaCost.fire /= maxUses;
        manaCost.ice /= maxUses;
        return manaCost;
    }


    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn){}

    public void updateOnPlayerInventory(ItemStack stack, World worldIn, PlayerEntity playerIn){}

    public void rightClickAction(World worldIn, PlayerEntity playerIn, Hand handIn, ItemStack stack){
        stack.damageItem(1, playerIn, (playerEntity) -> playerEntity.sendBreakAnimation(handIn));
        EffectInstance eff = new EffectInstance(HASTE, 100);
        playerIn.addPotionEffect(eff);
        playerIn.swing(handIn, false);
        Vector3d d3 = playerIn.getLookVec();
        FireballEntity fireball = new FireballEntity(worldIn, playerIn.chasingPosX, playerIn.chasingPosY, playerIn.chasingPosZ, d3.x, d3.y, d3.z);
        fireball.setPosition(playerIn.getPosX(), playerIn.getPosY()+1, playerIn.getPosZ());
        worldIn.addEntity(fireball);
    }

}
