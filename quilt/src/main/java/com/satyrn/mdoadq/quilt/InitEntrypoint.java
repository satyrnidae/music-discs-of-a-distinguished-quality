package com.satyrn.mdoadq.quilt;

import com.satyrn.mdoadq.api.WanderingTradesHelper;
import com.satyrn.mdoadq.api.LootTableModifierProcessor;
import dev.architectury.event.events.common.LifecycleEvent;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.world.entity.npc.VillagerTrades;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import com.satyrn.mdoadq.Mdoadq;
import org.quiltmc.qsl.villager.api.TradeOfferHelper;

import java.util.List;

public final class InitEntrypoint implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        // Run our common setup.
        Mdoadq.preRegistrationSetup();

        Mdoadq.info("Hooking into loot tables");

        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            LootTableModifierProcessor.modifyTables(lootManager, id, tableBuilder);
        }));

        LifecycleEvent.SERVER_STARTED.register(
                server -> TradeOfferHelper.registerWanderingTraderOffers(1, itemListings -> {
                    final List<VillagerTrades.ItemListing> musicDiscTrades = WanderingTradesHelper.getAllMusicDiscTrades();
                    itemListings.addAll(musicDiscTrades);
                }));
    }
}
