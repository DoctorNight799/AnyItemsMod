package net.sfedunet.roguelikerealms.mixin.common;

import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.sfedunet.roguelikerealms.block.RoguelikeRealmsBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlantBlock.class)
public class PlantBlockMixin {

    @Inject(method = "canPlantOnTop", at = @At("TAIL"), cancellable = true)
    protected void canPlantOnTop(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if(floor.isOf(RoguelikeRealmsBlocks.DRAGOSS) || floor.isOf(RoguelikeRealmsBlocks.DRAGON_DIRT)){
            cir.setReturnValue(true);
        }
    }
}
