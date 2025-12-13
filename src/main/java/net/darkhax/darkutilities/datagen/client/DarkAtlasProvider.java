package net.darkhax.darkutilities.datagen.client;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricCodecDataProvider;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.renderer.texture.atlas.SpriteSources;
import net.minecraft.client.renderer.texture.atlas.sources.SingleFile;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NullMarked;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

import static net.darkhax.darkutilities.Constants.id;

@NullMarked
public class DarkAtlasProvider extends FabricCodecDataProvider<List<SpriteSource>> {
    public DarkAtlasProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(dataOutput, registriesFuture, PackOutput.Target.RESOURCE_PACK, "atlases", SpriteSources.FILE_CODEC);
    }

    @Override
    protected void configure(BiConsumer<Identifier, List<SpriteSource>> provider, HolderLookup.Provider lookup) {
        provider.accept(
                Identifier.withDefaultNamespace("blocks"),
                List.of(
                        aliasItem(Items.BONE),
                        aliasItem(Items.WHEAT),
                        aliasItem(Items.SPIDER_EYE),
                        aliasItem(Items.EGG),
                        aliasItem(Items.BLAZE_POWDER),
                        aliasItem(Items.SNOWBALL),
                        aliasItem(Items.SLIME_BALL),
                        aliasItem(Items.ROTTEN_FLESH),
                        aliasItem(Items.EMERALD),
                        aliasItem(Items.WATER_BUCKET),
                        aliasItem(Items.BELL),
                        aliasItem(Items.MILK_BUCKET),
                        aliasItem(Items.MINECART),
                        aliasItem(Items.NAME_TAG),
                        aliasItem(Items.GOLDEN_CHESTPLATE)
                )
        );
    }

    @Override
    public String getName() {
        return "AtlasProvider";
    }

    public SingleFile aliasItem(Item item) {
        return new SingleFile(ModelLocationUtils.getModelLocation(item), Optional.of(id(BuiltInRegistries.ITEM.getResourceKey(item).orElseThrow().identifier().getPath())));
    }
}
