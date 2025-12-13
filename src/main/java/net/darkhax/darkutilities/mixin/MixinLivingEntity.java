package net.darkhax.darkutilities.mixin;

import net.darkhax.darkutilities.utils.DarkUtilsTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity extends Entity {
    @Shadow
    private int lastHurtByMobTimestamp;

    @Shadow
    protected int lastHurtByPlayerMemoryTime;

    @Shadow
    public abstract boolean isInvulnerableTo(ServerLevel serverLevel, DamageSource damageSource);

    /**
     * This patch allows mobs killed by Dark Utilities' fake player damage to drop EXP and player specific loot. Bookshelf's
     * fake player damage is not connected to a specific entity instance so the timers responsible for these checks are
     * not updated otherwise.
     */
    @Inject(method = "hurtServer", at = @At("HEAD"))
    private void updateFakePlayerDamageTimes(ServerLevel serverLevel, DamageSource source, float f, CallbackInfoReturnable<Boolean> cir) {
        if (!this.level().isClientSide() && !this.isInvulnerableTo(serverLevel, source) && source.is(DarkUtilsTags.DamageTypes.FAKE_PLAYER)) {
            this.lastHurtByPlayerMemoryTime = this.tickCount;
            this.lastHurtByMobTimestamp = this.tickCount;
        }
    }

    @SuppressWarnings("DataFlowIssue") // mixin ctor
    private MixinLivingEntity() {
        super(null, null);
    }
}