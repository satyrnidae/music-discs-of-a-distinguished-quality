package com.satyrn.mdoadq.fabric;

import com.satyrn.mdoadq.Mdoadq;
import com.satyrn.mdoadq.api.LootTableModifierProcessor;
import com.satyrn.mdoadq.world.entity.npc.ModdedMusicDiscListing;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;

public final class MainEntrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Mdoadq.preRegistrationSetup();

        Mdoadq.info("Hooking loot tables");
        LootTableEvents.MODIFY.register(
                (resourceManager, lootManager, id, tableBuilder, source) -> LootTableModifierProcessor.modifyTables(
                        lootManager, id, tableBuilder));
        TradeOfferHelper.registerWanderingTraderOffers(1,
                itemListings -> itemListings.add(new ModdedMusicDiscListing()));
    }
}
