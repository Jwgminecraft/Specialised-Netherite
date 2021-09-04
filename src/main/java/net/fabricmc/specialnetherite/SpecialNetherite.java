package net.fabricmc.specialnetherite;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SpecialNetherite implements ModInitializer {
	//Add the strong crystals
	public static final Item STRONG_CRYSTAL = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item STRONG_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Block STRONG_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());

	//Add the defence crystals
	public static final Item DEFENCE_CRYSTAL = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item DEFENCE_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Block DEFENCE_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());

	@Override
	public void onInitialize() {


		//Register the strong crystal
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_crystal"), 	STRONG_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_crystal_shard"), STRONG_CRYSTAL_SHARD);
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "strong_crystal_ore"), STRONG_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_crystal_ore"), new BlockItem(STRONG_CRYSTAL_ORE, new FabricItemSettings().group(ItemGroup.MISC)));

		//Register the defence crystal
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "defence_crystal"), 	DEFENCE_CRYSTAL);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "defence_crystal_shard"), DEFENCE_CRYSTAL_SHARD);
		Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "defence_crystal_ore"), DEFENCE_CRYSTAL_ORE);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "defence_crystal_ore"), new BlockItem(DEFENCE_CRYSTAL_ORE, new FabricItemSettings().group(ItemGroup.MISC)));

	}
}
