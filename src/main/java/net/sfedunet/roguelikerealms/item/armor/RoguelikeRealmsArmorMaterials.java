package net.sfedunet.roguelikerealms.item.armor;

import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import net.sfedunet.roguelikerealms.item.RoguelikeRealmsItems;
import net.sfedunet.roguelikerealms.item.base.BaseArmorMaterial;

public class RoguelikeRealmsArmorMaterials {
    public static final BaseArmorMaterial CRYPTON_ARMOR_MATERIAL = new BaseArmorMaterial("crypton",
            new int[] {2500, 3000, 2750, 2250},
            new int[] {4, 7, 9, 4}, 32, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3,
            Ingredient.ofItems(RoguelikeRealmsItems.CRYPTON_DUST));

    public static final BaseArmorMaterial DRAGON_ARMOR_MATERIAL = new BaseArmorMaterial("dragon",
            new int[] {3222, 3444, 3333, 3111},
            new int[] {5, 10, 12, 5}, 50, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4,
            Ingredient.ofItems(RoguelikeRealmsItems.DRAGON_INGOT));

    public static final BaseArmorMaterial ECHSEROCK_ARMOR_MATERIAL = new BaseArmorMaterial("echserock",
            new int[] {4000, 4500, 4250, 3750},
            new int[] {5, 8, 10, 5}, 0, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4,
            Ingredient.ofItems(RoguelikeRealmsItems.ECHSEROCK_CHUNK));

}
