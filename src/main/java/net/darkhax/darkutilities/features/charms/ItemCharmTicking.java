package net.darkhax.darkutilities.features.charms;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

public class ItemCharmTicking extends ItemCharm {

    private final ITickEffect effect;

    public ItemCharmTicking(Properties properties, ITickEffect effect) {

        super(properties);
        this.effect = effect;
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel world, Entity user, @Nullable EquipmentSlot equipmentSlot) {
        super.inventoryTick(stack, world, user, equipmentSlot);
        this.effect.apply(stack, world, user, false /*TODO*/);
    }

    @FunctionalInterface
    public interface ITickEffect {

        void apply(ItemStack stack, Level world, Entity user, boolean selected);
    }
}
