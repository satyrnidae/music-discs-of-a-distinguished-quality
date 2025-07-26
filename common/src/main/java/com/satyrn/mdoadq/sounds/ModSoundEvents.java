package com.satyrn.mdoadq.sounds;

import com.satyrn.mdoadq.Mdoadq;
import com.satyrn.mdoadq.util.NotInitializable;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;

public final class ModSoundEvents {
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_AEON;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_AVIDIT_E;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_DROWN;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_DUMA;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_LOCKER;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_LOST;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_MINIMALIST;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_NEMATODE;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_NIGHTTIME_TRANSIT;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_OUTSKIRTS;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_PET_THE_DOG;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_PIES_E;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_REBOOT;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_RIGMAROLE;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_SLITHER;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_SPARKPLUGS;
    public static final RegistrySupplier<SoundEvent> MUSIC_DISC_WANDERER;
    static final DeferredRegister<SoundEvent> REGISTRAR = DeferredRegister.create(Mdoadq.MOD_ID,
            Registry.SOUND_EVENT_REGISTRY);

    static {
        MUSIC_DISC_AVIDIT_E = register("music_disc_avidit_e");
        MUSIC_DISC_DROWN = register("music_disc_drown");
        MUSIC_DISC_DUMA = register("music_disc_duma");
        MUSIC_DISC_LOCKER = register("music_disc_locker");
        MUSIC_DISC_LOST = register("music_disc_lost");
        MUSIC_DISC_MINIMALIST = register("music_disc_minimalist");
        MUSIC_DISC_NEMATODE = register("music_disc_nematode");
        MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD = register("music_disc_old_white_straight_road");
        MUSIC_DISC_OUTSKIRTS = register("music_disc_outskirts");
        MUSIC_DISC_PET_THE_DOG = register("music_disc_pet_the_dog");
        MUSIC_DISC_PIES_E = register("music_disc_pies_e");
        MUSIC_DISC_RIGMAROLE = register("music_disc_rigmarole");
        MUSIC_DISC_SLITHER = register("music_disc_slither");
        MUSIC_DISC_WANDERER = register("music_disc_wanderer");
        MUSIC_DISC_AEON = register("music_disc_aeon");
        MUSIC_DISC_NIGHTTIME_TRANSIT = register("music_disc_nighttime_transit");
        MUSIC_DISC_SPARKPLUGS = register("music_disc_sparkplugs");
        MUSIC_DISC_REBOOT = register("music_disc_reboot");
    }

    private ModSoundEvents() {
        NotInitializable.staticClass(ModSoundEvents.class);
    }

    static RegistrySupplier<SoundEvent> register(String key) {
        Mdoadq.info("Registering sound event {}:{}", Mdoadq.MOD_ID, key);
        final @Nullable ResourceLocation resourceLocation = ResourceLocation.tryBuild(Mdoadq.MOD_ID, key);
        if (resourceLocation == null) {
            throw new IllegalStateException("Failed to create an id for " + Mdoadq.MOD_ID + ":" + key);
        }
        return REGISTRAR.register(key, () -> new SoundEvent(resourceLocation));
    }

    public static void register() {
        REGISTRAR.register();
    }
}
