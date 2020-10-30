package net.sfedunet.instruments;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.sfedunet.AnyItemsMod;

public class CryptonPickaxe extends PickaxeItem {
    public CryptonPickaxe(ToolMaterial toolmaterial) {
        super(toolmaterial, -2, 0, new Item.Settings().group(AnyItemsMod.AI_GENERAL));
    }
}