package com.satyrn.mdoadq.world.item;

import com.satyrn.mdoadq.Mdoadq;
import com.satyrn.mdoadq.sounds.ModSoundEvents;
import com.satyrn.mdoadq.util.NotInitializable;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public final class ModItems {
    public static final RegistrySupplier<Item> MUSIC_DISC_AEON;
    public static final RegistrySupplier<Item> MUSIC_DISC_AVIDIT_E;
    public static final RegistrySupplier<Item> MUSIC_DISC_DROWN;
    public static final RegistrySupplier<Item> MUSIC_DISC_DUMA;
    public static final RegistrySupplier<Item> MUSIC_DISC_LOCKER;
    public static final RegistrySupplier<Item> MUSIC_DISC_LOST;
    public static final RegistrySupplier<Item> MUSIC_DISC_MINIMALIST;
    public static final RegistrySupplier<Item> MUSIC_DISC_NEMATODE;
    public static final RegistrySupplier<Item> MUSIC_DISC_NIGHTTIME_TRANSIT;
    public static final RegistrySupplier<Item> MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD;
    public static final RegistrySupplier<Item> MUSIC_DISC_OUTSKIRTS;
    public static final RegistrySupplier<Item> MUSIC_DISC_PET_THE_DOG;
    public static final RegistrySupplier<Item> MUSIC_DISC_PIES_E;
    public static final RegistrySupplier<Item> MUSIC_DISC_REBOOT;
    public static final RegistrySupplier<Item> MUSIC_DISC_RIGMAROLE;
    public static final RegistrySupplier<Item> MUSIC_DISC_SLITHER;
    public static final RegistrySupplier<Item> MUSIC_DISC_SPARKPLUGS;
    public static final RegistrySupplier<Item> MUSIC_DISC_WANDERER;
    static final DeferredRegister<Item> REGISTRAR = DeferredRegister.create(Mdoadq.MOD_ID, Registry.ITEM_REGISTRY);

    static {
        int output = 0;
        // Acornman and Miscellany - CaptainZephyrr
        MUSIC_DISC_DROWN = register("music_disc_drown", ++output, ModSoundEvents.MUSIC_DISC_DROWN, 44);
        MUSIC_DISC_NEMATODE = register("music_disc_nematode", ++output, ModSoundEvents.MUSIC_DISC_NEMATODE, 193);
        MUSIC_DISC_AEON = register("music_disc_aeon", ++output, ModSoundEvents.MUSIC_DISC_AEON, 214);
        // Alkali - CaptainZephyrr
        output = 0;
        MUSIC_DISC_DUMA = register("music_disc_duma", ++output, ModSoundEvents.MUSIC_DISC_DUMA, 220);
        // Elaborations - CaptainZephyrr
        output = 0;
        MUSIC_DISC_AVIDIT_E = register("music_disc_avidit_e", ++output, ModSoundEvents.MUSIC_DISC_AVIDIT_E, 324);
        // Elaborations II - CaptainZephyrr
        output = 0;
        MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD = register("music_disc_old_white_straight_road", ++output, ModSoundEvents.MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD, 291);
        // Failroad
        output = 0;
        MUSIC_DISC_SPARKPLUGS = register("music_disc_sparkplugs", ++output, ModSoundEvents.MUSIC_DISC_SPARKPLUGS, 137);
        MUSIC_DISC_NIGHTTIME_TRANSIT = register("music_disc_nighttime_transit", ++output, ModSoundEvents.MUSIC_DISC_NIGHTTIME_TRANSIT, 103);
        // Flowers Throwing Paper Airplanes - Captainzephyrr
        output = 0;
        MUSIC_DISC_RIGMAROLE = register("music_disc_rigmarole", ++output, ModSoundEvents.MUSIC_DISC_RIGMAROLE, 310);
        // Mobiquum (TSA Version) - CenturionFox
        output = 0;
        MUSIC_DISC_PIES_E = register("music_disc_pies_e", ++output, ModSoundEvents.MUSIC_DISC_PIES_E, 179);
        MUSIC_DISC_REBOOT = register("music_disc_reboot", ++output, ModSoundEvents.MUSIC_DISC_REBOOT, 132);
        MUSIC_DISC_SLITHER = register("music_disc_slither", ++output, ModSoundEvents.MUSIC_DISC_SLITHER, 222);
        MUSIC_DISC_OUTSKIRTS = register("music_disc_outskirts", ++output, ModSoundEvents.MUSIC_DISC_OUTSKIRTS, 196);
        // Sketches (Round 2) - CenturionFox
        output = 0;
        MUSIC_DISC_MINIMALIST = register("music_disc_minimalist", ++output, ModSoundEvents.MUSIC_DISC_MINIMALIST, 226);
        MUSIC_DISC_WANDERER = register("music_disc_wanderer", ++output, ModSoundEvents.MUSIC_DISC_WANDERER, 345);
        // The Korg Files - satyrnidae
        output = 0;
        MUSIC_DISC_LOST = register("music_disc_lost", ++output, ModSoundEvents.MUSIC_DISC_LOST, 86);
        MUSIC_DISC_PET_THE_DOG = register("music_disc_pet_the_dog", ++output, ModSoundEvents.MUSIC_DISC_PET_THE_DOG, 177);
        MUSIC_DISC_LOCKER = register("music_disc_locker", ++output, ModSoundEvents.MUSIC_DISC_LOCKER, 139);
    }

    private ModItems() {
        NotInitializable.staticClass(ModItems.class);
    }

    static RegistrySupplier<Item> register(final String key, final int output, final Supplier<SoundEvent> soundEvent, final int lengthInSeconds) {
        final int outputClamp = output % 15;
        Mdoadq.info("Registering music disc {}:{} (output: {}, length {}:{})", Mdoadq.MOD_ID, key, outputClamp,
                lengthInSeconds / 60, lengthInSeconds % 60);
        final @Nullable ResourceLocation resourceLocation = ResourceLocation.tryBuild(Mdoadq.MOD_ID, key);
        if (resourceLocation == null) {
            throw new IllegalStateException("Failed to create an id for " + Mdoadq.MOD_ID + ":" + key);
        }
        return REGISTRAR.register(key, () -> new RecordItem(outputClamp, soundEvent.get(),
                new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC).rarity(Rarity.RARE), lengthInSeconds));
    }

    public static void register() {
        REGISTRAR.register();
    }
}
