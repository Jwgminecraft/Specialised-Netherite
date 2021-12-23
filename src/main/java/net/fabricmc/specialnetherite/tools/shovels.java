package net.fabricmc.specialnetherite.tools;

import net.fabricmc.specialnetherite.specialisednetherite;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class shovels {
    public static ToolItem OVER_NETHERITE_SHOVEL = new ShovelItem(tool_materials.OverworldNetherite.INSTANCE, 10f, 0, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem NETHER_NETHERITE_SHOVEL = new ShovelItem(tool_materials.NetherNetherite.INSTANCE, 10f, 0, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem END_NETHERITE_SHOVEL = new ShovelItem(tool_materials.EndNetherite.INSTANCE, 10f, 0, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem ENCHANTED_NETHERITE_SHOVEL = new ShovelItem(tool_materials.EnchantedNetherite.INSTANCE, -10.5f, -3, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static ToolItem STRONG_NETHERITE_SHOVEL = new ShovelItem(tool_materials.StrongNetherite.INSTANCE, -7.5f, 0, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());

    public static void register() {

        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_netherite_shovel"), OVER_NETHERITE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_netherite_shovel"), END_NETHERITE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_netherite_shovel"), NETHER_NETHERITE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_netherite_shovel"), STRONG_NETHERITE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_netherite_shovel"), ENCHANTED_NETHERITE_SHOVEL);


    }
}