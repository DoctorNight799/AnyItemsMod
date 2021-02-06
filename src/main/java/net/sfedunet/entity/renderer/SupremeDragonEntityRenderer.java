package net.sfedunet.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.util.Identifier;
import net.sfedunet.entity.SupremeDragonEntity;
import net.sfedunet.entity.model.SupremeDragonEntityModel;

@Environment(EnvType.CLIENT)
public class SupremeDragonEntityRenderer extends BipedEntityRenderer<SupremeDragonEntity, SupremeDragonEntityModel> {
    public SupremeDragonEntityRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new SupremeDragonEntityModel(0.0F, false), 0.5f);
        this.addFeature(new ArmorFeatureRenderer<>(this, new BipedEntityModel<>(0.5f), new BipedEntityModel<>(1.0f)));
    }

    private static final Identifier TEXTURE = new Identifier("anyitem:textures/entity/supreme_dragon.png");
    
    @Override
   public Identifier getTexture(SupremeDragonEntity entity) {
      return TEXTURE;
   }
}