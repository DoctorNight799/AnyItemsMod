package net.sfedunet.tools;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonSword extends SwordItem {
    public CryptonSword(ToolMaterial toolMaterial) {
        super(toolMaterial, 2, 0, new Settings().group(AnyItemsMod.GENERAL));
    }
}