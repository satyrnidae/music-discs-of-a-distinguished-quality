package com.satyrn.mdoadq.forge;

import com.satyrn.mdoadq.forge.event.ForgeEvents;
import com.satyrn.mdoadq.forge.loot.ModLootModifiers;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.satyrn.mdoadq.Mdoadq;

@Mod(Mdoadq.MOD_ID)
public final class ForgeMod {
    public ForgeMod(final FMLJavaModLoadingContext context) {
        final IEventBus modEventBus = context.getModEventBus();

        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(Mdoadq.MOD_ID, modEventBus);

        // Run our common setup.
        Mdoadq.preRegistrationSetup();

        ModLootModifiers.register(modEventBus);
    }
}
