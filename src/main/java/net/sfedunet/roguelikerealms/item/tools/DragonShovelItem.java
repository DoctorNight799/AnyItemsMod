package net.sfedunet.roguelikerealms.item.tools;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Language;
import net.minecraft.world.World;
import net.sfedunet.roguelikerealms.RoguelikeRealmsMod;
import net.sfedunet.roguelikerealms.item.RoguelikeRealmsItemGroups;

import java.util.List;

public class DragonShovelItem extends ShovelItem {
    public DragonShovelItem(ToolMaterial material, float attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new FabricItemSettings().group(RoguelikeRealmsItemGroups.TOOLS_AND_WEAPONS));
    }
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(2, attacker, (e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        target.setOnFireFor(5);
        return true;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        String flammable = Language.getInstance().get("tooltip." + RoguelikeRealmsMod.MODID + ".flammable");
        tooltip.add(new LiteralText(flammable));
    }
}
