package net.sfedunet.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.AnyItemsMod;
import net.sfedunet.block.base.BaseBlock;

import java.util.LinkedHashMap;
import java.util.Map;

public class AnyItemsBlocks {

    private static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();
    private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

    public static final Block CRYPTON_BLOCK = add("crypton_block", new BaseBlock(Blocks.OBSIDIAN, BlockSoundGroup.BONE));
    public static final Block CRYPTON_ORE = add("crypton_ore", new BaseBlock());
    public static final Block ECHSEROCK = add("echserock", new BaseBlock());
    public static final Block ASHES_BLOCK = add("ashes_block", new BaseBlock(Blocks.SAND, BlockSoundGroup.SAND));
    public static final Block DRAGON_INGOT_BLOCK = add("dragon_ingot_block", new BaseBlock(Blocks.IRON_BLOCK, BlockSoundGroup.METAL));
    public static final Block DRAGON_SCALES_BLOCK = add("dragon_scales_block", new BaseBlock(Blocks.STONE, BlockSoundGroup.NETHER_BRICKS));
    public static final Block DRAGON_WOOD = add("dragon_wood", new BaseBlock(Blocks.OAK_PLANKS, BlockSoundGroup.WOOD));
    public static final Block DRAGON_STONE = add("dragon_stone", new BaseBlock());
    public static final Block DRAGON_COBBLESTONE = add("dragon_cobblestone", new BaseBlock());
    public static final Block DRAGON_PLANKS = add("dragon_planks", new BaseBlock(Blocks.OAK_PLANKS, BlockSoundGroup.WOOD));
    public static final Block DRAGON_LEAVES1 = add("dragon_leaves1", new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).strength(0f).sounds(BlockSoundGroup.GRASS)));
    public static final Block DRAGON_LEAVES2 = add("dragon_leaves2", new LeavesBlock(FabricBlockSettings.copy(Blocks.OAK_LEAVES).strength(0f).sounds(BlockSoundGroup.GRASS)));
    public static final Block DRACONIC_SHADOW_PORTAL = add("draconic_shadow_portal", new DraconicShadowPortalBlock());

    private static <B extends Block> B add(String name, B block, ItemGroup tab) {
        Item.Settings settings = new Item.Settings();
        if (tab != null) {
            settings.group(tab);
        }
        return add(name, block, new BlockItem(block, settings));
    }

    private static <B extends Block> B add(String name, B block, BlockItem item) {
        addBlock(name, block);
        if (item != null) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            ITEMS.put(new Identifier(AnyItemsMod.MODID, name), item);
        }
        return block;
    }

    private static <B extends Block> B addBlock(String name, B block) {
        BLOCKS.put(new Identifier(AnyItemsMod.MODID, name), block);
        return block;
    }
    private static <B extends Block> B add(String name, B block) {
        Item.Settings settings = new Item.Settings();
        settings.group(AnyItemsMod.GENERAL);
        return add(name, block, new BlockItem(block, settings));
    }

    private static <I extends BlockItem> I add(String name, I item) {
        item.appendBlocks(Item.BLOCK_ITEMS, item);
        ITEMS.put(new Identifier(AnyItemsMod.MODID, name), item);
        return item;
    }

    public static void register() {

        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
    }

}