package net.fabricmc.specialnetherite;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.specialnetherite.armor.armor;
import net.fabricmc.specialnetherite.block.blocks;
import net.fabricmc.specialnetherite.item.crystals;
import net.fabricmc.specialnetherite.item.ingots;
import net.fabricmc.specialnetherite.ore.generation.end;
import net.fabricmc.specialnetherite.ore.generation.nether;
import net.fabricmc.specialnetherite.ore.generation.overworld;
import net.fabricmc.specialnetherite.tools.*;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class specialisednetherite implements ModInitializer {

	//Create item groups
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


	@Override
	public void onInitialize() {
		//Register item group's icons
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "icon1"), TOOLS_ICON);
		Registry.register(Registry.ITEM, new Identifier("specialnetherite", "icon2"), CRYSTALS_ICON);

		//Register ore generation
		end.register();
		nether.register();
		overworld.register();

		//Register blocks and items
		blocks.register();
		crystals.register();
		ingots.register();

		//Register Tools
		swords.register();
		pickaxes.register();
		axes.register();
		shovels.register();
		hoes.register();

		//Register armor
		armor.register();

		//Register biomes
		biomes.CrystalBiome.register();
















	}


}