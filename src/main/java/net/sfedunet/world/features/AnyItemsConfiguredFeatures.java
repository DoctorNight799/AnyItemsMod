package net.sfedunet.world.features;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.UniformIntDistribution;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.sfedunet.block.AnyItemsBlocks;
import net.sfedunet.world.features.trees.placers.DragonGrapeFoliagePlacer;
import net.sfedunet.world.features.trees.placers.DragonGrapeTrunkPlacer;
import net.sfedunet.world.features.trees.placers.DragonWillowFoliagePlacer;
import net.sfedunet.world.features.trees.placers.DragonWillowTrunkPlacer;

public class AnyItemsConfiguredFeatures {

    public static ConfiguredFeature<TreeFeatureConfig, ?> DRAGON_GRAPE, DRAGON_WILLOW;
    public static ConfiguredFeature<?, ?> DRACONIC_FOREST_TREES, DRACONIC_FIELDS_TREES;
    public static ConfiguredFeature<?, ?> CRYPTON_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, AnyItemsBlocks.CRYPTON_ORE.getDefaultState(), 5)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0,20,40))).spreadHorizontally().repeat(10);
    public static ConfiguredFeature<?, ?> ECHSEROCK_ORE_DRAGONIC = Feature.ORE.configure(new OreFeatureConfig(Rules.DRAGONSTONE, AnyItemsBlocks.ECHSEROCK.getDefaultState(),6)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(0,0,255))).spreadHorizontally().repeat(15);
    public static void register() {
        DRAGON_GRAPE = register("dragon_grape", Feature.TREE.configure(Configs.DRAGON_GRAPE_CONFIG));
        DRAGON_WILLOW = register("dragon_willow", Feature.TREE.configure(Configs.DRAGON_WILLOW_CONFIG));
        DRACONIC_FOREST_TREES = register("draconic_forest_trees", Feature.RANDOM_SELECTOR.configure(Configs.DRACONIC_TREES_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.15F, 1))));
        DRACONIC_FIELDS_TREES = register("draconic_fields_trees", Feature.RANDOM_SELECTOR.configure(Configs.DRACONIC_TREES_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP).decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(1, 0.05F, 1))));

        RegistryKey<ConfiguredFeature<?, ?>> oreEchserockDragonic = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("anyitem:echserock"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreEchserockDragonic.getValue(), ECHSEROCK_ORE_DRAGONIC);

        RegistryKey<ConfiguredFeature<?, ?>> oreCryptonOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN, new Identifier("anyitem:crypton_ore_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreCryptonOverworld.getValue(), CRYPTON_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreCryptonOverworld);
    }
    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, "anyitem:" + id, configuredFeature);
    }
    public static class Configs {
        public static final TreeFeatureConfig DRAGON_GRAPE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(AnyItemsBlocks.DRAGON_GRAPE_LOG.getDefaultState()), new SimpleBlockStateProvider(AnyItemsBlocks.DRAGON_GRAPE_LEAVES.getDefaultState()), new DragonGrapeFoliagePlacer(UniformIntDistribution.of(3, 1), UniformIntDistribution.of(0, 1)), new DragonGrapeTrunkPlacer(3, 2, 1), new TwoLayersFeatureSize(3, 0, 3))).ignoreVines().build();
        public static final TreeFeatureConfig DRAGON_WILLOW_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(AnyItemsBlocks.DRAGON_WILLOW_LOG.getDefaultState()), new SimpleBlockStateProvider(AnyItemsBlocks.DRAGON_WILLOW_LEAVES.getDefaultState()), new DragonWillowFoliagePlacer(UniformIntDistribution.of(3, 1), UniformIntDistribution.of(0, 1)), new DragonWillowTrunkPlacer(3, 2, 1), new TwoLayersFeatureSize(3, 0, 3))).ignoreVines().build();
        public static final RandomFeatureConfig DRACONIC_TREES_CONFIG = new RandomFeatureConfig(
                ImmutableList.of(Feature.TREE.configure(DRAGON_WILLOW_CONFIG).withChance(0.7F)),
                Feature.TREE.configure(Configs.DRAGON_GRAPE_CONFIG)
        );
    }
    public static final class Rules {
        public static final RuleTest DRAGONSTONE;

        static {
            DRAGONSTONE = new BlockMatchRuleTest(AnyItemsBlocks.DRAGON_STONE);
        }
    }
}