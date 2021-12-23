package net.fabricmc.specialnetherite.tools;

import net.fabricmc.specialnetherite.specialisednetherite;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class hoes {
    public static ToolItem OVER_NETHERITE_HOE = new tool_materials.OverworldNetherite.OverHoe(tool_materials.OverworldNetherite.INSTANCE, 1, 0, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem NETHER_NETHERITE_HOE = new tool_materials.NetherNetherite.NetherHoe(tool_materials.NetherNetherite.INSTANCE, 1, 0, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem END_NETHERITE_HOE = new tool_materials.EndNetherite.EndHoe(tool_materials.EndNetherite.INSTANCE, 1, 0, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem ENCHANTED_NETHERITE_HOE = new tool_materials.EnchantedNetherite.EnchantedHoe(tool_materials.EnchantedNetherite.INSTANCE, -13, 0, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem STRONG_NETHERITE_HOE = new tool_materials.StrongNetherite.StrongHoe(tool_materials.StrongNetherite.INSTANCE, -13, 0, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_netherite_hoe"), OVER_NETHERITE_HOE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_netherite_hoe"), END_NETHERITE_HOE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_netherite_hoe"), NETHER_NETHERITE_HOE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_hoe"), STRONG_NETHERITE_HOE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_netherite_hoe"), ENCHANTED_NETHERITE_HOE);

    }
}