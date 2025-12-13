package net.darkhax.darkutilities;

import net.fabricmc.api.ModInitializer;

public class DarkUtilsEntry implements ModInitializer {

    @Override
    public void onInitialize() {
        DarkUtils.getInstance();
    }
}
