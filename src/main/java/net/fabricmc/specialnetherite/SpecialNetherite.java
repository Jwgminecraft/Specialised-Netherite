package net.fabricmc.specialnetherite;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decoratable;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.stream.Stream;


public class SpecialNetherite implements ModInitializer {


	public static final Item CRYSTALS_ICON = new Item(new FabricItemSettings());
	public static final Item TOOLS_ICON = new Item(new FabricItemSettings());


	public static final ItemGroup CRYSTALS = FabricItemGroupBuilder.build(
			new Identifier("specialnetherite", "crystals"),
			() -> new ItemStack(CRYSTALS_ICON));
	public static final ItemGroup ORES = FabricItemGroupBuilder.build(
			new Identifier("specialnetherite", "ores"),
			() -> new ItemStack(Blocks.GOLD_ORE));
	public static final ItemGroup TOOLS = FabricItemGroupBuilder.create(
					new Identifier("specialnetherite", "tools"))
			.icon(() -> new ItemStack(TOOLS_ICON))
			.build();

	public static final Block SHARP_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
	public static final Block STRONG_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
	public static final Block ENCHANTABILITY_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());

	public static final Block DEEPSLATE_SHARP_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
	public static final Block DEEPSLATE_STRONG_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
	public static final Block DEEPSLATE_ENCHANTABILITY_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());

	public static final Block TIN_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
	public static final Block TIN_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(1f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
	public static final Block BRONZE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
	//Add the strong crystals
	public static final Item STRONG_CRYSTAL = new Item(new FabricItemSettings().group(CRYSTALS));
	public static final Item STRONG_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(CRYSTALS));
	//Add the enchanted crystals
	public static final Item ENCHANTABILITY_CRYSTAL = new Item(new FabricItemSettings().group(CRYSTALS));
	public static final Item ENCHANTABILITY_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(CRYSTALS));
	//Add the sharp crystals
	public static final Item SHARP_CRYSTAL = new Item(new FabricItemSettings().group(CRYSTALS));
	public static final Item SHARP_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(CRYSTALS));




	//Sharpened Tools
	static class SharpNetherite implements ToolMaterial {


		public static final SharpNetherite INSTANCE = new SharpNetherite();

		@Override
		public int getDurability() {
			return 2032;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 6f;
		}

		@Override
		public float getAttackDamage() {
			return 16;
		}

		@Override
		public int getMiningLevel() {
			return 4;
		}

		@Override
		public int getEnchantability() {
			return 4;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(Items.NETHERITE_INGOT);
		}

		public static class SharpAxe extends AxeItem {
			public SharpAxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
				super(material, attackDamage, attackSpeed, settings);
			}
		}


	}

	public ToolItem SHARP_NETHERITE_AXE = new SharpNetherite.SharpAxe(SharpNetherite.INSTANCE, 4, 0, new Item.Settings().group(TOOLS).fireproof());
	public static ToolItem SHARP_NETHERITE_SWORD = new SwordItem(SharpNetherite.INSTANCE, 0, 0, new Item.Settings().group(TOOLS).fireproof());

	//Strong Tools
	static class StrongNetherite implements ToolMaterial {
		public static final SharpNetherite INSTANCE = new SharpNetherite();

		@Override
		public int getDurability() {
			return 4064;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 6f;
		}

		@Override
		public float getAttackDamage() {
			return 8;
		}

		@Override
		public int getMiningLevel() {
			return 4;
		}

		@Override
		public int getEnchantability() {
			return 4;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(Items.NETHERITE_INGOT);
		}

		public static class StrongAxe extends AxeItem {
			public StrongAxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
				super(material, attackDamage, attackSpeed, settings);
			}
		}

		public static class StrongPickaxe extends PickaxeItem {
			public StrongPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
				super(material, attackDamage, attackSpeed, settings);
			}
		}

		public static class StrongHoe extends HoeItem {
			public StrongHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
				super(material, attackDamage, attackSpeed, settings);
			}
		}

	}

	public static ToolItem STRONG_NETHERITE_SWORD = new SwordItem(StrongNetherite.INSTANCE, -7, -3.4f, new Item.Settings().group(TOOLS).fireproof());
	public static ToolItem STRONG_NETHERITE_PICKAXE = new StrongNetherite.StrongPickaxe(StrongNetherite.INSTANCE, -11, -2.8f, new Item.Settings().group(TOOLS).fireproof());
	public static ToolItem STRONG_NETHERITE_AXE = new StrongNetherite.StrongAxe(StrongNetherite.INSTANCE, -7, -2, new Item.Settings().group(TOOLS).fireproof());
	public static ToolItem STRONG_NETHERITE_SHOVEL = new ShovelItem(StrongNetherite.INSTANCE, -7.5f, 0, new Item.Settings().group(TOOLS).fireproof());
	public static ToolItem STRONG_NETHERITE_HOE = new StrongNetherite.StrongHoe(StrongNetherite.INSTANCE, -16, 0, new Item.Settings().group(TOOLS).fireproof());

	//Enchanted Tools
	static class EnchantedNetherite implements ToolMaterial {
		public static final SharpNetherite INSTANCE = new SharpNetherite();

		@Override
		public int getDurability() {
			return 2032;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 6f;
		}

		@Override
		public float getAttackDamage() {
			return 8;
		}

		@Override
		public int getMiningLevel() {
			return 4;
		}

		@Override
		public int getEnchantability() {
			return 30;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.ofItems(Items.NETHERITE_INGOT);
		}

		public static class EnchantedAxe extends AxeItem {
			public EnchantedAxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
				super(material, attackDamage, attackSpeed, settings);
			}
		}

		public static class EnchantedPickaxe extends PickaxeItem {
			public EnchantedPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
				super(material, attackDamage, attackSpeed, settings);
			}
		}

		public static class EnchantedHoe extends HoeItem {
			public EnchantedHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
				super(material, attackDamage, attackSpeed, settings);
			}
		}

	}

	public static ToolItem ENCHANTED_NETHERITE_SWORD = new SwordItem(EnchantedNetherite.INSTANCE, -9, -2.4f, new Item.Settings().group(TOOLS).fireproof());
	public static ToolItem ENCHANTED_NETHERITE_PICKAXE = new EnchantedNetherite.EnchantedPickaxe(EnchantedNetherite.INSTANCE, -11, -2.8f, new Item.Settings().group(TOOLS).fireproof());
	public static ToolItem ENCHANTED_NETHERITE_AXE = new EnchantedNetherite.EnchantedAxe(EnchantedNetherite.INSTANCE, -7, -3, new Item.Settings().group(TOOLS).fireproof());
	public static ToolItem ENCHANTED_NETHERITE_SHOVEL = new ShovelItem(EnchantedNetherite.INSTANCE, -10.5f, -3, new Item.Settings().group(TOOLS).fireproof());
	public static ToolItem ENCHANTED_NETHERITE_HOE = new EnchantedNetherite.EnchantedHoe(EnchantedNetherite.INSTANCE, -16, 0, new Item.Settings().group(TOOLS).fireproof());


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
					STRONG_CRYSTAL_ORE.getDefaultState(),
					3))
			.range(new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
			.spreadHorizontally()
			.repeat(5);
	private static ConfiguredFeature<?, ?> SHARP_CRYSTAL_OVERWORLD = Feature.ORE
			.configure(new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					SHARP_CRYSTAL_ORE.getDefaultState(),
					3))
			.range(new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
			.spreadHorizontally()
			.repeat(5);
	private static ConfiguredFeature<?, ?> TIN_OVERWORLD = Feature.ORE
			.configure(new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					TIN_ORE.getDefaultState(),
					8))
			.range(new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(70))))
			.spreadHorizontally()
			.repeat(10);


	private static ConfiguredFeature<?, ?> ENCHANTED_CRYSTAL_DEEPSLATE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
					DEEPSLATE_ENCHANTABILITY_CRYSTAL_ORE.getDefaultState(),
					3))
			.range(new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
			.spreadHorizontally()
			.repeat(50);
	private static ConfiguredFeature<?, ?> STRONG_CRYSTAL_DEEPSLATE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
					DEEPSLATE_STRONG_CRYSTAL_ORE.getDefaultState(),
					3))
			.range(new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
			.spreadHorizontally()
			.repeat(50);
	private static ConfiguredFeature<?, ?> SHARP_CRYSTAL_DEEPSLATE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES,
					DEEPSLATE_SHARP_CRYSTAL_ORE.getDefaultState(),
					3))
			.range(new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
			.spreadHorizontally()
			.repeat(50);


	public static final Block NETHER_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());
	public static final Block END_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());

	public static final Item END_CRYSTAL = new Item(new FabricItemSettings().group(CRYSTALS));
	public static final Item END_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(CRYSTALS));

	public static final Item NETHER_CRYSTAL = new Item(new FabricItemSettings().group(CRYSTALS));
	public static final Item NETHER_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(CRYSTALS));

	public static final Item OVERWORLD_CRYSTAL = new Item(new FabricItemSettings().group(CRYSTALS));
	public static final Item OVERWORLD_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(CRYSTALS));

	private static ConfiguredFeature<?, ?> NETHER_CRYSTAL_GEN = Feature.ORE
			.configure(new OreFeatureConfig(
					new BlockMatchRuleTest(Blocks.NETHERRACK),
					NETHER_CRYSTAL_ORE.getDefaultState(),
					3))
			.range(new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(128))))
			.spreadHorizontally()
			.repeat(15);
	private static ConfiguredFeature<?, ?> END_CRYSTAL_GEN = Feature.ORE
			.configure(new OreFeatureConfig(
					new BlockMatchRuleTest(Blocks.END_STONE),
					END_CRYSTAL_ORE.getDefaultState(),
					3))
			.range(new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.fixed(0), YOffset.fixed(128))))
			.spreadHorizontally()
			.repeat(15);


	public static final Item RAW_TIN = new Item(new FabricItemSettings().group(ORES));
	public static final Item TIN_INGOT = new Item(new FabricItemSettings().group(ORES));
	public static final Item RAW_BRONZE = new Item(new FabricItemSettings().group(ORES));
	public static final Item BRONZE_INGOT = new Item(new FabricItemSettings().group(ORES));

	public static final RegistryKey<Biome> CRYSTAL_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("specialnetherite", "crystal_biome"));



	public class CrystalFeature extends Feature<DefaultFeatureConfig> {
		public CrystalFeature(Codec<DefaultFeatureConfig> configCodec) {
			super(configCodec);
		}

		@Override
		public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
			BlockPos topPos = context.getWorld().getTopPosition(Heightmap.Type.OCEAN_FLOOR_WG, context.getOrigin());
			Direction offset = Direction.NORTH;

			for (int y = 0; y < 1; y++) {
				offset = offset.rotateYClockwise();
				context.getWorld().setBlockState(topPos.up(y).offset(offset), Blocks.STONE.getDefaultState(), 1);
			}
			for (int y = 0; y < 1; y++) {
				offset = offset.rotateYClockwise();
				context.getWorld().setBlockState(topPos.up(y).offset(offset), Blocks.STONE.getDefaultState(), 1);
			}
			for (int y = 0; y < 1; y++) {
				offset = offset.rotateYClockwise();
				context.getWorld().setBlockState(topPos.up(y).offset(offset), Blocks.STONE.getDefaultState(), 1);
			}
			for (int y = 0; y < 1; y++) {
				offset = offset.rotateYClockwise();
				context.getWorld().setBlockState(topPos.up(y).offset(offset), ENCHANTABILITY_CRYSTAL_ORE.getDefaultState(), 1);
			}
			for (int y = 0; y < 1; y++) {
				offset = offset.rotateYClockwise();
				context.getWorld().setBlockState(topPos.up(y).offset(offset), STRONG_CRYSTAL_ORE.getDefaultState(), 1);
			}
			for (int y = 0; y < 1; y++) {
				offset = offset.rotateYClockwise();
				context.getWorld().setBlockState(topPos.up(y).offset(offset), SHARP_CRYSTAL_ORE.getDefaultState(), 1);
			}

			return true;
		}
	}
	public record CrystalFeatureConfig(IntProvider height, BlockStateProvider block) implements FeatureConfig {
		public static final Codec<CrystalFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
				IntProvider.VALUE_CODEC.fieldOf("height").forGetter(CrystalFeatureConfig::height),
				BlockStateProvider.TYPE_CODEC.fieldOf("block").forGetter(CrystalFeatureConfig::block)
		).apply(instance, instance.stable(CrystalFeatureConfig::new)));
	}
	public static class SpiralFeature extends Feature<CrystalFeatureConfig> {
		public SpiralFeature(Codec<CrystalFeatureConfig> configCodec) {
			super(configCodec);
		}

		@Override
		public boolean generate(FeatureContext<CrystalFeatureConfig> context) {
			BlockPos pos = context.getOrigin();
			CrystalFeatureConfig config = context.getConfig();

			Direction offset = Direction.NORTH;
			int height = config.height().get(context.getRandom());

			for (int y = 0; y < height; y++) {
				offset = offset.rotateYClockwise();
				BlockPos blockPos = pos.up(y).offset(offset);

				context.getWorld().setBlockState(blockPos, config.block().getBlockState(context.getRandom(), blockPos), 3);
			}

			return true;
		}
	}
	private static final Feature<CrystalFeatureConfig> ROCK1 = new SpiralFeature(CrystalFeatureConfig.CODEC);

	public static final ConfiguredFeature<?, ?> CRYSTAL_ROCK = ROCK1.configure(new CrystalFeatureConfig(ConstantIntProvider.create(2), new SimpleBlockStateProvider(SHARP_CRYSTAL_ORE.getDefaultState())))
			.decorate(Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR_WG)))
			.spreadHorizontally()
			.applyChance(5);

	@Override
	public void onInitialize() {

		Registry.register(Registry.FEATURE, new Identifier("specialnetherite", "crystal_rock_1"), ROCK1);
		RegistryKey<ConfiguredFeature<?, ?>> crystalRock = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
				new Identifier("specialnetherite", "crystal_rock_1"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, crystalRock.getValue(), CRYSTAL_ROCK);
		BiomeModifications.addFeature(BiomeSelectors.all(), GenerationStep.Feature.UNDERGROUND_ORES, crystalRock);

			Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("specialnetherite", "crystal_biome"), CRYSTAL_SURFACE_BUILDER);
			Registry.register(BuiltinRegistries.BIOME, CRYSTAL_KEY.getValue(), CRYSTAL_BIOME);
		OverworldBiomes.addContinentalBiome(CRYSTAL_KEY, OverworldClimate.COOL, 0.3D);

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


		RegistryKey<ConfiguredFeature<?, ?>> endCrystalOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
				new Identifier("specialnetherite", "end_crystal_gen"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, endCrystalOre.getValue(), END_CRYSTAL_GEN);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, endCrystalOre);

		RegistryKey<ConfiguredFeature<?, ?>> netherCrystalOre = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
				new Identifier("specialnetherite", "nether_crystal_gen"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, netherCrystalOre.getValue(), NETHER_CRYSTAL_GEN);
		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, netherCrystalOre);


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


		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "icon1"), TOOLS_ICON);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "icon2"), CRYSTALS_ICON);

		//Register the tools
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_netherite_sword"), SHARP_NETHERITE_SWORD);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_netherite_axe"), SHARP_NETHERITE_AXE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_sword"), STRONG_NETHERITE_SWORD);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_pickaxe"), STRONG_NETHERITE_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_axe"), STRONG_NETHERITE_AXE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_shovel"), STRONG_NETHERITE_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_hoe"), STRONG_NETHERITE_HOE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_netherite_sword"), ENCHANTED_NETHERITE_SWORD);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_netherite_pickaxe"), ENCHANTED_NETHERITE_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_netherite_axe"), ENCHANTED_NETHERITE_AXE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_netherite_shovel"), ENCHANTED_NETHERITE_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_netherite_hoe"), ENCHANTED_NETHERITE_HOE);

		//Register the ores that aren't crystals, and their raw/ingot varients
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "raw_tin"), RAW_TIN);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "tin_ingot"), TIN_INGOT);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "raw_bronze"), RAW_BRONZE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "bronze_ingot"), BRONZE_INGOT);

		//Register the sharp crystals
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_crystal"), SHARP_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_crystal_shard"), SHARP_CRYSTAL_SHARD);
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "sharp_crystal_ore"), SHARP_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_crystal_ore"), new BlockItem(SHARP_CRYSTAL_ORE, new FabricItemSettings().group(ORES)));
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "deepslate_sharp_crystal_ore"), DEEPSLATE_SHARP_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "deepslate_sharp_crystal_ore"), new BlockItem(DEEPSLATE_SHARP_CRYSTAL_ORE, new FabricItemSettings().group(ORES)));
		//Register the strong crystal
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_crystal"), STRONG_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_crystal_shard"), STRONG_CRYSTAL_SHARD);
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "strong_crystal_ore"), STRONG_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_crystal_ore"), new BlockItem(STRONG_CRYSTAL_ORE, new FabricItemSettings().group(ORES)));
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "deepslate_strong_crystal_ore"), DEEPSLATE_STRONG_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "deepslate_strong_crystal_ore"), new BlockItem(DEEPSLATE_STRONG_CRYSTAL_ORE, new FabricItemSettings().group(ORES)));
		//Register the enchantability crystal
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_crystal"), ENCHANTABILITY_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_crystal_shard"), ENCHANTABILITY_CRYSTAL_SHARD);
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "enchanted_crystal_ore"), ENCHANTABILITY_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_crystal_ore"), new BlockItem(ENCHANTABILITY_CRYSTAL_ORE, new FabricItemSettings().group(ORES)));
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "deepslate_enchanted_crystal_ore"), DEEPSLATE_ENCHANTABILITY_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "deepslate_enchanted_crystal_ore"), new BlockItem(DEEPSLATE_ENCHANTABILITY_CRYSTAL_ORE, new FabricItemSettings().group(ORES)));
		//Register tin and bronze
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "tin_ore"), TIN_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "tin_ore"), new BlockItem(TIN_ORE, new FabricItemSettings().group(ORES)));
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "tin_block"), TIN_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "tin_block"), new BlockItem(TIN_BLOCK, new FabricItemSettings().group(ORES)));
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "bronze_block"), BRONZE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "bronze_block"), new BlockItem(BRONZE_BLOCK, new FabricItemSettings().group(ORES)));
		//Crystals for each dimension
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "nether_crystal_ore"), NETHER_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_crystal_ore"), new BlockItem(NETHER_CRYSTAL_ORE, new FabricItemSettings().group(ORES)));
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_crystal"), NETHER_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_crystal_shard"), NETHER_CRYSTAL_SHARD);
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "end_crystal_ore"), END_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_crystal_ore"), new BlockItem(END_CRYSTAL_ORE, new FabricItemSettings().group(ORES)));
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_crystal"), END_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_crystal_shard"), END_CRYSTAL_SHARD);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_crystal"), OVERWORLD_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_crystal_shard"), OVERWORLD_CRYSTAL_SHARD);
	}

	private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CRYSTAL_SURFACE_BUILDER = SurfaceBuilder.DEFAULT
			.withConfig(new TernarySurfaceConfig(
					Blocks.GRASS_BLOCK.getDefaultState(),
					Blocks.DIRT.getDefaultState(),
					Blocks.STONE.getDefaultState()));

	private static final Biome CRYSTAL_BIOME = createCrystalBio();


	private static Biome createCrystalBio() {

		SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
		DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
		DefaultBiomeFeatures.addMonsters(spawnSettings, 9500, 5, 10000);

		GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
		generationSettings.surfaceBuilder(CRYSTAL_SURFACE_BUILDER);
		DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
		DefaultBiomeFeatures.addLandCarvers(generationSettings);
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
						.build())
				.spawnSettings(spawnSettings.build())
				.generationSettings(generationSettings.build())
				.build();



	}
}
