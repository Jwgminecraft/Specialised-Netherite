package net.fabricmc.specialnetherite.tools;

import net.fabricmc.specialnetherite.specialisednetherite;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class swords {
    public static ToolItem OVER_NETHERITE_SWORD = new SwordItem(tool_materials.OverworldNetherite.INSTANCE, 20, -2.4f, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem NETHER_NETHERITE_SWORD = new SwordItem(tool_materials.NetherNetherite.INSTANCE, 20, -2.4f, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem END_NETHERITE_SWORD = new SwordItem(tool_materials.EndNetherite.INSTANCE, 20, -2.4f, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem STRONG_NETHERITE_SWORD = new SwordItem(tool_materials.StrongNetherite.INSTANCE, -7, -3.4f, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem ENCHANTED_NETHERITE_SWORD = new SwordItem(tool_materials.EnchantedNetherite.INSTANCE, -9, -2.4f, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem SHARP_NETHERITE_SWORD = new SwordItem(tool_materials.SharpNetherite.INSTANCE, 0, 0, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static void register() {

        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_netherite_sword"), OVER_NETHERITE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_netherite_sword"), NETHER_NETHERITE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_netherite_sword"), END_NETHERITE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_netherite_sword"), SHARP_NETHERITE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_netherite_sword"), ENCHANTED_NETHERITE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_sword"), STRONG_NETHERITE_SWORD);



    }
}