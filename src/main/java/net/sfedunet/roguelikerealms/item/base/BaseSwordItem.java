package net.sfedunet.roguelikerealms.item.base;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.roguelikerealms.item.RoguelikeRealmsItemGroups;

public class BaseSwordItem extends SwordItem {

    public BaseSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed, new FabricItemSettings().group(RoguelikeRealmsItemGroups.TOOLS_AND_WEAPONS));
    }
}
