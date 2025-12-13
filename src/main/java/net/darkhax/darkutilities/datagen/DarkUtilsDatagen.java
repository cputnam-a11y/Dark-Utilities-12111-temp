package net.darkhax.darkutilities.datagen;

import net.darkhax.darkutilities.datagen.client.DarkAtlasProvider;
import net.darkhax.darkutilities.datagen.client.DarkModelProvider;
import net.darkhax.darkutilities.datagen.dynamic.DarkBlockLootTableProvider;
import net.darkhax.darkutilities.datagen.dynamic.DarkDamageTypeProvider;
import net.darkhax.darkutilities.datagen.lang.DarkEnglishLangProvider;
import net.darkhax.darkutilities.datagen.tag.DarkBlockTagProvider;
import net.darkhax.darkutilities.datagen.tag.DarkDamageTypeTagProvider;
import net.darkhax.darkutilities.datagen.tag.DarkItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class DarkUtilsDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();
        pack.addProvider(DarkModelProvider::new);
        pack.addProvider(DarkAtlasProvider::new);
        pack.addProvider(DarkEnglishLangProvider::new);
        pack.addProvider(DarkBlockLootTableProvider::new);
        pack.addProvider(DarkDamageTypeProvider::new);
        pack.addProvider(DarkBlockTagProvider::new);
        pack.addProvider(DarkItemTagProvider::new);
        pack.addProvider(DarkDamageTypeTagProvider::new);
        pack.addProvider(DarkRecipeProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.DAMAGE_TYPE, DarkDamageTypeProvider::bootstrapDamageTypes);
    }
}
