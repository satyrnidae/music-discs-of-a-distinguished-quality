package com.satyrn.mdoadq.forge.data.provider.client;

import com.satyrn.mdoadq.Mdoadq;
import com.satyrn.mdoadq.sounds.ModSoundEvents;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public final class ModSoundDefinitionsProvider extends SoundDefinitionsProvider {
    public ModSoundDefinitionsProvider(DataGenerator generator, String modId, ExistingFileHelper helper) {
        super(generator, modId, helper);
    }

    @Override
    public void registerSounds() {
        this.addRecord(ModSoundEvents.MUSIC_DISC_AVIDIT_E);
        this.addRecord(ModSoundEvents.MUSIC_DISC_DROWN);
        this.addRecord(ModSoundEvents.MUSIC_DISC_DUMA);
        this.addRecord(ModSoundEvents.MUSIC_DISC_LOCKER);
        this.addRecord(ModSoundEvents.MUSIC_DISC_LOST);
        this.addRecord(ModSoundEvents.MUSIC_DISC_MINIMALIST);
        this.addRecord(ModSoundEvents.MUSIC_DISC_NEMATODE);
        this.addRecord(ModSoundEvents.MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD);
        this.addRecord(ModSoundEvents.MUSIC_DISC_OUTSKIRTS);
        this.addRecord(ModSoundEvents.MUSIC_DISC_PET_THE_DOG);
        this.addRecord(ModSoundEvents.MUSIC_DISC_PIES_E);
        this.addRecord(ModSoundEvents.MUSIC_DISC_RIGMAROLE);
        this.addRecord(ModSoundEvents.MUSIC_DISC_SLITHER);
        this.addRecord(ModSoundEvents.MUSIC_DISC_WANDERER);
        this.addRecord(ModSoundEvents.MUSIC_DISC_AEON);
        this.addRecord(ModSoundEvents.MUSIC_DISC_NIGHTTIME_TRANSIT);
        this.addRecord(ModSoundEvents.MUSIC_DISC_SPARKPLUGS);
        this.addRecord(ModSoundEvents.MUSIC_DISC_REBOOT);
    }

    private void addRecord(Supplier<SoundEvent> soundEvent) {
        final String name = soundEvent.get().getLocation().getPath();
        Mdoadq.info("Adding music disc sound event for sound file {}:records/{}", Mdoadq.MOD_ID, name);
        final @Nullable ResourceLocation resourceLocation = ResourceLocation.tryBuild(Mdoadq.MOD_ID, "records/" + name);
        if (resourceLocation == null) {
            throw new IllegalStateException("Failed to create an id for " + Mdoadq.MOD_ID + ":records/" + name);
        }
        this.add(soundEvent.get(), SoundDefinition.definition().with(SoundDefinition.Sound.sound(resourceLocation, SoundDefinition.SoundType.SOUND).stream()));
    }

    @Override
    public String getName() {
        return "Music Discs of a Distinguished Quality Mod Sound Definitions Provider";
    }
}
