package com.example.elementalchaos.worldgen;
import com.example.elementalchaos.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class OreGeneration {

    public static void generateOres(final BiomeLoadingEvent event) {
        //OVERWORLD ORES
        if (!(event.getCategory().equals(Biome.Category.NETHER) || event.getCategory().equals(Biome.Category.THEEND))) {
            generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                    RegistryHandler.COPPER_ORE.get().getDefaultState(), 8, 30, 64, 10);

            // CHAOS ORE
            generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                    RegistryHandler.CHAOS_ORE.get().getDefaultState(), 3, 10, 13, 5);

            // ORDER ORE
            generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                    RegistryHandler.ORDER_ORE.get().getDefaultState(), 16, 15, 21, 10);

            // WIND ORE
            generateOre(event.getGeneration(), new BlockMatchRuleTest(Blocks.GRASS_BLOCK),
                    RegistryHandler.WIND_ORE.get().getDefaultState(), 3, 50, 256, 24);

            // ICE ORE
            if (event.getClimate().temperature <= 0.3) {
                generateOre(event.getGeneration(), new BlockMatchRuleTest(Blocks.WATER),
                        RegistryHandler.ICE_ORE.get().getDefaultState(), 3, 0, 256, 64);
                generateOre(event.getGeneration(), new BlockMatchRuleTest(Blocks.GRASS_BLOCK),
                        RegistryHandler.ICE_ORE.get().getDefaultState(), 16, 0, 256, 4);
            }
            generateOre(event.getGeneration(), new BlockMatchRuleTest(Blocks.SNOW),
                    RegistryHandler.ICE_ORE.get().getDefaultState(), 4, 0, 256, 64);
            generateOre(event.getGeneration(), new BlockMatchRuleTest(Blocks.SNOW_BLOCK),
                    RegistryHandler.ICE_ORE.get().getDefaultState(), 4, 0, 256, 64);

            // FIRE ORE
            if (event.getClimate().temperature >= 0.95) {
                generateOre(event.getGeneration(), new BlockMatchRuleTest(Blocks.SAND),
                        RegistryHandler.FIRE_ORE.get().getDefaultState(), 3, 0, 256, 64);
            }
            generateOre(event.getGeneration(), new BlockMatchRuleTest(Blocks.LAVA),
                    RegistryHandler.FIRE_ORE.get().getDefaultState(), 3, 0, 256, 64);
        }
        else if (event.getCategory().equals(Biome.Category.NETHER)){
            // FIRE ORE
            generateOre(event.getGeneration(), new BlockMatchRuleTest(Blocks.LAVA),
                    RegistryHandler.FIRE_ORE.get().getDefaultState(), 16, 0, 256, 64);
            generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_NETHER,
                    RegistryHandler.FIRE_ORE.get().getDefaultState(), 3, 0, 256, 64);
        }
    }

    private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state,
                                    int veinSize, int minHeight, int maxHeight, int amount) {
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, veinSize))
                        .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                        .square().func_242731_b(amount));
    }
}
