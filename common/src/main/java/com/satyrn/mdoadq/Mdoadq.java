package com.satyrn.mdoadq;

import com.satyrn.mdoadq.sounds.ModSoundEvents;
import com.satyrn.mdoadq.world.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Mdoadq {
    public static final String MOD_ID = "mdoadq";
    private static final Logger LOGGER = LogManager.getLogger();

    private Mdoadq() {
        throw new AssertionError("Mdoadq should not be initialized.");
    }

    public static void preRegistrationSetup() {
        info("Running pre-registry setup for {}", MOD_ID);
        // Write common init code here.
        ModSoundEvents.register();
        ModItems.register();

        info("Pre-registry setup for {} completed successfully.", MOD_ID);
    }

    public static void info(String message, Object... params) {
        LOGGER.info(message, params);
    }
}
