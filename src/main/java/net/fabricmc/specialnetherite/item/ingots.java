package net.fabricmc.specialnetherite.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.specialnetherite.specialisednetherite;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ingots {
    public static final Item RAW_TIN = new Item(new FabricItemSettings().group(specialisednetherite.ORES));
    public static final Item TIN_INGOT = new Item(new FabricItemSettings().group(specialisednetherite.ORES));
    public static final Item RAW_BRONZE = new Item(new FabricItemSettings().group(specialisednetherite.ORES));
    public static final Item BRONZE_INGOT = new Item(new FabricItemSettings().group(specialisednetherite.ORES));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "raw_tin"), RAW_TIN);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "tin_ingot"), TIN_INGOT);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "raw_bronze"), RAW_BRONZE);
        Registry.register(Registry.ITEM, new Identifier("specialnetherite", "bronze_ingot"), BRONZE_INGOT);
    }
}