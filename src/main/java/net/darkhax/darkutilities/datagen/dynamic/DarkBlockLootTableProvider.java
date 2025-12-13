package net.darkhax.darkutilities.datagen.dynamic;

import net.darkhax.darkutilities.DarkUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.BlockItem;

import java.util.concurrent.CompletableFuture;

public class DarkBlockLootTableProvider extends FabricBlockLootTableProvider {
    public DarkBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        for (var item : DarkUtils.getInstance().content.items) {
            if (item instanceof BlockItem blockItem) {
                dropSelf(blockItem.getBlock());
            }
        }
    }
}
