package net.sfedunet.roguelikerealms.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.util.Identifier;
import net.sfedunet.roguelikerealms.RoguelikeRealmsMod;
import net.sfedunet.roguelikerealms.entity.DragonSwordmanEntity;
import net.sfedunet.roguelikerealms.entity.model.DragonSwordmanEntityModel;

@Environment(EnvType.CLIENT)
public class DragonSwordmanEntityRenderer extends BipedEntityRenderer<DragonSwordmanEntity, DragonSwordmanEntityModel<DragonSwordmanEntity>> {
    public DragonSwordmanEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new DragonSwordmanEntityModel<>(), 0.5f);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel<>(0.5f), new BipedEntityModel<>(1.0f)));
    }

    private static final Identifier TEXTURE = new Identifier(RoguelikeRealmsMod.MODID, "textures/entity/dragon_swordman.png");

    @Override
    public Identifier getTexture(DragonSwordmanEntity entity) {
        return TEXTURE;
    }
}