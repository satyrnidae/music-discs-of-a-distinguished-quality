package com.satyrn.mdoadq.data.loot;

import com.satyrn.mdoadq.Mdoadq;
import com.satyrn.mdoadq.util.NotInitializable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

import javax.annotation.Nullable;

public final class ModLootTables {
    public static final ResourceLocation ANCIENT_CITY_MODIFIER = getLootModifier(BuiltInLootTables.ANCIENT_CITY);
    public static final ResourceLocation SIMPLE_DUNGEON_MODIFIER = getLootModifier(BuiltInLootTables.SIMPLE_DUNGEON);
    public static final ResourceLocation STRONGHOLD_CORRIDOR_MODIFIER = getLootModifier(BuiltInLootTables.STRONGHOLD_CORRIDOR);
    public static final ResourceLocation MUSIC_DISCS = registerOverlay("music_discs");
    public static final ResourceLocation CAPTAINZEPHYRR_DISCS = registerOverlay("captainzephyrr_discs");
    public static final ResourceLocation ELABORATIONS_DISCS = registerOverlay("elaborations_discs");
    public static final ResourceLocation ACORNMAN_AND_MISCELLANY_DISCS = registerOverlay("acornman_and_miscellany_discs");
    public static final ResourceLocation ELABORATIONS_II_DISCS = registerOverlay("elaborations_ii_discs");
    public static final ResourceLocation FAILROAD_DISCS = registerOverlay("failroad_discs");
    public static final ResourceLocation FLOWERS_THROWING_PAPER_AIRPLANES_DISCS = registerOverlay("flowers_throwing_paper_airplanes_discs");
    public static final ResourceLocation ALKALI_DISCS = registerOverlay("alkali_discs");
    public static final ResourceLocation SATYRNIDAE_DISCS = registerOverlay("satyrnidae_discs");
    public static final ResourceLocation SKETCHES_DISCS = registerOverlay("sketches_discs");
    public static final ResourceLocation KORG_FILES_DISCS = registerOverlay("korg_files_discs");
    public static final ResourceLocation MOBIQUUM_DISCS = registerOverlay("mobiquum_discs");

    private ModLootTables() {
        NotInitializable.staticClass(ModLootTables.class);
    }

    public static ResourceLocation getLootModifier(ResourceLocation modifiedLootTable) {
        return register("modifier/" + modifiedLootTable.getNamespace() + '/' + modifiedLootTable.getPath());
    }

    public static ResourceLocation getLootModifier(String namespace, String path) {
        return register("modifier/" + namespace + '/' + path);
    }

    static ResourceLocation registerOverlay(String key) {
        return register("overlay/" + key);
    }

    static ResourceLocation register(String key) {
        Mdoadq.info("Registering resource location {}:{}", Mdoadq.MOD_ID, key);
        final @Nullable ResourceLocation resourceLocation = ResourceLocation.tryBuild(Mdoadq.MOD_ID, key);
        if (resourceLocation == null) {
            throw new IllegalStateException("Failed to create an id for " + Mdoadq.MOD_ID + ":" + key);
        }
        return resourceLocation;
    }
}
