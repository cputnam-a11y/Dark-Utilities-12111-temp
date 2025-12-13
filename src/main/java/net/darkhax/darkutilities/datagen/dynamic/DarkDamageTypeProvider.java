package net.darkhax.darkutilities.datagen.dynamic;

import net.darkhax.darkutilities.features.flatblocks.FlatTileEffects;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class DarkDamageTypeProvider extends FabricDynamicRegistryProvider {
    public DarkDamageTypeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        entries.addAll(registries.lookupOrThrow(Registries.DAMAGE_TYPE));
    }

    @Override
    public String getName() {
        return "DamageTypeProvider";
    }

    public static void bootstrapDamageTypes(BootstrapContext<DamageType> context) {
        context.register(FlatTileEffects.FAKE_PLAYER_DAMAGE, new DamageType("player", DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0.1f));
    }
}
