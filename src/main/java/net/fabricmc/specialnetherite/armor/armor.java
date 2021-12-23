package net.fabricmc.specialnetherite.armor;

import net.fabricmc.specialnetherite.specialisednetherite;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class armor {
    public static final Item OVERWORLD_NETHERITE_HELMET = new ArmorItem(armor_materials.OVERWORLD_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static final Item OVERWORLD_NETHERITE_CHESTPLATE = new ArmorItem(armor_materials.OVERWORLD_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static final Item OVERWORLD_NETHERITE_LEGGINGS = new ArmorItem(armor_materials.OVERWORLD_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static final Item OVERWORLD_NETHERITE_BOOTS = new ArmorItem(armor_materials.OVERWORLD_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());

    public static final Item NETHER_NETHERITE_HELMET = new ArmorItem(armor_materials.OVERWORLD_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static final Item NETHER_NETHERITE_CHESTPLATE = new ArmorItem(armor_materials.OVERWORLD_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static final Item NETHER_NETHERITE_LEGGINGS = new ArmorItem(armor_materials.OVERWORLD_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static final Item NETHER_NETHERITE_BOOTS = new ArmorItem(armor_materials.OVERWORLD_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());

    public static final Item END_NETHERITE_HELMET = new ArmorItem(armor_materials.OVERWORLD_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static final Item END_NETHERITE_CHESTPLATE = new ArmorItem(armor_materials.OVERWORLD_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static final Item END_NETHERITE_LEGGINGS = new ArmorItem(armor_materials.OVERWORLD_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());
    public static final Item END_NETHERITE_BOOTS = new ArmorItem(armor_materials.OVERWORLD_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(specialisednetherite.TOOLS).fireproof());

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_netherite_helmet"), OVERWORLD_NETHERITE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_netherite_chestplate"), OVERWORLD_NETHERITE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_netherite_leggings"), OVERWORLD_NETHERITE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "overworld_netherite_boots"), OVERWORLD_NETHERITE_BOOTS);

        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_netherite_helmet"), NETHER_NETHERITE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_netherite_chestplate"), NETHER_NETHERITE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_netherite_leggings"), NETHER_NETHERITE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "nether_netherite_boots"), NETHER_NETHERITE_BOOTS);

        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_netherite_helmet"), END_NETHERITE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_netherite_chestplate"), END_NETHERITE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_netherite_leggings"), END_NETHERITE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "end_netherite_boots"), END_NETHERITE_BOOTS);
    }
}