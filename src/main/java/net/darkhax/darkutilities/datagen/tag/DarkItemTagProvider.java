package net.darkhax.darkutilities.datagen.tag;

import net.darkhax.darkutilities.DarkUtils;
import net.darkhax.darkutilities.utils.DarkUtilsTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class DarkItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public DarkItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(DarkUtilsTags.Items.CHARMS).add(
                DarkUtils.getInstance().content.portalCharm,
                DarkUtils.getInstance().content.sleepCharm,
                DarkUtils.getInstance().content.wardingCharm
        );
        valueLookupBuilder(DarkUtilsTags.Items.DARK_STONES).add(
                Blocks.DEEPSLATE.asItem(),
                Blocks.COBBLED_DEEPSLATE.asItem(),
                Blocks.POLISHED_DEEPSLATE.asItem(),
                Blocks.DEEPSLATE_BRICKS.asItem(),
                Blocks.CRACKED_DEEPSLATE_BRICKS.asItem(),
                Blocks.DEEPSLATE_TILES.asItem(),
                Blocks.CRACKED_DEEPSLATE_TILES.asItem(),
                Blocks.CHISELED_DEEPSLATE.asItem(),
                Blocks.BLACKSTONE.asItem(),
                Blocks.POLISHED_BLACKSTONE.asItem(),
                Blocks.CHISELED_POLISHED_BLACKSTONE.asItem(),
                Blocks.POLISHED_BLACKSTONE_BRICKS.asItem(),
                Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.asItem(),
                Blocks.BASALT.asItem(),
                Blocks.POLISHED_BASALT.asItem(),
                Blocks.SMOOTH_BASALT.asItem()
        );
        valueLookupBuilder(DarkUtilsTags.Items.PLATE_BASE).add(
                DarkUtils.getInstance().content.blankPlate.asItem()
        ).addTag(
                DarkUtilsTags.Items.DARK_STONES
        );
        valueLookupBuilder(DarkUtilsTags.Items.TOMES).add(
                DarkUtils.getInstance().content.enchantingTome,
                DarkUtils.getInstance().content.shadowTome
        );
    }
}
