package net.fabricmc.specialnetherite.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

public class armor_materials {
    public static class OverworldArmorMaterial implements ArmorMaterial {
        private static final int[] BASE_DURABILITY = new int[] {55, 57, 58, 53};
        private static final int[] PROTECTION_VALUES = new int[] {4, 7, 9, 3};

        @Override
        public int getDurability(EquipmentSlot slot) {
            return BASE_DURABILITY[slot.getEntitySlotId()];
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slot) {
            return PROTECTION_VALUES[slot.getEntitySlotId()];
        }

        @Override
        public int getEnchantability() {
            return 5;
        }

        @Override
        public SoundEvent getEquipSound() {
            return null;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.NETHERITE_INGOT);
        }

        @Override
        public String getName() {
            // Must be all lowercase
            return "overworld";
        }

        @Override
        public float getToughness() {
            return 4;
        }

        @Override
        public float getKnockbackResistance() {
            return 0;
        }
    }
    public static final ArmorMaterial OVERWORLD_ARMOR_MATERIAL = new OverworldArmorMaterial();

    public static class NetherArmorMaterial implements ArmorMaterial {
        private static final int[] BASE_DURABILITY = new int[] {55, 57, 58, 53};
        private static final int[] PROTECTION_VALUES = new int[] {4, 7, 9, 3};

        @Override
        public int getDurability(EquipmentSlot slot) {
            return BASE_DURABILITY[slot.getEntitySlotId()];
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slot) {
            return PROTECTION_VALUES[slot.getEntitySlotId()];
        }

        @Override
        public int getEnchantability() {
            return 5;
        }

        @Override
        public SoundEvent getEquipSound() {
            return null;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.NETHERITE_INGOT);
        }

        @Override
        public String getName() {
            // Must be all lowercase
            return "nether";
        }

        @Override
        public float getToughness() {
            return 4;
        }

        @Override
        public float getKnockbackResistance() {
            return 0;
        }
    }
    public static final ArmorMaterial NETHER_ARMOR_MATERIAL = new NetherArmorMaterial();

    public static class EndArmorMaterial implements ArmorMaterial {
        private static final int[] BASE_DURABILITY = new int[] {55, 57, 58, 53};
        private static final int[] PROTECTION_VALUES = new int[] {4, 7, 9, 3};

        @Override
        public int getDurability(EquipmentSlot slot) {
            return BASE_DURABILITY[slot.getEntitySlotId()];
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slot) {
            return PROTECTION_VALUES[slot.getEntitySlotId()];
        }

        @Override
        public int getEnchantability() {
            return 5;
        }

        @Override
        public SoundEvent getEquipSound() {
            return null;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(Items.NETHERITE_INGOT);
        }

        @Override
        public String getName() {
            // Must be all lowercase
            return "end";
        }

        @Override
        public float getToughness() {
            return 4;
        }

        @Override
        public float getKnockbackResistance() {
            return 0;
        }
    }
    public static final ArmorMaterial END_ARMOR_MATERIAL = new EndArmorMaterial();
}