package com.example.elementalchaos;


import com.example.elementalchaos.elementalItems.items.HasteSpell;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;


public class RegistryHandler {
    // create DeferredRegister object
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ElementalChaos.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ElementalChaos.MODID);
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ElementalChaos.MODID);


    public static void init() {
        // attach DeferredRegister to the event bus
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    
    // register block
    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", () ->
            new Block(Block.Properties
            .create(Material.IRON)
            .hardnessAndResistance(5.0f, 6.0f)
            .sound(SoundType.STONE).harvestLevel(1)
            .harvestTool(ToolType.PICKAXE)
           ));

    public static class ChaosOre extends Block{
        public ChaosOre(){
            super(Block.Properties
                    .create(Material.IRON)
                    .hardnessAndResistance(5.0f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(3)
                    .setRequiresTool());
        }
    }

    public static class OrderOre extends Block{
        public OrderOre(){
            super(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f)
                    .sound(SoundType.BONE).harvestTool(ToolType.PICKAXE).harvestLevel(3).setRequiresTool());
        }
    }
    public static class WindOre extends Block{
        public WindOre(){
            super(Block.Properties.create(Material.LEAVES).hardnessAndResistance(5.0f, 6.0f)
                    .sound(SoundType.SAND).harvestTool(ToolType.SHOVEL).harvestLevel(3).setRequiresTool());
        }
    }

    public static class IceOre extends Block{
        public IceOre(){
            super(Block.Properties.create(Material.ICE).hardnessAndResistance(5.0f, 6.0f)
                    .sound(SoundType.GLASS).harvestTool(ToolType.PICKAXE).harvestLevel(3).setRequiresTool());
        }
    }

    public static class FireOre extends Block{
        public FireOre(){
            super(Block.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f)
                    .sound(SoundType.ANCIENT_DEBRIS).harvestTool(ToolType.PICKAXE).harvestLevel(3).setRequiresTool());
        }
    }

    public static final RegistryObject<Block> CHAOS_ORE = BLOCKS.register("chaos_ore", ChaosOre::new);
    public static final RegistryObject<Block> ORDER_ORE = BLOCKS.register("order_ore", OrderOre::new);
    public static final RegistryObject<Block> WIND_ORE = BLOCKS.register("wind_ore", WindOre::new);
    public static final RegistryObject<Block> ICE_ORE = BLOCKS.register("ice_ore", IceOre::new);
    public static final RegistryObject<Block> FIRE_ORE = BLOCKS.register("fire_ore", IceOre::new);


    // register items
    public static final RegistryObject<Item> COPPER = ITEMS.register("copper", () ->
            new Item(
                    new Item.Properties().group(ItemGroup.MATERIALS)
            )
    );

    public static final RegistryObject<Item> CHAOS_NUGGET = ITEMS.register("chaos_nugget", () ->
            new Item(
                    new Item.Properties().group(ItemGroup.MATERIALS)
            )
    );

    public static final RegistryObject<Item> COPPER_ORE_ITEM = ITEMS.register("copper_ore", () ->
            new BlockItem(
                    COPPER_ORE.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)
            )
    );

    public static final RegistryObject<Item> CHAOS_ORE_ITEM = ITEMS.register("chaos_ore", () ->
            new BlockItem(
                    CHAOS_ORE.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)
            )
    );

    public static final RegistryObject<Item> ORDER_ORE_ITEM = ITEMS.register("order_ore", () ->
            new BlockItem(
                    ORDER_ORE.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)
            )
    );

    public static final RegistryObject<Item> WIND_ORE_ITEM = ITEMS.register("wind_ore", () ->
            new BlockItem(
                    WIND_ORE.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)
            )
    );

    public static final RegistryObject<Item> ICE_ORE_ITEM = ITEMS.register("ice_ore", () ->
            new BlockItem(
                    ICE_ORE.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)
            )
    );

    public static final RegistryObject<Item> FIRE_ORE_ITEM = ITEMS.register("fire_ore", () ->
            new BlockItem(
                    FIRE_ORE.get(),
                    new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)
            )
    );

    public static final RegistryObject<Item> COMPRESSED_STAR = ITEMS.register("compressedstar", () ->
            new Item(
                    new Item.Properties().group(ItemGroup.MATERIALS)
            )
    );

    public static final RegistryObject<Item> BROKEN_OBSIDIAN = ITEMS.register("brokenobsidian", () ->
            new Item(
                    new Item.Properties().group(ItemGroup.MATERIALS)
            )
    );

    public static final RegistryObject<Item> OBSIDIAN_INGOT = ITEMS.register("obsidianingot", () ->
            new Item(
                    new Item.Properties().group(ItemGroup.MATERIALS)
            )
    );

    public static final RegistryObject<SwordItem> MYWAND = ITEMS.register("mywand", () -> new SwordItem(ModItemTier.MYWAND, 200, 0, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final RegistryObject<SwordItem> NETHER_STAR_SWORD = ITEMS.register("netherstarsword", () -> new SwordItem(ModItemTier.NETHER_STAR_SWORD, 15, 0, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final RegistryObject<SwordItem> OBSIDIAN_SWORD = ITEMS.register("obsidiansword", () -> new SwordItem(ModItemTier.OBSIDIAN_SWORD, 12, 0, (new Item.Properties()).group(ItemGroup.COMBAT)));
    public static final RegistryObject<HasteSpell> FIRE_STAFF = ITEMS.register("firestaff", () -> new HasteSpell(ModItemTier.FIRE_STAFF, (new Item.Properties()).group(ItemGroup.COMBAT)));


}
