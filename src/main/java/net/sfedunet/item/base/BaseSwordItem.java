package net.sfedunet.item.base;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.item.AnyItemGroups;

public class BaseSwordItem extends SwordItem {

    public BaseSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed) {
        super(toolMaterial, attackDamage, attackSpeed, new FabricItemSettings().group(AnyItemGroups.TOOLS_AND_WEAPONS));
    }
}
