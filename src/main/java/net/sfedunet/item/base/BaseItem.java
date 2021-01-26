package net.sfedunet.item.base;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.sfedunet.AnyItemsMod;

public class BaseItem extends Item {

    public BaseItem() {
        super(new FabricItemSettings().group(AnyItemsMod.GENERAL));
    }
    public BaseItem(Settings settings) {
        super(settings);
    }
}