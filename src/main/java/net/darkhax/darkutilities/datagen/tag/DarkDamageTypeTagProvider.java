package net.darkhax.darkutilities.datagen.tag;

import net.darkhax.darkutilities.features.flatblocks.FlatTileEffects;
import net.darkhax.darkutilities.utils.DarkUtilsTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageType;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class DarkDamageTypeTagProvider extends FabricTagProvider<DamageType> {

    public DarkDamageTypeTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.DAMAGE_TYPE, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        builder(DarkUtilsTags.DamageTypes.FAKE_PLAYER).add(
                FlatTileEffects.FAKE_PLAYER_DAMAGE
        );
    }
}
