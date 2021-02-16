package com.example.elementalchaos.magic;

import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ManaPool {
    public float chaos;
    public float order;
    public float wind;
    public float fire;
    public float ice;

    public float round2(Float x){
        return (float) Math.round(x*100.)/100;
    }

    public ManaPool(){}

    public ManaPool(ItemStack stack, String identifier){
        chaos = stack.getOrCreateTag().getFloat("chaos"+identifier);
        order = stack.getOrCreateTag().getFloat("order"+identifier);
        wind = stack.getOrCreateTag().getFloat("wind"+identifier);
        fire = stack.getOrCreateTag().getFloat("fire"+identifier);
        ice = stack.getOrCreateTag().getFloat("ice"+identifier);
    }


    public ManaPool(float chaosMana, float orderMana, float windMana, float fireMana, float iceMana){
        chaos = chaosMana;
        order = orderMana;
        wind = windMana;
        fire = fireMana;
        ice = iceMana;
    }

    public void consume(ManaPool pool){
        chaos -= pool.chaos;
        order -= pool.order;
        wind -= pool.wind;
        fire -= pool.fire;
        ice -= pool.ice;
        round();
    }

    public boolean contains(@NotNull ManaPool pool){
        return chaos >= pool.chaos && order >= pool.order && wind >= pool.wind && fire >= pool.fire && ice >= pool.ice;
    }

    public void round(){
        chaos = round2(chaos);
        order = round2(order);
        wind = round2(wind);
        fire = round2(fire);
        ice = round2(ice);
    }

    public void saveToStack(ItemStack stack, String identifier){
        stack.getOrCreateTag().putFloat("chaos"+identifier, chaos);
        stack.getOrCreateTag().putFloat("order"+identifier, order);
        stack.getOrCreateTag().putFloat("wind"+identifier, wind);
        stack.getOrCreateTag().putFloat("fire"+identifier, fire);
        stack.getOrCreateTag().putFloat("ice"+identifier, ice);
    }

    public void print(){
        System.out.println("Chaos "+ Float.toString(chaos));
        System.out.println("Order "+ Float.toString(order));
        System.out.println("Wind "+ Float.toString(wind));
        System.out.println("Fire "+ Float.toString(fire));
        System.out.println("Ice "+ Float.toString(ice));
    }
}
