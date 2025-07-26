package com.satyrn.mdoadq.forge.data.provider.server;

import com.satyrn.mdoadq.Mdoadq;
import com.satyrn.mdoadq.data.loot.ModLootTables;
import com.satyrn.mdoadq.forge.loot.OverlayLootTableModifier;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import javax.annotation.Nullable;

public final class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(DataGenerator gen, String modid) {
        super(gen, modid);
    }

    @Override
    protected void start() {
        this.addOverlay(BuiltInLootTables.SIMPLE_DUNGEON, ModLootTables.MUSIC_DISCS);
        this.addOverlay(BuiltInLootTables.STRONGHOLD_CORRIDOR, ModLootTables.MUSIC_DISCS);
        this.addOverlay(BuiltInLootTables.ANCIENT_CITY, ModLootTables.MUSIC_DISCS);

        this.addOverlay("nova_structures", "chests/illager_hideout_heart_loot", ModLootTables.FLOWERS_THROWING_PAPER_AIRPLANES_DISCS);
        this.addOverlay("nova_structures", "chests/illager_hideout_lesser_tresure", ModLootTables.CAPTAINZEPHYRR_DISCS);
        this.addOverlay("nova_structures", "chests/stray_fort_tresure", ModLootTables.SATYRNIDAE_DISCS);
    }

    private void addOverlay(String namespace, String path, ResourceLocation overlay) {
        Mdoadq.info("Adding global loot modifier {}:{}/{}", Mdoadq.MOD_ID, namespace, path);
        final @Nullable ResourceLocation lootTable = ResourceLocation.tryBuild(namespace, path);
        if (lootTable == null) {
            throw new IllegalStateException("Failed to create key " + namespace + ":" + path);
        }
        this.add(namespace + "/" + path,
                new OverlayLootTableModifier(new LootItemCondition[]{LootTableIdCondition.builder(lootTable).build()},
                        UniformFloat.of(0.0F, 1.0F), 0.25F, overlay));
    }

    private void addOverlay(ResourceLocation lootTable, ResourceLocation overlay) {
        this.addOverlay(lootTable.getNamespace(), lootTable.getPath(), overlay);
    }

    @Override
    public String getName() {
        return "Music Discs of a Distinguished Quality Mod Global Loot Modifier Provider";
    }
}
