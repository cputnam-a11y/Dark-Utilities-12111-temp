package net.darkhax.darkutilities.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.darkhax.darkutilities.DarkUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PortalProcessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Portal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PortalProcessor.class)
public abstract class MixinPortalProcessor {
    @Shadow
    public abstract boolean isInsidePortalThisTick();

    @WrapOperation(
            method = "processPortalTeleportation",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Portal;getPortalTransitionTime(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/Entity;)I")
    )
    private int handlePortalCharmSkipWait(Portal instance, ServerLevel serverLevel, Entity entity, Operation<Integer> original) {
        int ret = original.call(instance, serverLevel, entity);
        if (this.isInsidePortalThisTick() && entity instanceof Player && DarkUtils.hasItem(entity, () -> DarkUtils.getInstance().content.portalCharm)) {
            ret = 1;
        }
        return ret;
    }
}
