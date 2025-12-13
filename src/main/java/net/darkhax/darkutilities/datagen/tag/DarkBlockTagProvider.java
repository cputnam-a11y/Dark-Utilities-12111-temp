package net.darkhax.darkutilities.datagen.tag;

import net.darkhax.darkutilities.DarkUtils;
import net.darkhax.darkutilities.utils.DarkUtilsTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class DarkBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public DarkBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(DarkUtilsTags.Blocks.VECTOR_PLATES).add(
                DarkUtils.getInstance().content.vectorPlate,
                DarkUtils.getInstance().content.vectorPlateFast,
                DarkUtils.getInstance().content.vectorPlateExtreme,
                DarkUtils.getInstance().content.vectorPlateUltra
        );
        valueLookupBuilder(DarkUtilsTags.Blocks.DAMAGE_PLATES).add(
                DarkUtils.getInstance().content.damagePlate,
                DarkUtils.getInstance().content.playerDamagePlate,
                DarkUtils.getInstance().content.maimPlate
        );
        valueLookupBuilder(DarkUtilsTags.Blocks.FLAT_TILES).add(
                DarkUtils.getInstance().content.flamePlate,
                DarkUtils.getInstance().content.slownessPlate,
                DarkUtils.getInstance().content.fatiguePlate,
                DarkUtils.getInstance().content.darknessPlate,
                DarkUtils.getInstance().content.hungerPlate,
                DarkUtils.getInstance().content.weaknessPlate,
                DarkUtils.getInstance().content.poisonPlate,
                DarkUtils.getInstance().content.witherPlate,
                DarkUtils.getInstance().content.glowingPlate,
                DarkUtils.getInstance().content.levitationPlate,
                DarkUtils.getInstance().content.misfortunePlate,
                DarkUtils.getInstance().content.slowfallPlate,
                DarkUtils.getInstance().content.omenPlate,
                DarkUtils.getInstance().content.frostPlate,
                DarkUtils.getInstance().content.smitePlate,
                DarkUtils.getInstance().content.banePlate,
                DarkUtils.getInstance().content.anchorPlate,
                DarkUtils.getInstance().content.blankPlate
        ).addTag(
                DarkUtilsTags.Blocks.VECTOR_PLATES
        ).addTag(
                DarkUtilsTags.Blocks.DAMAGE_PLATES
        );
        valueLookupBuilder(DarkUtilsTags.Blocks.MOB_FILTERS).add(
                DarkUtils.getInstance().content.filterPlayer,
                DarkUtils.getInstance().content.filterUndead,
                DarkUtils.getInstance().content.filterArthropod,
                DarkUtils.getInstance().content.filterIllager,
                DarkUtils.getInstance().content.filterRaider,
                DarkUtils.getInstance().content.filterHostile,
                DarkUtils.getInstance().content.filterAnimal,
                DarkUtils.getInstance().content.filterBaby,
                DarkUtils.getInstance().content.filterPet,
                DarkUtils.getInstance().content.filterSlime,
                DarkUtils.getInstance().content.filterVillager,
                DarkUtils.getInstance().content.filterFireImmune,
                DarkUtils.getInstance().content.filterGolem,
                DarkUtils.getInstance().content.filterWater,
                DarkUtils.getInstance().content.filterNamed,
                DarkUtils.getInstance().content.filterFreezeImmune,
                DarkUtils.getInstance().content.filterEquipment,
                DarkUtils.getInstance().content.filterPassenger
        );
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        DarkUtils.getInstance().content.redstoneRandomizer,
                        DarkUtils.getInstance().content.shieldedRedstone
                ).addTag(
                        DarkUtilsTags.Blocks.FLAT_TILES
                ).addTag(
                        DarkUtilsTags.Blocks.MOB_FILTERS
                );
        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE).addTag(
                DarkUtilsTags.Blocks.MOB_FILTERS
        );
    }
}
