package net.darkhax.darkutilities.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.darkhax.darkutilities.utils.ILightningConductive;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightningBolt.class)
public abstract class MixinLightningBolt extends Entity {
    private MixinLightningBolt() {
        super(null, null);
    }

    /**
     * This patch allows blocks to respond to being struck by lightning. This also introduces a system for redirecting
     * lightning to adjacent blocks similarly to the vanilla lighting rod block.
     */
    @Inject(method = "powerLightningRod()V", at = @At("RETURN"))
    private void onStrikeBlock(CallbackInfo callback, @Local BlockPos strikePos, @Local BlockState strikeState) {
        // Checks if the block being struck reacts to lightning.
        if (strikeState.getBlock() instanceof ILightningConductive extended) {
            extended.onDirectLightningStrike(this.level(), strikePos, strikeState, (LightningBolt) (Object) this);
        }

        // Checks if the block redirects lightning to adjacent blocks. This is
        // a hardcoded behaviour of the lightning rod that we expose to other
        // blocks as well.
        if (canRedirect(this.level(), strikePos, strikeState)) {
            for (Direction direction : getRedirectionSides(this.level(), strikePos, strikeState)) {
                final BlockPos indirectPos = strikePos.relative(direction);
                final BlockState indirectState = this.level().getBlockState(indirectPos);

                if (indirectState.getBlock() instanceof ILightningConductive extended) {
                    extended.onIndirectLightingStrike(this.level(), strikePos, strikeState, indirectPos, indirectState, (LightningBolt) (Object) this);
                }
            }
        }
    }

    @Unique
    private static boolean canRedirect(Level world, BlockPos pos, BlockState state) {
        return state.is(Blocks.LIGHTNING_ROD) || (state.getBlock() instanceof ILightningConductive extended && extended.canRedirectLightning(world, pos, state));
    }

    @Unique
    private static Direction[] getRedirectionSides(Level world, BlockPos pos, BlockState state) {
        if (state.is(Blocks.LIGHTNING_ROD)) {
            return ILightningConductive.LIGHTNING_REDIRECTION_FACES;
        } else if (state.getBlock() instanceof ILightningConductive extended) {
            return extended.getLightningRedirectionFaces(world, pos, state);
        }

        return ILightningConductive.NO_REDIRECTION_FACES;
    }
}