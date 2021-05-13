package net.sfedunet.roguelikerealms.world.features.trees.placers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ModifiableTestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.sfedunet.roguelikerealms.world.features.trees.RoguelikeRealmsTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Deprecated //спизжено(зачеркнуто) позаимствовано у аезера так что todo: давай по новой миша
public class DragonWillowTrunkPlacer extends TrunkPlacer {

    public static final Codec<DragonWillowTrunkPlacer> CODEC = RecordCodecBuilder.create(instance ->
            method_28904(instance).apply(instance, DragonWillowTrunkPlacer::new));

    public DragonWillowTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return RoguelikeRealmsTrees.DRAGON_WILLOW_TRUNK;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(ModifiableTestableWorld world, Random random, int trunkHeight, BlockPos pos, Set<BlockPos> placedStates, BlockBox box, TreeFeatureConfig config) {
        List<FoliagePlacer.TreeNode> nodes = new ArrayList<>();
        BlockState trunk = config.trunkProvider.getBlockState(random, pos);
        int heightMain = baseHeight + random.nextInt(firstRandomHeight + 1);
        for (int i = 0; i < heightMain; i++) {
            getAndSetState(world, random, pos, placedStates, box, config);
            pos = pos.up();
        }
        boolean branching = random.nextBoolean();

        //main node
        int secHeight = (baseHeight + random.nextInt(secondRandomHeight + 1)) / 2;
        int upHeight = random.nextInt(3) + 2;
        Direction t1Main = Direction.fromHorizontal(random.nextInt(5));
        Direction t1Sec = random.nextBoolean() ? t1Main.rotateYClockwise() : t1Main.rotateYCounterclockwise();
        BlockState logState = trunk.getBlock().getDefaultState().with(PillarBlock.AXIS, t1Main.getAxis());
        BlockPos logLine = pos.offset(t1Main);
        for (int i = 0; i < secHeight; i++) {
            setBlockState(world, logLine, logState, box);
            if(i != 0 && i % upHeight == 0)
                logLine = logLine.up();
            logLine = logLine.offset(t1Main);
        }
        nodes.add(new FoliagePlacer.TreeNode(logLine, 0, false));

        if(branching) {
            //sec node
            Direction t2node = Direction.fromHorizontal(random.nextInt(5));
            upHeight = random.nextInt(3) + 1;
            logState = trunk.getBlock().getDefaultState().with(PillarBlock.AXIS, t2node.getAxis());
            for (int i = 0; i < secHeight * 1.5; i++) {
                setBlockState(world, logLine, logState, box);
                if(i != 0 && i % upHeight == 0)
                    logLine = logLine.up();
                logLine = logLine.offset(t2node);
            }
            setBlockState(world, logLine, logState, box);
            nodes.add(new FoliagePlacer.TreeNode(logLine, 1, false));

            //conditional main node
            upHeight = random.nextInt(2) + 1;
            logState = trunk.getBlock().getDefaultState().with(PillarBlock.AXIS, t1Main.getAxis());
            Direction oppsite = t1Main.getOpposite();
            logLine = pos.offset(oppsite).down(random.nextInt((int) (trunkHeight / 1.5)));
            for (int i = 0; i < secHeight + random.nextInt(upHeight + 1); i++) {
                setBlockState(world, logLine, logState, box);
                if(i != 0 && i % upHeight == 0)
                    logLine = logLine.up();
                logLine = logLine.offset(oppsite);
            }
            setBlockState(world, logLine, logState, box);
            nodes.add(new FoliagePlacer.TreeNode(logLine, 0, false));
        }
        //main node 2
        upHeight = random.nextInt(2) + 1;
        logState = trunk.getBlock().getDefaultState().with(PillarBlock.AXIS, t1Sec.getAxis());
        logLine = pos.offset(t1Sec).down(random.nextInt((int) (trunkHeight / 1.5)));
        for (int i = 0; i < secHeight + random.nextInt(upHeight + 1); i++) {
            setBlockState(world, logLine, logState, box);
            if(i != 0 && i % upHeight == 0)
                logLine = logLine.up();
            logLine = logLine.offset(t1Sec);
        }

        //Second conditional main node
        if(random.nextBoolean()) {
            Direction t1Third = t1Sec.getOpposite();

            upHeight = random.nextInt(3) + 2;
            logState = trunk.getBlock().getDefaultState().with(PillarBlock.AXIS, t1Third.getAxis());
            Direction oppsite = t1Third.getOpposite();
            logLine = pos.offset(oppsite).down(random.nextInt((int) (trunkHeight / 1.5)));
            for (int i = 0; i < secHeight + random.nextInt(upHeight + 1); i++) {
                setBlockState(world, logLine, logState, box);
                if(i != 0 && i % upHeight == 0)
                    logLine = logLine.up();
                logLine = logLine.offset(oppsite);
            }
            setBlockState(world, logLine, logState, box);
            nodes.add(new FoliagePlacer.TreeNode(logLine, 0, false));
        }
        setBlockState(world, logLine, logState, box);
        nodes.add(new FoliagePlacer.TreeNode(logLine, 0, false));
        return nodes;
    }
}
