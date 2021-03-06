package net.sfedunet.roguelikerealms.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.sfedunet.roguelikerealms.RoguelikeRealmsMod;
import net.sfedunet.roguelikerealms.block.base.*;
import net.sfedunet.roguelikerealms.item.RoguelikeRealmsItemGroups;

import java.util.LinkedHashMap;
import java.util.Map;

public class RoguelikeRealmsBlocks {

    private static final Map<Identifier, BlockItem> ITEMS = new LinkedHashMap<>();
    private static final Map<Identifier, Block> BLOCKS = new LinkedHashMap<>();

    public static final Block CRYPTON_BLOCK = add("crypton_block", new BaseBlock(Blocks.OBSIDIAN, BlockSoundGroup.BONE, "cube_all"));
    public static final Block CRYPTON_ORE = add("crypton_ore", new BaseBlock("cube_all"));

    public static final Block ECHSEROCK = add("echserock", new BaseBlock(FabricBlockSettings.copyOf(Blocks.STONE).luminance(14), "cube_all"));
    public static final Block ASHES_BLOCK = add("ashes_block", new BaseFallingBlock(FabricBlockSettings.copyOf(Blocks.SAND), "cube_all"));
    public static final Block DRAGON_INGOT_BLOCK = add("dragon_ingot_block", new BaseBlock(Blocks.IRON_BLOCK, "cube_all"));
    public static final Block DRAGON_SCALES_BLOCK = add("dragon_scales_block", new DragonScalesBlock("normal"));
    public static final Block GILDED_DRAGON_SCALES_BLOCK = add("gilded_dragon_scales_block", new DragonScalesBlock("gilded"));

    public static final Block DRAGON_STONE = add("dragon_stone", new BaseBlock("cube_all"));
    public static final Block DRAGON_COBBLESTONE = add("dragon_cobblestone", new BaseBlock("cube_all"));
    public static final Block DRAGON_STONE_TILES = add("dragon_stone_tiles", new BaseBlock("cube_all"));
    public static final Block CRACKED_DRAGON_STONE_TILES = add("cracked_dragon_stone_tiles", new BaseBlock("cube_all"));
    public static final Block DRAGON_STONE_BRICKS = add("dragon_stone_bricks", new BaseBlock("cube_all"));
//    public static final Block OVERGROWN_DRAGON_STONE_BRICKS = add("overgrown_dragon_stone_bricks", new BaseBlock());
    public static final Block SMOOTH_DRAGON_STONE = add("smooth_dragon_stone", new BaseBlock("cube_all"));
    public static final Block CHISELED_DRAGON_STONE = add("chiseled_dragon_stone", new BaseBlock("cube_all"));
    public static final Block DRAGON_STONE_PILLAR = add("dragon_stone_pillar", new BasePillarBlock(FabricBlockSettings.copyOf(Blocks.STONE),"cube_column"));


    public static final Block DRAGON_DIRT = add("dragon_dirt", new BaseBlock(Blocks.DIRT, "cube_all"));
    public static final Block DRAGOSS = add("dragoss", new BaseBlock(Blocks.GRASS_BLOCK, "custom_model")); //драконий дерн оригинально да? P.s да
    public static final Block DRAGON_GRASS = add("dragon_grass", new BasePlantBlock(FabricBlockSettings.copyOf(Blocks.GRASS), "cross"));
    public static final Block DRAGON_DAISY = add("dragon_daisy", new BaseFlowerBlock(StatusEffects.FIRE_RESISTANCE, 240, FabricBlockSettings.copyOf(Blocks.OXEYE_DAISY).luminance(7), "cross"));
    public static final Block DRACONIC_SHADOW_PORTAL = addBlock("draconic_shadow_portal", new DraconicShadowPortalBlock());
    public static final Block EMERALD_PEDESTAL = add("emerald_pedestal", new EmeraldPedestal());

    public static final Block DRAGON_GRAPE_LOG = add("dragon_grape_log", new BasePillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG), "cube_column"));
    public static final Block DRAGON_GRAPE_PLANKS = add("dragon_grape_planks", new BaseBlock(Blocks.OAK_PLANKS, "cube_all"));
    public static final Block DRAGON_GRAPE_LEAVES = add("dragon_grape_leaves", new BaseLeaveBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES), "cube_all"));
    public static final Block DRAGON_GRAPE_VINES = add("dragon_grape_vines", new GrapeVinesBlock("normal", "cross"));
    public static final Block DRAGON_GRAPE_VINES_TIP = add("dragon_grape_vines_tip", new GrapeVinesBlock("tip", "cross"));
    public static final Block GRAPED_DRAGON_GRAPE_VINES = add("graped_dragon_grape_vines", new GrapeVinesBlock("graped", "cross"));

    public static final Block DRAGON_WILLOW_LOG = add("dragon_willow_log", new BasePillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG), "cube_column"));
    public static final Block DRAGON_WILLOW_PLANKS = add("dragon_willow_planks", new BaseBlock(Blocks.OAK_PLANKS, "cube_all"));
    public static final Block DRAGON_WILLOW_LEAVES = add("dragon_willow_leaves", new BaseLeaveBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES), "cube_all"));
    public static final Block DRAGON_WILLOW_VINES = add("dragon_willow_vines", new WillowVinesBlock("normal", "cross"));
    public static final Block DRAGON_WILLOW_VINES_TIP = add("dragon_willow_vines_tip", new WillowVinesBlock("tip", "cross"));


    private static <B extends Block> B add(String name, B block) {
        Item.Settings settings = new Item.Settings();
        settings.group(RoguelikeRealmsItemGroups.BLOCKS);
        return addBlockItem(name, block, new BlockItem(block, settings));
    }

    private static <B extends Block> B addBlockItem(String name, B block, BlockItem item) {
        addBlock(name, block);
        if (item != null) {
            item.appendBlocks(Item.BLOCK_ITEMS, item);
            ITEMS.put(new Identifier(RoguelikeRealmsMod.MODID, name), item);
        }
        return block;
    }

    private static <B extends Block> B addBlock(String name, B block) {
        BLOCKS.put(new Identifier(RoguelikeRealmsMod.MODID, name), block);
        return block;
    }

    public static void register() {

        for (Identifier id : ITEMS.keySet()) {
            Registry.register(Registry.ITEM, id, ITEMS.get(id));
        }
        for (Identifier id : BLOCKS.keySet()) {
            Registry.register(Registry.BLOCK, id, BLOCKS.get(id));
        }
    }

    public static Map<Identifier, Block> getBlocks() {
        return BLOCKS;
    }

}
