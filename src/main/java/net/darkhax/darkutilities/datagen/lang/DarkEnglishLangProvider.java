package net.darkhax.darkutilities.datagen.lang;

import net.darkhax.darkutilities.DarkUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.CompletableFuture;

@NullMarked
public class DarkEnglishLangProvider extends FabricLanguageProvider {
    public DarkEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder t) {

        // Creative Tab
        t.add(BuiltInRegistries.CREATIVE_MODE_TAB.getResourceKey(DarkUtils.getInstance().content.tab).orElseThrow(), "Dark Utilities");

        // Blocks
        t.add(DarkUtils.getInstance().content.blankPlate, "Blank Plate");
        t.add(DarkUtils.getInstance().content.vectorPlate, "Vector Plate");
        t.add(DarkUtils.getInstance().content.vectorPlateFast, "Fast Vector Plate");
        t.add(DarkUtils.getInstance().content.vectorPlateExtreme, "Extreme Vector Plate");
        t.add(DarkUtils.getInstance().content.vectorPlateUltra, "Ultra Vector Plate");
        t.add(DarkUtils.getInstance().content.damagePlate, "Damage Plate");
        t.add(DarkUtils.getInstance().content.maimPlate, "Maim Plate");
        t.add(DarkUtils.getInstance().content.playerDamagePlate, "Player Damage Plate");
        t.add(DarkUtils.getInstance().content.flamePlate, "Flame Plate");
        t.add(DarkUtils.getInstance().content.slownessPlate, "Slowness Plate");
        t.add(DarkUtils.getInstance().content.fatiguePlate, "Fatigue Plate");
        t.add(DarkUtils.getInstance().content.darknessPlate, "Darkness Plate");
        t.add(DarkUtils.getInstance().content.hungerPlate, "Hunger Plate");
        t.add(DarkUtils.getInstance().content.weaknessPlate, "Weakness Plate");
        t.add(DarkUtils.getInstance().content.poisonPlate, "Poison Plate");
        t.add(DarkUtils.getInstance().content.witherPlate, "Wither Plate");
        t.add(DarkUtils.getInstance().content.glowingPlate, "Alert Plate");
        t.add(DarkUtils.getInstance().content.levitationPlate, "Levitation Plate");
        t.add(DarkUtils.getInstance().content.misfortunePlate, "Misfortune Plate");
        t.add(DarkUtils.getInstance().content.slowfallPlate, "Slow Fall Plate");
        t.add(DarkUtils.getInstance().content.omenPlate, "Ominous Plate");
        t.add(DarkUtils.getInstance().content.smitePlate, "Smite Plate");
        t.add(DarkUtils.getInstance().content.banePlate, "Bane Plate");
        t.add(DarkUtils.getInstance().content.frostPlate, "Frost Plate");
        t.add(DarkUtils.getInstance().content.anchorPlate, "Anchor Plate");

        t.add(DarkUtils.getInstance().content.filterUndead, "Mob Filter (Undead)");
        t.add(DarkUtils.getInstance().content.filterAnimal, "Mob Filter (Animal)");
        t.add(DarkUtils.getInstance().content.filterArthropod, "Mob Filter (Arthropod)");
        t.add(DarkUtils.getInstance().content.filterPlayer, "Mob Filter (Player)");
        t.add(DarkUtils.getInstance().content.filterSlime, "Mob Filter (Slime)");
        t.add(DarkUtils.getInstance().content.filterHostile, "Mob Filter (Hostile)");
        t.add(DarkUtils.getInstance().content.filterVillager, "Mob Filter (Villager)");
        t.add(DarkUtils.getInstance().content.filterFireImmune, "Mob Filter (Fire Immune)");
        t.add(DarkUtils.getInstance().content.filterBaby, "Mob Filter (Child)");
        t.add(DarkUtils.getInstance().content.filterGolem, "Mob Filter (Golem)");
        t.add(DarkUtils.getInstance().content.filterPet, "Mob Filter (Pet)");
        t.add(DarkUtils.getInstance().content.filterWater, "Mob Filter (Water)");
        t.add(DarkUtils.getInstance().content.filterNamed, "Mob Filter (Named)");
        t.add(DarkUtils.getInstance().content.filterRaider, "Mob Filter (Raid)");
        t.add(DarkUtils.getInstance().content.filterIllager, "Mob Filter (Illager)");
        t.add(DarkUtils.getInstance().content.filterFreezeImmune, "Mob Filter (Freeze Immune)");
        t.add(DarkUtils.getInstance().content.filterEquipment, "Mob Filter (Equipment)");
        t.add(DarkUtils.getInstance().content.filterPassenger, "Mob Filter (Passenger)");

        t.add(DarkUtils.getInstance().content.redstoneRandomizer, "Redstone Randomizer");
        t.add(DarkUtils.getInstance().content.shieldedRedstone, "Shielded Redstone");

        // Items
        t.add(DarkUtils.getInstance().content.sleepCharm, "Sleep Charm");
        t.add(DarkUtils.getInstance().content.portalCharm, "Portal Charm");
        t.add(DarkUtils.getInstance().content.wardingCharm, "Warding Charm");

        t.add(DarkUtils.getInstance().content.enchantingTome, "Tome of Enchanting");
        t.add(DarkUtils.getInstance().content.shadowTome, "Tome of Shadows");

        // Tooltips
        // Plates
        t.add(tooltip(DarkUtils.getInstance().content.blankPlate), "A flat tile with no effects.");
        t.add(tooltip(DarkUtils.getInstance().content.vectorPlate), "Lightly pushes mobs around.");
        t.add(tooltip(DarkUtils.getInstance().content.vectorPlateFast), "Quickly pushes mobs around.");
        t.add(tooltip(DarkUtils.getInstance().content.vectorPlateExtreme), "Rapidly pushes mobs around.");
        t.add(tooltip(DarkUtils.getInstance().content.vectorPlateUltra), "Pushes mobs around at lightning speeds.");
        t.add(tooltip(DarkUtils.getInstance().content.damagePlate), "Hurts anything that walks on it.");
        t.add(tooltip(DarkUtils.getInstance().content.maimPlate), "Causes non-lethal damage to anything that walks on it.");
        t.add(tooltip(DarkUtils.getInstance().content.playerDamagePlate), "Causes player damage to anything that walks on it.");
        t.add(tooltip(DarkUtils.getInstance().content.flamePlate), "Burns entities that step on it.");
        t.add(tooltip(DarkUtils.getInstance().content.slownessPlate), "Slows entities that step on it.");
        t.add(tooltip(DarkUtils.getInstance().content.fatiguePlate), "Fatigues entities that step on it.");
        t.add(tooltip(DarkUtils.getInstance().content.darknessPlate), "Darkens vision of entities that step on it.");
        t.add(tooltip(DarkUtils.getInstance().content.hungerPlate), "Hungers entities that step on it.");
        t.add(tooltip(DarkUtils.getInstance().content.weaknessPlate), "Weakens entities that step on it.");
        t.add(tooltip(DarkUtils.getInstance().content.poisonPlate), "Poisons entities that step on it.");
        t.add(tooltip(DarkUtils.getInstance().content.witherPlate), "Withers entities that step on it.");
        t.add(tooltip(DarkUtils.getInstance().content.glowingPlate), "Entities that step on it will glow.");
        t.add(tooltip(DarkUtils.getInstance().content.levitationPlate), "Levitates entities that step on it.");
        t.add(tooltip(DarkUtils.getInstance().content.misfortunePlate), "Entities that step on it will have bad luck.");
        t.add(tooltip(DarkUtils.getInstance().content.slowfallPlate), "Entities that step on it will temporarily fall slowly.");
        t.add(tooltip(DarkUtils.getInstance().content.omenPlate), "A bad omen befalls entities that step on it.");
        t.add(tooltip(DarkUtils.getInstance().content.smitePlate), "Significantly damages undead mobs that step on it.");
        t.add(tooltip(DarkUtils.getInstance().content.banePlate), "Significantly damages arthropods that step on it.");
        t.add(tooltip(DarkUtils.getInstance().content.frostPlate), "Entities that step on it will start to freeze.");
        t.add(tooltip(DarkUtils.getInstance().content.anchorPlate), "Traps a mob and forces them to look in the specified direction.");

// Filters
        t.add(tooltip(DarkUtils.getInstance().content.filterPlayer), "A block only players can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterUndead), "A block only undead mobs can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterArthropod), "A block only arthropods can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterIllager), "A block only illagers can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterRaider), "A block only raid mobs can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterHostile), "A block only hostile mobs can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterAnimal), "A block only animals can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterBaby), "A block only children can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterPet), "A block only pets can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterSlime), "A block only slimes can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterVillager), "A block only villagers can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterFireImmune), "A block only fire immune mobs can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterGolem), "A block only golems can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterWater), "A block only aquatic mobs can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterNamed), "A block only named mobs can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterFreezeImmune), "A block only freeze immune mobs can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterEquipment), "A block only mobs with equipment can pass through.");
        t.add(tooltip(DarkUtils.getInstance().content.filterPassenger), "A block only mounts, vehicles, and their passengers can pass through.");

// Redstone
        t.add(tooltip(DarkUtils.getInstance().content.redstoneRandomizer), "Randomly outputs redstone signals.");
        t.add(tooltip(DarkUtils.getInstance().content.shieldedRedstone), "Emits a redstone signal in only one direction.");

// Items
        t.add(tooltip(DarkUtils.getInstance().content.enchantingTome), "Refreshes enchanting options by using some EXP.");
        t.add(tooltip(DarkUtils.getInstance().content.shadowTome), "Allows entities and certain blocks to be hidden from view.");
        t.add(tooltip(DarkUtils.getInstance().content.sleepCharm), "Wards off the effects of insomnia.");
        t.add(tooltip(DarkUtils.getInstance().content.portalCharm), "Allows the user to travel quickly through portals.");
        t.add(tooltip(DarkUtils.getInstance().content.wardingCharm), "Wards off negative status effects.");

        // Advancements
        t.add("advancements.darkutils.adventure.plate_ultra.title", "Faster than Lightning");
        t.add("advancements.darkutils.adventure.plate_ultra.description", "Obtain the mysterious Ultra Vector Plate.");
    }

    public String tooltip(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).orElseThrow().identifier().toLanguageKey("tooltip");
    }

    public String tooltip(Block item) {
        return BuiltInRegistries.BLOCK.getResourceKey(item).orElseThrow().identifier().toLanguageKey("tooltip");
    }
}
