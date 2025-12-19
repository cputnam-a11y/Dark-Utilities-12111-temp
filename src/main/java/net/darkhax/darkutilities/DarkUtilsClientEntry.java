package net.darkhax.darkutilities;

import net.darkhax.darkutilities.features.filters.BlockEntityFilter;
import net.darkhax.darkutilities.features.grates.BlockItemGrate;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.world.item.BlockItem;

public class DarkUtilsClientEntry implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register(DarkUtils.getInstance()::addDescriptionTooltips);
        for (var item : DarkUtils.getInstance().content.items) {
            if (item instanceof BlockItem blockItem) {
                if (blockItem.getBlock() instanceof BlockEntityFilter) {
                    BlockRenderLayerMap.putBlock(blockItem.getBlock(), ChunkSectionLayer.TRANSLUCENT);
                } else if (blockItem.getBlock() instanceof BlockItemGrate) {
                    BlockRenderLayerMap.putBlock(blockItem.getBlock(), ChunkSectionLayer.CUTOUT);
                }
            }
        }
    }
}
