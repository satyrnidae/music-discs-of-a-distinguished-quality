package com.satyrn.mdoadq.forge.data.provider.server;

import com.satyrn.mdoadq.data.tags.ModItemTags;
import com.satyrn.mdoadq.world.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public final class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator arg,
                               BlockTagsProvider arg2,
                               String modId,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(arg, arg2, modId, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Music Discs of a Distinguished Quality Mod Item Tags Provider";
    }

    @Override
    protected void addTags() {
        this.tag(ModItemTags.MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_AVIDIT_E.get(), ModItems.MUSIC_DISC_DROWN.get(),
                        ModItems.MUSIC_DISC_DUMA.get(), ModItems.MUSIC_DISC_LOCKER.get(),
                        ModItems.MUSIC_DISC_LOST.get(), ModItems.MUSIC_DISC_MINIMALIST.get(),
                        ModItems.MUSIC_DISC_NEMATODE.get(), ModItems.MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD.get(),
                        ModItems.MUSIC_DISC_OUTSKIRTS.get(), ModItems.MUSIC_DISC_PET_THE_DOG.get(),
                        ModItems.MUSIC_DISC_PIES_E.get(), ModItems.MUSIC_DISC_RIGMAROLE.get(),
                        ModItems.MUSIC_DISC_SLITHER.get(), ModItems.MUSIC_DISC_WANDERER.get(),
                        ModItems.MUSIC_DISC_AEON.get(), ModItems.MUSIC_DISC_REBOOT.get(),
                        ModItems.MUSIC_DISC_NIGHTTIME_TRANSIT.get());
        this.tag(ModItemTags.CAPTAINZEPHYRR_DISCS)
                .add(ModItems.MUSIC_DISC_DROWN.get(), ModItems.MUSIC_DISC_NEMATODE.get(),
                        ModItems.MUSIC_DISC_DUMA.get(), ModItems.MUSIC_DISC_AVIDIT_E.get(),
                        ModItems.MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD.get(), ModItems.MUSIC_DISC_RIGMAROLE.get(),
                        ModItems.MUSIC_DISC_AEON.get(), ModItems.MUSIC_DISC_SPARKPLUGS.get(),
                        ModItems.MUSIC_DISC_NIGHTTIME_TRANSIT.get());
        this.tag(ModItemTags.ACORNMAN_AND_MISCELLANY_DISCS)
                .add(ModItems.MUSIC_DISC_DROWN.get(), ModItems.MUSIC_DISC_NEMATODE.get(),
                        ModItems.MUSIC_DISC_AEON.get());
        this.tag(ModItemTags.ALKALI_DISCS).add(ModItems.MUSIC_DISC_DUMA.get());
        this.tag(ModItemTags.ELABORATIONS_DISCS).add(ModItems.MUSIC_DISC_AVIDIT_E.get());
        this.tag(ModItemTags.ELABORATIONS_II_DISCS).add(ModItems.MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD.get());
        this.tag(ModItemTags.FLOWERS_THROWING_PAPER_AIRPLANES_DISCS).add(ModItems.MUSIC_DISC_RIGMAROLE.get());
        this.tag(ModItemTags.SATYRNIDAE_DISCS)
                .add(ModItems.MUSIC_DISC_PIES_E.get(), ModItems.MUSIC_DISC_SLITHER.get(),
                        ModItems.MUSIC_DISC_OUTSKIRTS.get(), ModItems.MUSIC_DISC_MINIMALIST.get(),
                        ModItems.MUSIC_DISC_WANDERER.get(), ModItems.MUSIC_DISC_LOST.get(),
                        ModItems.MUSIC_DISC_PET_THE_DOG.get(), ModItems.MUSIC_DISC_LOCKER.get(),
                        ModItems.MUSIC_DISC_REBOOT.get());
        this.tag(ModItemTags.MOBIQUUM_DISCS)
                .add(ModItems.MUSIC_DISC_PIES_E.get(), ModItems.MUSIC_DISC_REBOOT.get(),
                        ModItems.MUSIC_DISC_SLITHER.get(), ModItems.MUSIC_DISC_OUTSKIRTS.get());
        this.tag(ModItemTags.SKETCHES_DISCS)
                .add(ModItems.MUSIC_DISC_MINIMALIST.get(), ModItems.MUSIC_DISC_WANDERER.get());
        this.tag(ModItemTags.KORG_FILES_DISCS)
                .add(ModItems.MUSIC_DISC_LOST.get(), ModItems.MUSIC_DISC_PET_THE_DOG.get(),
                        ModItems.MUSIC_DISC_LOCKER.get());
        this.tag(ModItemTags.FAILROAD_DISCS)
                .add(ModItems.MUSIC_DISC_SPARKPLUGS.get(), ModItems.MUSIC_DISC_NIGHTTIME_TRANSIT.get());
    }
}
