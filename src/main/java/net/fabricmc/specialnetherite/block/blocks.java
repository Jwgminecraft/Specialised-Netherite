package net.fabricmc.specialnetherite.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.fabricmc.specialnetherite.specialisednetherite;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class blocks {
    public static final Block NETHER_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());
    public static final Block END_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).requiresTool());
    public static final Block SHARP_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
    public static final Block STRONG_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
    public static final Block ENCHANTABILITY_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
    public static final Block DEEPSLATE_SHARP_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
    public static final Block DEEPSLATE_STRONG_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
    public static final Block DEEPSLATE_ENCHANTABILITY_CRYSTAL_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(4f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool());
    public static final Block ENCHANTABILITY_CRYSTAL_BLOCK = new Block(FabricBlockSettings.of(Material.AMETHYST).strength(4.0f).requiresTool());
    public static final Block STRONG_CRYSTAL_BLOCK = new Block(FabricBlockSettings.of(Material.AMETHYST).strength(4.0f).requiresTool());
    public static final Block SHARP_CRYSTAL_BLOCK = new Block(FabricBlockSettings.of(Material.AMETHYST).strength(4.0f).requiresTool());
    public static final Block END_CRYSTAL_BLOCK = new Block(FabricBlockSettings.of(Material.AMETHYST).strength(5.0f).requiresTool());
    public static final Block NETHER_CRYSTAL_BLOCK = new Block(FabricBlockSettings.of(Material.AMETHYST).strength(5.0f).requiresTool());
    public static final Block OVERWORLD_CRYSTAL_BLOCK = new Block(FabricBlockSettings.of(Material.AMETHYST).strength(5.0f).requiresTool());
    public static final Block TIN_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
    public static final Block DEEPSLATE_TIN_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(2.5f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
    public static final Block TIN_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());
    public static final Block BRONZE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).strength(3f).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool());

    public static void register() {
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "nether_crystal_ore"), NETHER_CRYSTAL_ORE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_crystal_ore"), new BlockItem(NETHER_CRYSTAL_ORE, new FabricItemSettings().group(specialisednetherite.ORES)));
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "end_crystal_ore"), END_CRYSTAL_ORE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_crystal_ore"), new BlockItem(END_CRYSTAL_ORE, new FabricItemSettings().group(specialisednetherite.ORES)));
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "strong_crystal_block"), STRONG_CRYSTAL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "sharp_crystal_block"), SHARP_CRYSTAL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "enchantability_crystal_block"), ENCHANTABILITY_CRYSTAL_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchantability_crystal_block"), new BlockItem(ENCHANTABILITY_CRYSTAL_BLOCK, new FabricItemSettings().group(specialisednetherite.CRYSTALS)));
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_crystal_block"), new BlockItem(STRONG_CRYSTAL_BLOCK, new FabricItemSettings().group(specialisednetherite.CRYSTALS)));
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_crystal_block"), new BlockItem(SHARP_CRYSTAL_BLOCK, new FabricItemSettings().group(specialisednetherite.CRYSTALS)));
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_crystal_block"), new BlockItem(OVERWORLD_CRYSTAL_BLOCK, new FabricItemSettings().group(specialisednetherite.CRYSTALS)));
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_crystal_block"), new BlockItem(NETHER_CRYSTAL_BLOCK, new FabricItemSettings().group(specialisednetherite.CRYSTALS)));
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_crystal_block"), new BlockItem(END_CRYSTAL_BLOCK, new FabricItemSettings().group(specialisednetherite.CRYSTALS)));
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "nether_crystal_block"), NETHER_CRYSTAL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "end_crystal_block"), END_CRYSTAL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "overworld_crystal_block"), OVERWORLD_CRYSTAL_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "enchanted_crystal_ore"), ENCHANTABILITY_CRYSTAL_ORE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_crystal_ore"), new BlockItem(ENCHANTABILITY_CRYSTAL_ORE, new FabricItemSettings().group(specialisednetherite.ORES)));
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "deepslate_enchanted_crystal_ore"), DEEPSLATE_ENCHANTABILITY_CRYSTAL_ORE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "deepslate_enchanted_crystal_ore"), new BlockItem(DEEPSLATE_ENCHANTABILITY_CRYSTAL_ORE, new FabricItemSettings().group(specialisednetherite.ORES)));
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "strong_crystal_ore"), STRONG_CRYSTAL_ORE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_crystal_ore"), new BlockItem(STRONG_CRYSTAL_ORE, new FabricItemSettings().group(specialisednetherite.ORES)));
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "deepslate_strong_crystal_ore"), DEEPSLATE_STRONG_CRYSTAL_ORE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "deepslate_strong_crystal_ore"), new BlockItem(DEEPSLATE_STRONG_CRYSTAL_ORE, new FabricItemSettings().group(specialisednetherite.ORES)));
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "sharp_crystal_ore"), SHARP_CRYSTAL_ORE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_crystal_ore"), new BlockItem(SHARP_CRYSTAL_ORE, new FabricItemSettings().group(specialisednetherite.ORES)));
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "deepslate_sharp_crystal_ore"), DEEPSLATE_SHARP_CRYSTAL_ORE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "deepslate_sharp_crystal_ore"), new BlockItem(DEEPSLATE_SHARP_CRYSTAL_ORE, new FabricItemSettings().group(specialisednetherite.ORES)));
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "tin_ore"), TIN_ORE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "tin_ore"), new BlockItem(TIN_ORE, new FabricItemSettings().group(specialisednetherite.ORES)));
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "deepslate_tin_ore"), DEEPSLATE_TIN_ORE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "deepslate_tin_ore"), new BlockItem(DEEPSLATE_TIN_ORE, new FabricItemSettings().group(specialisednetherite.ORES)));
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "tin_block"), TIN_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "tin_block"), new BlockItem(TIN_BLOCK, new FabricItemSettings().group(specialisednetherite.ORES)));
        Registry.register(Registry.BLOCK, new Identifier("specialnetherite", "bronze_block"), BRONZE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "bronze_block"), new BlockItem(BRONZE_BLOCK, new FabricItemSettings().group(specialisednetherite.ORES)));
    }
}