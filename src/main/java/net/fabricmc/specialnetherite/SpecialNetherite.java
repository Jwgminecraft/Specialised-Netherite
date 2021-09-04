package net.fabricmc.specialnetherite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
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


public class SpecialNetherite implements ModInitializer {


	//Crystals that work with everything
	//Add the strong crystals
	public static final Item STRONG_CRYSTAL = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item STRONG_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Block STRONG_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());
	//Add the enchanted crystals
	public static final Item ENCHANTABILITY_CRYSTAL = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item ENCHANTABILITY_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Block ENCHANTABILITY_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());

	//Crystals that work with armor only
	//Add the defence crystals
	public static final Item DEFENCE_CRYSTAL = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item DEFENCE_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Block DEFENCE_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());
	//Add the knockback resistance crystals
	public static final Item KNOCKBACKRES_CRYSTAL = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item KNOCKBACKRES_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Block KNOCKBACKRES_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());

	//Crystals that only work with tools
	//Add the sharp crystals
	public static final Item SHARP_CRYSTAL = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item SHARP_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Block SHARP_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());

	//Sharpened Tools
	static class SharpNetherite implements ToolMaterial {
		public static final SharpNetherite INSTANCE = new SharpNetherite();

		@Override
		public int getDurability() {
			return 2032;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 1.6f;
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
	public ToolItem SHARP_NETHERITE_AXE = new SharpNetherite.SharpAxe(SharpNetherite.INSTANCE, 4,0, new Item.Settings().group(ItemGroup.MISC));
	public static ToolItem SHARP_NETHERITE_SWORD = new SwordItem(SharpNetherite.INSTANCE, 0, 0, new Item.Settings().group(ItemGroup.MISC));

	//Strong Tools/Armor
	static class StrongNetherite implements ToolMaterial {
		public static final SharpNetherite INSTANCE = new SharpNetherite();

		@Override
		public int getDurability() {
			return 4064;
		}

		@Override
		public float getMiningSpeedMultiplier() {
			return 1.6f;
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
	public static ToolItem STRONG_NETHERITE_SWORD = new SwordItem(StrongNetherite.INSTANCE, -9, -3.4f, new Item.Settings().group(ItemGroup.MISC));
	public static ToolItem STRONG_NETHERITE_PICKAXE = new StrongNetherite.StrongPickaxe(StrongNetherite.INSTANCE, -11,-2.6f, new Item.Settings().group(ItemGroup.MISC));
	public static ToolItem STRONG_NETHERITE_AXE = new StrongNetherite.StrongAxe(StrongNetherite.INSTANCE, -11, -2, new Item.Settings().group(ItemGroup.MISC));
	public static ToolItem STRONG_NETHERITE_SHOVEL = new ShovelItem(StrongNetherite.INSTANCE, -10.5f, 0, new Item.Settings().group(ItemGroup.MISC));
	public static ToolItem STRONG_NETHERITE_HOE = new StrongNetherite.StrongHoe(StrongNetherite.INSTANCE, -16, 0, new Item.Settings().group(ItemGroup.MISC));






	private static ConfiguredFeature<?, ?> STRONG_CRYSTAL_OVERWORLD = Feature.ORE
			.configure(new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					STRONG_CRYSTAL_ORE.getDefaultState(),
					9))
			.range(new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
			.spreadHorizontally()
			.repeat(20);
	private static ConfiguredFeature<?, ?> SHARP_CRYSTAL_OVERWORLD = Feature.ORE
			.configure(new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					SHARP_CRYSTAL_ORE.getDefaultState(),
					9))
			.range(new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64))))
			.spreadHorizontally()
			.repeat(20);


	@Override
	public void onInitialize() {


		RegistryKey<ConfiguredFeature<?, ?>> sharpCrystalOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
				new Identifier("tutorial", "sharp_crystal_overworld"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, sharpCrystalOverworld.getValue(), SHARP_CRYSTAL_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, sharpCrystalOverworld);
		RegistryKey<ConfiguredFeature<?, ?>> strongCrystalOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
				new Identifier("tutorial", "strong_crystal_overworld"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, strongCrystalOverworld.getValue(), STRONG_CRYSTAL_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, strongCrystalOverworld);



		//Register the tools
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_netherite_sword"), SHARP_NETHERITE_SWORD);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_netherite_axe"), SHARP_NETHERITE_AXE);

		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_sword"), STRONG_NETHERITE_SWORD);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_pickaxe"), STRONG_NETHERITE_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_axe"), STRONG_NETHERITE_AXE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_shovel"), STRONG_NETHERITE_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_hoe"), STRONG_NETHERITE_HOE);

		//Register the sharp crystal
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_crystal"), SHARP_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_crystal_shard"), SHARP_CRYSTAL_SHARD);
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "sharp_crystal_ore"), SHARP_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_crystal_ore"), new BlockItem(SHARP_CRYSTAL_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
		//Register the strong crystal
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_crystal"), STRONG_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_crystal_shard"), STRONG_CRYSTAL_SHARD);
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "strong_crystal_ore"), STRONG_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_crystal_ore"), new BlockItem(STRONG_CRYSTAL_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
		//Register the defence crystal
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "defence_crystal"), 	DEFENCE_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "defence_crystal_shard"), DEFENCE_CRYSTAL_SHARD);
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "defence_crystal_ore"), DEFENCE_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "defence_crystal_ore"), new BlockItem(DEFENCE_CRYSTAL_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
     	//Register the enchantability crystal
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_crystal"), ENCHANTABILITY_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_crystal_shard"), ENCHANTABILITY_CRYSTAL_SHARD);
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "enchanted_crystal_ore"), ENCHANTABILITY_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_crystal_ore"), new BlockItem(ENCHANTABILITY_CRYSTAL_ORE, new FabricItemSettings().group(ItemGroup.MISC)));
		//Register the knockback resistance crystal
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "knockback_resistance_crystal"), KNOCKBACKRES_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "knockback_resistance_crystal_shard"), KNOCKBACKRES_CRYSTAL_SHARD);
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "knockback_resistance_crystal_ore"), KNOCKBACKRES_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "knockback_resistance_crystal_ore"), new BlockItem(KNOCKBACKRES_CRYSTAL_ORE, new FabricItemSettings().group(ItemGroup.MISC)));

	}

}
