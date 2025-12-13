package net.darkhax.darkutilities;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DarkUtils {
    public static final List<BiFunction<Player, Predicate<ItemStack>, Boolean>> charmResolvers = new ArrayList<>();

    private static DarkUtils instance;

    public final Content content;

    public DarkUtils() {
        this.content = new Content();

        // Test vanilla player inventory for charm items.
        charmResolvers.add(DarkUtils::hasItemInVanillaInventory);
    }

    public static DarkUtils getInstance() {
        if (instance == null) {
            instance = new DarkUtils();
        }

        return instance;
    }

    public void addDescriptionTooltips(ItemStack stack, Item.TooltipContext context, TooltipFlag flag, List<Component> tooltip) {
        final Component description = this.content.tooltipCache.get(stack.getItem());

        if (description != null) {
            tooltip.add(description);
        }
    }

    public static boolean hasItem(Entity entity, Supplier<Item> item) {
        if (entity instanceof Player player) {
            return charmResolvers.stream().anyMatch(func -> func.apply(player, s -> s.is(item.get())));
        }

        return false;
    }

    private static boolean hasItemInVanillaInventory(Player player, Predicate<ItemStack> predicate) {
        for (final ItemStack stack : player.getInventory()) {
            if (predicate.test(stack)) {
                return true;
            }
        }

        for (final EquipmentSlot slotType : EquipmentSlot.values()) {
            if (predicate.test(player.getItemBySlot(slotType))) {
                return true;
            }
        }

        return false;
    }
}