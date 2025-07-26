package com.satyrn.mdoadq.forge.event;

import com.satyrn.mdoadq.Mdoadq;
import com.satyrn.mdoadq.api.WanderingTradesHelper;
import com.satyrn.mdoadq.util.NotInitializable;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Mdoadq.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEvents {
    private ForgeEvents() {
        NotInitializable.staticClass(ForgeEvents.class);
    }

    @SubscribeEvent
    static void addTraderTrades(WandererTradesEvent event) {
        event.getRareTrades().addAll(WanderingTradesHelper.getAllMusicDiscTrades());
    }
}
