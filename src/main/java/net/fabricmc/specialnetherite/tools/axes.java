package net.fabricmc.specialnetherite.tools;

import net.fabricmc.specialnetherite.specialisednetherite;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class axes {
    public static ToolItem OVER_NETHERITE_AXE = new tool_materials.OverworldNetherite.OverAxe(tool_materials.OverworldNetherite.INSTANCE, 32, 4, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem NETHER_NETHERITE_AXE = new tool_materials.NetherNetherite.NetherAxe(tool_materials.NetherNetherite.INSTANCE, 32, 4, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem END_NETHERITE_AXE = new tool_materials.EndNetherite.EndAxe(tool_materials.EndNetherite.INSTANCE, 32, 4, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem ENCHANTED_NETHERITE_AXE = new tool_materials.EnchantedNetherite.EnchantedAxe(tool_materials.EnchantedNetherite.INSTANCE, -7, -3, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem STRONG_NETHERITE_AXE = new tool_materials.StrongNetherite.StrongAxe(tool_materials.StrongNetherite.INSTANCE, -7, -2, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem SHARP_NETHERITE_AXE = new tool_materials.SharpNetherite.SharpAxe(tool_materials.SharpNetherite.INSTANCE, 4, 0, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_netherite_axe"), OVER_NETHERITE_AXE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_netherite_axe"), END_NETHERITE_AXE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_netherite_axe"), NETHER_NETHERITE_AXE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_axe"), STRONG_NETHERITE_AXE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_netherite_axe"), SHARP_NETHERITE_AXE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_netherite_axe"), ENCHANTED_NETHERITE_AXE);


    }
}