package com.satyrn.mdoadq.forge.data.provider.client;

import com.satyrn.mdoadq.world.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public final class ModUSEnglishLanguageProvider extends LanguageProvider {
    public ModUSEnglishLanguageProvider(DataGenerator gen, String modid) {
        super(gen, modid, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addRecord(ModItems.MUSIC_DISC_AVIDIT_E);
        this.addRecord(ModItems.MUSIC_DISC_DROWN);
        this.addRecord(ModItems.MUSIC_DISC_DUMA);
        this.addRecord(ModItems.MUSIC_DISC_LOCKER);
        this.addRecord(ModItems.MUSIC_DISC_LOST);
        this.addRecord(ModItems.MUSIC_DISC_MINIMALIST);
        this.addRecord(ModItems.MUSIC_DISC_NEMATODE);
        this.addRecord(ModItems.MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD);
        this.addRecord(ModItems.MUSIC_DISC_OUTSKIRTS);
        this.addRecord(ModItems.MUSIC_DISC_PET_THE_DOG);
        this.addRecord(ModItems.MUSIC_DISC_PIES_E);
        this.addRecord(ModItems.MUSIC_DISC_RIGMAROLE);
        this.addRecord(ModItems.MUSIC_DISC_SLITHER);
        this.addRecord(ModItems.MUSIC_DISC_WANDERER);
        this.addRecord(ModItems.MUSIC_DISC_AEON);
        this.addRecord(ModItems.MUSIC_DISC_SPARKPLUGS);
        this.addRecord(ModItems.MUSIC_DISC_NIGHTTIME_TRANSIT);
        this.addRecord(ModItems.MUSIC_DISC_REBOOT);

        this.addRecordDescription(ModItems.MUSIC_DISC_AVIDIT_E, "CaptainZephyrr - AviditE");
        this.addRecordDescription(ModItems.MUSIC_DISC_DROWN, "CaptainZephyrr - Drown");
        this.addRecordDescription(ModItems.MUSIC_DISC_DUMA, "CaptainZephyrr - дума");
        this.addRecordDescription(ModItems.MUSIC_DISC_LOCKER, "Satyrnidae - Locker");
        this.addRecordDescription(ModItems.MUSIC_DISC_LOST, "Satyrnidae - Lost");
        this.addRecordDescription(ModItems.MUSIC_DISC_MINIMALIST, "Satyrnidae - Minimalist");
        this.addRecordDescription(ModItems.MUSIC_DISC_NEMATODE, "CaptainZephyrr - Nematode");
        this.addRecordDescription(ModItems.MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD, "CaptainZephyrr - Old White Straight Road");
        this.addRecordDescription(ModItems.MUSIC_DISC_OUTSKIRTS, "Satyrnidae - Outskirts");
        this.addRecordDescription(ModItems.MUSIC_DISC_PET_THE_DOG, "Satyrnidae - Pet the Dog");
        this.addRecordDescription(ModItems.MUSIC_DISC_PIES_E, "Satyrnidae - Pies-E");
        this.addRecordDescription(ModItems.MUSIC_DISC_RIGMAROLE, "CaptainZephyrr - Rigmarole");
        this.addRecordDescription(ModItems.MUSIC_DISC_SLITHER, "Satyrnidae - Slither");
        this.addRecordDescription(ModItems.MUSIC_DISC_WANDERER, "Satyrnidae - Wanderer");
        this.addRecordDescription(ModItems.MUSIC_DISC_AEON, "CaptainZephyrr - Aeon");
        this.addRecordDescription(ModItems.MUSIC_DISC_SPARKPLUGS, "CaptainZephyrr - Sparkplugs");
        this.addRecordDescription(ModItems.MUSIC_DISC_NIGHTTIME_TRANSIT, "CaptainZephyrr - Nighttime Transit");
        this.addRecordDescription(ModItems.MUSIC_DISC_REBOOT, "Satyrnidae - Reboot");
    }

    private void addRecord(Supplier<Item> item) {
        this.add(item.get(), "Music Disc");
    }

    private void addRecordDescription(Supplier<Item> item, String name) {
        this.add(item.get().getDescriptionId() + ".desc", name);
    }

    @Override
    public String getName() {
        return "Music Discs of a Distinguished Quality Mod Language Provider";
    }
}
