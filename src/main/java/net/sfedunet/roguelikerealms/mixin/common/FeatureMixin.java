package net.sfedunet.roguelikerealms.mixin.common;

import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.Feature;
import net.sfedunet.roguelikerealms.block.RoguelikeRealmsBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Feature.class)
public class FeatureMixin {

    @Inject(method = "isSoil(Lnet/minecraft/block/Block;)Z", at = @At("HEAD")  , cancellable = true)
    private static void isSoil(Block block, CallbackInfoReturnable<Boolean> cir) {
        if(block == RoguelikeRealmsBlocks.DRAGOSS || block == RoguelikeRealmsBlocks.DRAGON_DIRT){
            cir.setReturnValue(true);
        }
    }
}
