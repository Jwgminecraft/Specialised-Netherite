package net.fabricmc.specialnetherite.tools;

import net.fabricmc.specialnetherite.specialisednetherite;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class pickaxes {
    public static ToolItem OVER_NETHERITE_PICKAXE = new tool_materials.OverworldNetherite.OverPickaxe(tool_materials.OverworldNetherite.INSTANCE, 10, -2.8f, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem NETHER_NETHERITE_PICKAXE = new tool_materials.NetherNetherite.NetherPickaxe(tool_materials.NetherNetherite.INSTANCE, 10, -2.8f, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem END_NETHERITE_PICKAXE = new tool_materials.EndNetherite.EndPickaxe(tool_materials.EndNetherite.INSTANCE, 10, -2.8f, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem ENCHANTED_NETHERITE_PICKAXE = new tool_materials.EnchantedNetherite.EnchantedPickaxe(tool_materials.EnchantedNetherite.INSTANCE, -11, -2.8f, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem STRONG_NETHERITE_PICKAXE = new tool_materials.StrongNetherite.StrongPickaxe(tool_materials.StrongNetherite.INSTANCE, -11, -2.8f, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static void register() {

        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_netherite_pickaxe"), OVER_NETHERITE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_netherite_pickaxe"), NETHER_NETHERITE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_netherite_pickaxe"), END_NETHERITE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_netherite_pickaxe"), ENCHANTED_NETHERITE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_pickaxe"), STRONG_NETHERITE_PICKAXE);

    }
}