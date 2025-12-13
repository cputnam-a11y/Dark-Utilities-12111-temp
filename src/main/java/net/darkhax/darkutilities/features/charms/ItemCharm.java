package net.darkhax.darkutilities.features.charms;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ItemCharm extends Item {
    // While charms have no valid enchantments yet, I am considering the possibility of adding some in the future.
    public static final Supplier<Properties> PROPERTIES = () -> new Properties().stacksTo(1).enchantable(8);

    public ItemCharm(Properties properties) {
        super(properties);
    }
}