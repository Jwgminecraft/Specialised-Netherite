package net.fabricmc.specialnetherite.ore.generation;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.specialnetherite.block.blocks;
import net.fabricmc.specialnetherite.specialisednetherite;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

import static net.fabricmc.specialnetherite.block.blocks.ENCHANTABILITY_CRYSTAL_ORE;

public class overworld {
    private static ConfiguredFeature<?, ?> ENCHANTED_CRYSTAL_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ENCHANTABILITY_CRYSTAL_ORE.getDefaultState(),
                    3))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
            .spreadHorizontally()
            .repeat(5);
    private static ConfiguredFeature<?, ?> STRONG_CRYSTAL_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    blocks.STRONG_CRYSTAL_ORE.getDefaultState(),
                    3))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
            .spreadHorizontally()
            .repeat(5);
    private static ConfiguredFeature<?, ?> SHARP_CRYSTAL_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    blocks.SHARP_CRYSTAL_ORE.getDefaultState(),
                    3))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
            .spreadHorizontally()
            .repeat(5);
    private static ConfiguredFeature<?, ?> TIN_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    blocks.TIN_ORE.getDefaultState(),
                    8))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(70))))
            .spreadHorizontally()
            .repeat(10);
    private static ConfiguredFeature<?, ?> TIN_DEEPSLATE = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
                    blocks.DEEPSLATE_TIN_ORE.getDefaultState(),
                    8))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
            .spreadHorizontally()
            .repeat(10);


    private static ConfiguredFeature<?, ?> ENCHANTED_CRYSTAL_DEEPSLATE = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
                    blocks.DEEPSLATE_ENCHANTABILITY_CRYSTAL_ORE.getDefaultState(),
                    3))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
            .spreadHorizontally()
            .repeat(50);
    private static ConfiguredFeature<?, ?> STRONG_CRYSTAL_DEEPSLATE = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
                    blocks.DEEPSLATE_STRONG_CRYSTAL_ORE.getDefaultState(),
                    3))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
            .spreadHorizontally()
            .repeat(50);
    private static ConfiguredFeature<?, ?> SHARP_CRYSTAL_DEEPSLATE = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
                    blocks.DEEPSLATE_SHARP_CRYSTAL_ORE.getDefaultState(),
                    3))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
            .spreadHorizontally()
            .repeat(50);

    public static void register() {
        RegistryKey<ConfiguredFeature<?, ?>> sharpCrystalOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("specialnetherite", "sharp_crystal_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, sharpCrystalOverworld.getValue(), SHARP_CRYSTAL_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, sharpCrystalOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> strongCrystalOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("specialnetherite", "strong_crystal_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, strongCrystalOverworld.getValue(), STRONG_CRYSTAL_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, strongCrystalOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> enchantedCrystalOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("specialnetherite", "enchanted_crystal_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, enchantedCrystalOverworld.getValue(), ENCHANTED_CRYSTAL_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, enchantedCrystalOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> tinOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("specialnetherite", "tin_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tinOverworld.getValue(), TIN_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, tinOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> tinDeepslate = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("specialnetherite", "tin_deepslate"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, tinDeepslate.getValue(), TIN_DEEPSLATE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, tinDeepslate);

        RegistryKey<ConfiguredFeature<?, ?>> sharpCrystalDeepslate = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("specialnetherite", "deepslate_sharp_crystal_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, sharpCrystalDeepslate.getValue(), SHARP_CRYSTAL_DEEPSLATE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, sharpCrystalDeepslate);

        RegistryKey<ConfiguredFeature<?, ?>> strongCrystalDeepslate = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("specialnetherite", "deepslate_strong_crystal_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, strongCrystalDeepslate.getValue(), STRONG_CRYSTAL_DEEPSLATE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, strongCrystalDeepslate);

        RegistryKey<ConfiguredFeature<?, ?>> enchantedCrystalDeepslate = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("specialnetherite", "deepslate_enchanted_crystal_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, enchantedCrystalDeepslate.getValue(), ENCHANTED_CRYSTAL_DEEPSLATE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, enchantedCrystalDeepslate);

    }
}
