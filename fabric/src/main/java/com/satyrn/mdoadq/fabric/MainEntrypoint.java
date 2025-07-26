package com.satyrn.mdoadq.fabric;

import com.satyrn.mdoadq.api.LootTableModifierProcessor;
import com.satyrn.mdoadq.api.WanderingTradesHelper;
import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.init.fabric.ArchitecturyServer;
import net.fabricmc.api.ModInitializer;

import com.satyrn.mdoadq.Mdoadq;
import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.core.RegistryAccess;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.npc.VillagerTrades;

import java.util.List;

public final class MainEntrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Mdoadq.preRegistrationSetup();

        Mdoadq.info("Hooking loot tables");
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            LootTableModifierProcessor.modifyTables(lootManager, id, tableBuilder);
        }));

        // TODO: We shouldn't need SERVER_STARTED for this.
        LifecycleEvent.SERVER_STARTED.register(server ->
            TradeOfferHelper.registerWanderingTraderOffers(1, itemListings -> {
                final List<VillagerTrades.ItemListing> musicDiscTrades = WanderingTradesHelper.getAllMusicDiscTrades();
                itemListings.addAll(musicDiscTrades);
        }));
    }
}
