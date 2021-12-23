package net.fabricmc.specialnetherite.tools;

import net.fabricmc.specialnetherite.specialisednetherite;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;

public class tool_materials {

    static class StrongNetherite implements ToolMaterial {
        public static final StrongNetherite INSTANCE = new StrongNetherite();

        @Override
        public int getDurability() {
            return 4064;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 6f;
        }

        @Override
        public float getAttackDamage() {
            return 8;
        }

        @Override
        public int getMiningLevel() {
            return 4;
        }

        @Override
        public int getEnchantability() {
            return 4;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.NETHERITE_INGOT);
        }

        public static class StrongAxe extends AxeItem {
            public StrongAxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }

        public static class StrongPickaxe extends PickaxeItem {
            public StrongPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }

        public static class StrongHoe extends HoeItem {
            public StrongHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }

    }
    static class SharpNetherite implements ToolMaterial {


        public static final SharpNetherite INSTANCE = new SharpNetherite();

        @Override
        public int getDurability() {
            return 2032;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 6f;
        }

        @Override
        public float getAttackDamage() {
            return 13;
        }

        @Override
        public int getMiningLevel() {
            return 4;
        }

        @Override
        public int getEnchantability() {
            return 4;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.NETHERITE_INGOT);
        }

        public static class SharpAxe extends AxeItem {
            public SharpAxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }
    }
    static class NetherNetherite implements ToolMaterial {


        public static final NetherNetherite INSTANCE = new NetherNetherite();

        @Override
        public int getDurability() {
            return 2532;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 6f;
        }

        @Override
        public float getAttackDamage() {
            return 0;
        }

        @Override
        public int getMiningLevel() {
            return 4;
        }

        @Override
        public int getEnchantability() {
            return 4;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.NETHERITE_INGOT);
        }

        public static class NetherAxe extends AxeItem {
            public NetherAxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }

        public static class NetherPickaxe extends PickaxeItem {
            public NetherPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }

        public static class NetherHoe extends HoeItem {
            public NetherHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }


    }
    static class OverworldNetherite implements ToolMaterial {


        public static final OverworldNetherite INSTANCE = new OverworldNetherite();

        @Override
        public int getDurability() {
            return 3042;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 6f;
        }

        @Override
        public float getAttackDamage() {
            return 0;
        }

        @Override
        public int getMiningLevel() {
            return 4;
        }

        @Override
        public int getEnchantability() {
            return 4;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.NETHERITE_INGOT);
        }

        public static class OverAxe extends AxeItem {
            public OverAxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }

        public static class OverPickaxe extends PickaxeItem {
            public OverPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }

        public static class OverHoe extends HoeItem {
            public OverHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }


    }
    static class EndNetherite implements ToolMaterial {


        public static final EndNetherite INSTANCE = new EndNetherite();

        @Override
        public int getDurability() {
            return 2532;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 6f;
        }

        @Override
        public float getAttackDamage() {
            return 0;
        }

        @Override
        public int getMiningLevel() {
            return 4;
        }

        @Override
        public int getEnchantability() {
            return 4;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.NETHERITE_INGOT);
        }

        public static class EndAxe extends AxeItem {
            public EndAxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }

        public static class EndPickaxe extends PickaxeItem {
            public EndPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }

        public static class EndHoe extends HoeItem {
            public EndHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }

    }
    static class EnchantedNetherite implements ToolMaterial {
        public static final EnchantedNetherite INSTANCE = new EnchantedNetherite();

        @Override
        public int getDurability() {
            return 2032;
        }

        @Override
        public float getMiningSpeedMultiplier() {
            return 6f;
        }

        @Override
        public float getAttackDamage() {
            return 11;
        }

        @Override
        public int getMiningLevel() {
            return 4;
        }

        @Override
        public int getEnchantability() {
            return 30;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.NETHERITE_INGOT);
        }

        public static class EnchantedAxe extends AxeItem {
            public EnchantedAxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }

        public static class EnchantedPickaxe extends PickaxeItem {
            public EnchantedPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }

        public static class EnchantedHoe extends HoeItem {
            public EnchantedHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
                super(material, attackDamage, attackSpeed, settings);
            }
        }

    }

}