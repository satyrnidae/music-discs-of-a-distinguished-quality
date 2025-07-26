package com.satyrn.mdoadq.forge.data.provider.client;

import com.satyrn.mdoadq.world.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public final class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.basicItem(ModItems.MUSIC_DISC_AVIDIT_E.get());
        this.basicItem(ModItems.MUSIC_DISC_DROWN.get());
        this.basicItem(ModItems.MUSIC_DISC_DUMA.get());
        this.basicItem(ModItems.MUSIC_DISC_LOCKER.get());
        this.basicItem(ModItems.MUSIC_DISC_LOST.get());
        this.basicItem(ModItems.MUSIC_DISC_MINIMALIST.get());
        this.basicItem(ModItems.MUSIC_DISC_NEMATODE.get());
        this.basicItem(ModItems.MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD.get());
        this.basicItem(ModItems.MUSIC_DISC_OUTSKIRTS.get());
        this.basicItem(ModItems.MUSIC_DISC_PET_THE_DOG.get());
        this.basicItem(ModItems.MUSIC_DISC_PIES_E.get());
        this.basicItem(ModItems.MUSIC_DISC_RIGMAROLE.get());
        this.basicItem(ModItems.MUSIC_DISC_SLITHER.get());
        this.basicItem(ModItems.MUSIC_DISC_WANDERER.get());
        this.basicItem(ModItems.MUSIC_DISC_AEON.get());
        this.basicItem(ModItems.MUSIC_DISC_NIGHTTIME_TRANSIT.get());
        this.basicItem(ModItems.MUSIC_DISC_SPARKPLUGS.get());
        this.basicItem(ModItems.MUSIC_DISC_REBOOT.get());
    }

    @Override
    public @NotNull String getName() {
        return "Music Discs of a Distinguished Quality Mod Item Model Provider";
    }
}
