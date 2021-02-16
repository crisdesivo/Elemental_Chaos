package com.example.elementalchaos;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

/*    */
/*    */
/*    */
/*    */
/*    */ public enum ModItemTier implements IItemTier {
    /* 10 */   MYWAND(1, 131, 4.0F, 3.0F, 5, () -> Ingredient.fromItems(RegistryHandler.MYWAND.get())),
    /*    */   NETHER_STAR_SWORD(1, 10000, 4.0F, 3.0F, 5, () -> Ingredient.fromItems(RegistryHandler.NETHER_STAR_SWORD.get())),
    /*    */   OBSIDIAN_SWORD(1, 1000, 4.0F, 3.0F, 5, () -> Ingredient.fromItems(RegistryHandler.OBSIDIAN_SWORD.get())),
               FIRE_STAFF(1, 50, 1.0F, 0, 5, () -> Ingredient.fromItems(RegistryHandler.FIRE_STAFF.get()));


    /*    */   private final Supplier<Ingredient> repairmaterial;
    /*    */
    /*    */   private final int enchantability;
    /*    */
    /*    */   private final float attackDamage;
    /*    */
    /*    */   private final float efficiency;
    /*    */
    /*    */   private final int maxUses;
    /*    */
    /*    */   private final int harvestLevel;
    /*    */
    /*    */   ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairmaterial) {
        /* 25 */     this.harvestLevel = harvestLevel;
        /* 26 */     this.maxUses = maxUses;
        /* 27 */     this.efficiency = efficiency;
        /* 28 */     this.attackDamage = attackDamage;
        /* 29 */     this.enchantability = enchantability;
        /* 30 */     this.repairmaterial = repairmaterial;
        /*    */   }
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */   public int func_200926_a() {
        /* 37 */     return this.maxUses;
        /*    */   }
    /*    */
    /*    */
    /*    */   public float func_200928_b() {
        /* 42 */     return this.efficiency;
        /*    */   }
    /*    */
    /*    */
    /*    */   public float func_200929_c() {
        /* 47 */     return this.attackDamage;
        /*    */   }
    /*    */
    /*    */
    /*    */   public int func_200925_d() {
        /* 52 */     return this.harvestLevel;
        /*    */   }
    /*    */
    /*    */
    /*    */   public int func_200927_e() {
        /* 57 */     return this.enchantability;
        /*    */   }
    /*    */
    /*    */
    /*    */   public Ingredient func_200924_f() {
        /* 62 */     return this.repairmaterial.get();
        /*    */   }

    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return (Ingredient) this.repairmaterial;
    }
    /*    */ }