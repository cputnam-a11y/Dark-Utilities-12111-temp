package net.darkhax.darkutilities.utils;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NullMarked;

import static net.darkhax.darkutilities.Constants.id;

@NullMarked
public class DarkUtilsTags {
    public static class DamageTypes {
        public static TagKey<DamageType> FAKE_PLAYER = TagKey.create(Registries.DAMAGE_TYPE, id("fake_player"));
    }

    public static class Blocks {
        public static TagKey<Block> VECTOR_PLATES = TagKey.create(Registries.BLOCK, id("vector_plates"));
        public static TagKey<Block> MOB_FILTERS = TagKey.create(Registries.BLOCK, id("mob_filters"));
        public static TagKey<Block> FLAT_TILES = TagKey.create(Registries.BLOCK, id("flat_tiles"));
        public static TagKey<Block> DAMAGE_PLATES = TagKey.create(Registries.BLOCK, id("damage_plates"));
    }

    public static class Items {
        public static TagKey<Item> CHARMS = TagKey.create(Registries.ITEM, id("charms"));
        public static TagKey<Item> DARK_STONES = TagKey.create(Registries.ITEM, id("dark_stones"));
        public static TagKey<Item> PLATE_BASE = TagKey.create(Registries.ITEM, id("plate_base"));
        public static TagKey<Item> TOMES = TagKey.create(Registries.ITEM, id("tomes"));

    }
}