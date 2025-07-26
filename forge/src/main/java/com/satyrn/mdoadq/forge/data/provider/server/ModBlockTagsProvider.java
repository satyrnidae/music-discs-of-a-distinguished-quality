package com.satyrn.mdoadq.forge.data.provider.server;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public final class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator arg, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(arg, modId, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Music Discs of a Distinguished Quality Mod Block Tags Provider";
    }

    @Override
    protected void addTags() {
        // Do nothing
    }
}
