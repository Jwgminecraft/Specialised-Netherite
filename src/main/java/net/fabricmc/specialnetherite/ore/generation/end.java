package net.fabricmc.specialnetherite.ore.generation;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.specialnetherite.block.blocks;
import net.fabricmc.specialnetherite.specialisednetherite;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
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

public class end {

    private static ConfiguredFeature<?, ?> END_CRYSTAL_GEN = Feature.ORE
            .configure(new OreFeatureConfig(
                    new BlockMatchRuleTest(Blocks.END_STONE),
                    blocks.END_CRYSTAL_ORE.getDefaultState(),
                    3))
            .range(new RangeDecoratorConfig(
                    UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(128))))
            .spreadHorizontally()
            .repeat(15);

    public static void register() {


        RegistryKey<ConfiguredFeature<?, ?>> endCrystalOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier("specialnetherite", "end_crystal_gen"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, endCrystalOre.getValue(), END_CRYSTAL_GEN);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, endCrystalOre);

    }
}
