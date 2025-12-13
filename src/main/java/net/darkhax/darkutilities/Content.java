package net.darkhax.darkutilities;

import net.darkhax.darkutilities.features.charms.CharmEffects;
import net.darkhax.darkutilities.features.charms.ItemCharm;
import net.darkhax.darkutilities.features.charms.ItemCharmTicking;
import net.darkhax.darkutilities.features.filters.BlockEntityFilter;
import net.darkhax.darkutilities.features.filters.Filters;
import net.darkhax.darkutilities.features.flatblocks.BlockFlatTile;
import net.darkhax.darkutilities.features.flatblocks.BlockFlatTileRotatable;
import net.darkhax.darkutilities.features.flatblocks.BlockFlatTileRotatableLightningUpgrade;
import net.darkhax.darkutilities.features.flatblocks.FlatTileEffects;
import net.darkhax.darkutilities.features.redstone.BlockRedstoneRandomizer;
import net.darkhax.darkutilities.features.redstone.BlockShieldedRedstone;
import net.darkhax.darkutilities.features.tomes.ItemTome;
import net.darkhax.darkutilities.features.tomes.TomeEffects;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.villager.VillagerTrades;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static net.darkhax.darkutilities.Constants.id;

public class Content {

    protected final Map<Item, Component> tooltipCache = new HashMap<>();
    public final ArrayList<Item> items = new ArrayList<>();
    public final CreativeModeTab tab = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Constants.MOD_ID, "darkutils"),
            FabricItemGroup.builder()
                    .icon(this::getCreativeTabIcon)
                    .displayItems((params, output) -> items.forEach(
                            item -> output.accept(item.getDefaultInstance())
                    ))
                    .title(Component.translatable("itemGroup.darkutils.creative_tab"))
                    .build()
    );
    public final Block blankPlate = this.createFlatBlock(null, "blank_plate");
    public final Block vectorPlate = this.createFlatBlockRotatable(FlatTileEffects.PUSH_WEAK, "vector_plate");
    public final Block vectorPlateFast = this.createFlatBlockRotatable(FlatTileEffects.PUSH_NORMAL, "vector_plate_fast");
    public final Block vectorPlateExtreme = this.registerBlock(properties -> new BlockFlatTileRotatableLightningUpgrade(properties, FlatTileEffects.PUSH_STRONG, this::getVectorPlateUltra), BlockFlatTile.BLOCK_PROPERTIES.get(), "vector_plate_extreme");
    public final Block vectorPlateUltra = this.createFlatBlockRotatable(FlatTileEffects.PUSH_ULTRA, "vector_plate_ultra");
    public final Block damagePlate = this.createFlatBlock(FlatTileEffects.DAMAGE_GENERIC, "damage_plate");
    public final Block playerDamagePlate = this.createFlatBlock(FlatTileEffects.DAMAGE_PLAYER, "damage_plate_player");
    public final Block flamePlate = this.createFlatBlock(FlatTileEffects.FLAME, "flame_plate");
    public final Block slownessPlate = this.createFlatBlock(FlatTileEffects.SLOWNESS, "slowness_plate");
    public final Block fatiguePlate = this.createFlatBlock(FlatTileEffects.FATIGUE, "fatigue_plate");
    public final Block darknessPlate = this.createFlatBlock(FlatTileEffects.DARKNESS, "darkness_plate");
    public final Block hungerPlate = this.createFlatBlock(FlatTileEffects.HUNGER, "hunger_plate");
    public final Block weaknessPlate = this.createFlatBlock(FlatTileEffects.WEAKNESS, "weakness_plate");
    public final Block poisonPlate = this.createFlatBlock(FlatTileEffects.POISON, "poison_plate");
    public final Block witherPlate = this.createFlatBlock(FlatTileEffects.WITHER, "wither_plate");
    public final Block glowingPlate = this.createFlatBlock(FlatTileEffects.GLOWING, "alert_plate");
    public final Block levitationPlate = this.createFlatBlock(FlatTileEffects.LEVITATION, "levitation_plate");
    public final Block misfortunePlate = this.createFlatBlock(FlatTileEffects.UNLUCK, "misfortune_plate");
    public final Block slowfallPlate = this.createFlatBlock(FlatTileEffects.SLOWFALL, "slowfall_plate");
    public final Block omenPlate = this.createFlatBlock(FlatTileEffects.OMEN, "omen_plate");
    public final Block frostPlate = this.createFlatBlock(FlatTileEffects.FROST, "frost_plate");
    public final Block maimPlate = this.createFlatBlock(FlatTileEffects.DAMAGE_MAIM, "damage_plate_maim");
    public final Block smitePlate = this.createFlatBlock(FlatTileEffects.SMITE, "smite_plate");
    public final Block banePlate = this.createFlatBlock(FlatTileEffects.BANE, "bane_plate");
    public final Block anchorPlate = this.createFlatBlockRotatable(FlatTileEffects.ANCHOR, "anchor_plate");
    public final Block filterPlayer = this.createFilter(Filters.PLAYER, "filter_player");
    public final Block filterUndead = this.createFilter(Filters.UNDEAD, "filter_undead");
    public final Block filterArthropod = this.createFilter(Filters.ARTHROPOD, "filter_arthropod");
    public final Block filterIllager = this.createFilter(Filters.ILLAGER, "filter_illager");
    public final Block filterRaider = this.createFilter(Filters.RAIDER, "filter_raider");
    public final Block filterHostile = this.createFilter(Filters.HOSTILE, "filter_hostile");
    public final Block filterAnimal = this.createFilter(Filters.ANIMAL, "filter_animal");
    public final Block filterBaby = this.createFilter(Filters.BABY, "filter_child");
    public final Block filterPet = this.createFilter(Filters.PET, "filter_pet");
    public final Block filterSlime = this.createFilter(Filters.SLIME, "filter_slime");
    public final Block filterVillager = this.createFilter(Filters.VILLAGER, "filter_villager");
    public final Block filterFireImmune = this.createFilter(Filters.FIRE_IMMUNE, "filter_fire_immune");
    public final Block filterGolem = this.createFilter(Filters.GOLEM, "filter_golem");
    public final Block filterWater = this.createFilter(Filters.WATER, "filter_water");
    public final Block filterNamed = this.createFilter(Filters.NAMED, "filter_named");
    public final Block filterFreezeImmune = this.createFilter(Filters.FREEZE_IMMUNE, "filter_freeze_immune");
    public final Block filterEquipment = this.createFilter(Filters.EQUIPMENT, "filter_equipment");
    public final Block filterPassenger = this.createFilter(Filters.PASSENGER, "filter_passenger");
    public final Block redstoneRandomizer = this.registerBlock(BlockRedstoneRandomizer::new, BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(3.5f).randomTicks(), "redstone_randomizer");
    public final Block shieldedRedstone = this.registerBlock(BlockShieldedRedstone::new, BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).strength(3.5f), "shielded_redstone");

    public final Item portalCharm = this.registerItem(ItemCharm::new, ItemCharm.PROPERTIES.get(), "charm_portal");
    public final Item sleepCharm = this.registerItem(properties -> new ItemCharmTicking(properties, CharmEffects::sleepCharmTick), ItemCharm.PROPERTIES.get(), "charm_sleep");
    public final Item wardingCharm = this.registerItem(properties -> new ItemCharmTicking(properties, CharmEffects::wardingCharmTick), ItemCharm.PROPERTIES.get(), "charm_warding");
    public final Item enchantingTome = this.registerItem(properties -> new ItemTome(TomeEffects.RESET_ENCHANTMENT_SEED, null, null, properties), ItemTome.PROPERTIES.get(), "tome_enchanting");
    public final Item shadowTome = this.registerItem(
            properties -> new ItemTome(null, TomeEffects.HIDE_ENTITY, TomeEffects.HIDE_BLOCK, properties),
            new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON),
            "tome_shadows"
    );

    public Content() {
        TradeOfferHelper.registerWanderingTraderOffers(builder -> builder.addAll(
                id("trades"),
                new VillagerTrades.ItemsForEmeralds(this.portalCharm, 8, 1, 1),
                new VillagerTrades.ItemsForEmeralds(this.sleepCharm, 8, 1, 1),
                new VillagerTrades.ItemsForEmeralds(this.vectorPlateUltra, 4, 8, 1, 1),
                new VillagerTrades.ItemsForEmeralds(this.playerDamagePlate.asItem(), 16, 1, 1),
                new VillagerTrades.ItemsForEmeralds(this.enchantingTome, 16, 1, 1),
                new VillagerTrades.ItemsForEmeralds(this.shadowTome, 16, 1, 1)
        ));
    }

    private void createTooltips(Identifier id, Item item) {
        this.tooltipCache.put(item, Component.translatable(id.toLanguageKey("tooltip")).withStyle(ChatFormatting.DARK_GRAY));
    }

    private Block getVectorPlateUltra() {
        return this.vectorPlateUltra;
    }

    private ItemStack getCreativeTabIcon() {

        return new ItemStack(this.vectorPlate);
    }

    private BlockFlatTile createFlatBlock(BlockFlatTile.@Nullable CollisionEffect effect, String id) {
        return registerBlock(properties -> new BlockFlatTile(properties, effect), BlockFlatTile.BLOCK_PROPERTIES.get(), id);
    }

    private Block createFlatBlockRotatable(BlockFlatTile.@Nullable CollisionEffect effect, String id) {
        return registerBlock(properties -> new BlockFlatTileRotatable(properties, effect), BlockFlatTileRotatable.BLOCK_PROPERTIES.get(), id);
    }

    private BlockEntityFilter createFilter(Predicate<Entity> effect, String id) {
        return registerBlock(properties -> new BlockEntityFilter(effect, properties), BlockEntityFilter.BLOCK_PROPERTIES.get(), id);
    }

    private <T extends Item> T registerItem(Function<Item.Properties, T> factory, Item.Properties properties, String id) {
        var itemKey = ResourceKey.create(Registries.ITEM, id(id));
        var item = Registry.register(BuiltInRegistries.ITEM, itemKey, factory.apply(properties.setId(itemKey)));
        this.createTooltips(itemKey.identifier(), item);
        this.items.add(item);
        return item;

    }

    private <T extends Block> T registerBlock(Function<BlockBehaviour.Properties, T> factory, BlockBehaviour.Properties properties, String id) {
        var key = ResourceKey.create(Registries.BLOCK, id(id));
        var block = Registry.register(BuiltInRegistries.BLOCK, key, factory.apply(properties.setId(key)));
        this.createTooltips(key.identifier(), registerItem(properties1 -> new BlockItem(block, properties1), new Item.Properties().useBlockDescriptionPrefix(), id));
        return block;
    }
}