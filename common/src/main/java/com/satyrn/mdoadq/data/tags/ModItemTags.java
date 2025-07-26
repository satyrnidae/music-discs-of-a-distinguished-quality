package com.satyrn.mdoadq.data.tags;

import com.satyrn.mdoadq.Mdoadq;
import com.satyrn.mdoadq.util.NotInitializable;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import javax.annotation.Nullable;

public final class ModItemTags {
    public static final TagKey<Item> MUSIC_DISCS;
    public static final TagKey<Item> CAPTAINZEPHYRR_DISCS;
    public static final TagKey<Item> ELABORATIONS_DISCS;
    public static final TagKey<Item> ACORNMAN_AND_MISCELLANY_DISCS;
    public static final TagKey<Item> ELABORATIONS_II_DISCS;
    public static final TagKey<Item> FLOWERS_THROWING_PAPER_AIRPLANES_DISCS;
    public static final TagKey<Item> ALKALI_DISCS;
    public static final TagKey<Item> SATYRNIDAE_DISCS;
    public static final TagKey<Item> SKETCHES_DISCS;
    public static final TagKey<Item> KORG_FILES_DISCS;
    public static final TagKey<Item> MOBIQUUM_DISCS;
    public static final TagKey<Item> FAILROAD_DISCS;

    static {
        MUSIC_DISCS = register("music_discs");
        CAPTAINZEPHYRR_DISCS = register("captainzephyrr_discs");
        ELABORATIONS_DISCS = register("elaborations_discs");
        ACORNMAN_AND_MISCELLANY_DISCS = register("acornman_and_miscellany_discs");
        ELABORATIONS_II_DISCS = register("elaborations_ii_discs");
        FLOWERS_THROWING_PAPER_AIRPLANES_DISCS = register("flowers_throwing_paper_airplanes_discs");
        ALKALI_DISCS = register("alkali_discs");
        SATYRNIDAE_DISCS = register("satyrnidae_discs");
        SKETCHES_DISCS = register("sketches_discs");
        KORG_FILES_DISCS = register("korg_files_discs");
        MOBIQUUM_DISCS = register("mobiquum_discs");
        FAILROAD_DISCS = register("failroad_discs");
    }

    private ModItemTags() {
        NotInitializable.staticClass(ModItemTags.class);
    }

    public static TagKey<Item> register(String key) {
        final @Nullable ResourceLocation resourceLocation = ResourceLocation.tryBuild(Mdoadq.MOD_ID, key);
        if (resourceLocation == null) {
            throw new IllegalStateException("Failed to create an item tag key for " + Mdoadq.MOD_ID + ":" + key);
        }
        return TagKey.create(Registry.ITEM_REGISTRY, resourceLocation);
    }
}
