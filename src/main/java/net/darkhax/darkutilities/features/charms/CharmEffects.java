package net.darkhax.darkutilities.features.charms;

import net.darkhax.darkutilities.mixin.AccessorMobEffectInstance;
import net.darkhax.darkutilities.mixin.AccessorPlayer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NullMarked;

@NullMarked
public class CharmEffects {
    public static void wardingCharmTick(ItemStack stack, Level world, Entity user, boolean selected) {
        if (user instanceof LivingEntity living && !living.getActiveEffects().isEmpty()) {
            final CompoundTag effectTag = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getCompound("effect").orElse(null);
            final float chance = effectTag != null && effectTag.contains("chance")
                                 ? effectTag.getFloat("chance").orElseThrow()
                                 : 1f;

            for (MobEffectInstance effect : living.getActiveEffects()) {
                if (!effect.isAmbient() && effect.getEffect().value().getCategory() == MobEffectCategory.HARMFUL && !effect.getEffect().value().isInstantenous() && Math.random() < chance && effect instanceof AccessorMobEffectInstance accessor) {
                    accessor.darkUtilities$tickDownDuration();
                }
            }
        }
    }

    public static void sleepCharmTick(ItemStack stack, Level world, Entity user, boolean selected) {
        if (user instanceof Player player) {
            if (player.isSleeping() && player instanceof AccessorPlayer accessor && player.getSleepTimer() < 90) {
                // Allow the player to skip the bed timer and instantly go to sleep.
                accessor.darkutils$setSleepTimer(90);
            }

            if (player instanceof ServerPlayer splayer) {
                // Phantoms and other mods use this stat to handle negative insomnia effects. Setting it to 0 ensures the player is always considered well rested.
                splayer.getStats().setValue(player, Stats.CUSTOM.get(Stats.TIME_SINCE_REST), 0);
            }
        }
    }
}
