package net.darkhax.darkutilities;

import net.minecraft.util.Unit;

public class MixinSupport {
    public static final ThreadLocal<Unit> FORCE_BLOCK_ATLAS = ThreadLocal.withInitial(() -> null);
}
