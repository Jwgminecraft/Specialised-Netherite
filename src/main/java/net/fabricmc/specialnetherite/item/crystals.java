package net.fabricmc.specialnetherite.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.specialnetherite.specialisednetherite;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class crystals {

    public static final Item END_CRYSTAL = new Item(new FabricItemSettings().group(specialisednetherite.CRYSTALS));
    public static final Item END_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(specialisednetherite.CRYSTALS));
    public static final Item NETHER_CRYSTAL = new Item(new FabricItemSettings().group(specialisednetherite.CRYSTALS));
    public static final Item NETHER_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(specialisednetherite.CRYSTALS));
    public static final Item OVERWORLD_CRYSTAL = new Item(new FabricItemSettings().group(specialisednetherite.CRYSTALS));
    public static final Item OVERWORLD_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(specialisednetherite.CRYSTALS));
    public static final Item STRONG_CRYSTAL = new Item(new FabricItemSettings().group(specialisednetherite.CRYSTALS));
    public static final Item STRONG_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(specialisednetherite.CRYSTALS));
    public static final Item ENCHANTABILITY_CRYSTAL = new Item(new FabricItemSettings().group(specialisednetherite.CRYSTALS));
    public static final Item ENCHANTABILITY_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(specialisednetherite.CRYSTALS));
    public static final Item SHARP_CRYSTAL = new Item(new FabricItemSettings().group(specialisednetherite.CRYSTALS));
    public static final Item SHARP_CRYSTAL_SHARD = new Item(new FabricItemSettings().group(specialisednetherite.CRYSTALS));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_crystal"), SHARP_CRYSTAL);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "sharp_crystal_shard"), SHARP_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_crystal"), STRONG_CRYSTAL);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "strong_crystal_shard"), STRONG_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_crystal"), ENCHANTABILITY_CRYSTAL);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "enchanted_crystal_shard"), ENCHANTABILITY_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_crystal"), NETHER_CRYSTAL);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_crystal_shard"), NETHER_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_crystal"), END_CRYSTAL);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_crystal_shard"), END_CRYSTAL_SHARD);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_crystal"), OVERWORLD_CRYSTAL);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_crystal_shard"), OVERWORLD_CRYSTAL_SHARD);
    }
}