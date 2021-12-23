package net.fabricmc.specialnetherite;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import static net.minecraft.block.Blocks.STONE;

public class biomes {
    public static class CrystalBiome {
        private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CRYSTAL_SURFACE_BUILDER = SurfaceBuilder.DEFAULT
                .withConfig(new TernarySurfaceConfig(
                        Blocks.GRASS_BLOCK.getDefaultState(),
                        Blocks.DIRT.getDefaultState(),
                        STONE.getDefaultState()));
        private static final Biome CRYSTAL_BIOME = createCrystalBio();
        private static Biome createCrystalBio() {

            SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
            DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
            DefaultBiomeFeatures.addMonsters(spawnSettings, 9500, 5, 10000);

            GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
            generationSettings.surfaceBuilder(CRYSTAL_SURFACE_BUILDER);
            DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
            DefaultBiomeFeatures.addLandCarvers(generationSettings);
            DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
            DefaultBiomeFeatures.addWaterBiomeOakTrees(generationSettings);
            DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
            DefaultBiomeFeatures.addAncientDebris(generationSettings);
            DefaultBiomeFeatures.addDefaultLakes(generationSettings);
            DefaultBiomeFeatures.addDungeons(generationSettings);
            DefaultBiomeFeatures.addMineables(generationSettings);
            DefaultBiomeFeatures.addDefaultOres(generationSettings);
            DefaultBiomeFeatures.addDefaultDisks(generationSettings);
            DefaultBiomeFeatures.addSprings(generationSettings);
            DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);

            return (new Biome.Builder())
                    .precipitation(Biome.Precipitation.SNOW)
                    .category(Biome.Category.EXTREME_HILLS)
                    .depth(0.5F)
                    .scale(0.00003F)
                    .temperature(1.3F)
                    .downfall(0.5F)
                    .category(Biome.Category.UNDERGROUND)
                    .effects((new BiomeEffects.Builder())
                            .waterColor(0xBB8FCE)
                            .waterFogColor(0x7D3C98)
                            .fogColor(0xc0d8ff)
                            .skyColor(0x4A235A)
                            .grassColor(0xf2e1f0)
                            .foliageColor(0xf2e1f0)
                            .build())
                    .spawnSettings(spawnSettings.build())
                    .generationSettings(generationSettings.build())
                    .build();



        }
        public static final RegistryKey<Biome> CRYSTAL_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("specialnetherite", "crystal_biome"));
        public static void register() {
            Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("specialnetherite", "crystal_biome"), CRYSTAL_SURFACE_BUILDER);
            Registry.register(BuiltinRegistries.BIOME, CRYSTAL_KEY.getValue(), CRYSTAL_BIOME);
            OverworldBiomes.addContinentalBiome(CRYSTAL_KEY, OverworldClimate.COOL, 0.3D);
        }
    }
}