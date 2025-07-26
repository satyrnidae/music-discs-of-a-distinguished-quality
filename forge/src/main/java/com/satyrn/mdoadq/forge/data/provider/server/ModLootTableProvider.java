package com.satyrn.mdoadq.forge.data.provider.server;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.satyrn.mdoadq.data.loot.ModLootTables;
import com.satyrn.mdoadq.world.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class ModLootTableProvider extends LootTableProvider {
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> subProviders;

    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
        this.subProviders = ImmutableList.of(Pair.of(ChestLootModifiers::new, LootContextParamSets.CHEST));
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return this.subProviders;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
        // Do nothing ;x
    }

    @Override
    public String getName() {
        return "Music Discs of a Distinguished Quality Mod Loot Table Provider";
    }

    static final class ChestLootModifiers implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> fxy) {
            fxy.accept(ModLootTables.MUSIC_DISCS, LootTable.lootTable()
                    .withPool(poolOf(List.of(ModItems.MUSIC_DISC_AVIDIT_E, ModItems.MUSIC_DISC_DROWN,
                            ModItems.MUSIC_DISC_DUMA, ModItems.MUSIC_DISC_LOCKER, ModItems.MUSIC_DISC_LOST,
                            ModItems.MUSIC_DISC_MINIMALIST, ModItems.MUSIC_DISC_NEMATODE,
                            ModItems.MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD, ModItems.MUSIC_DISC_OUTSKIRTS,
                            ModItems.MUSIC_DISC_PET_THE_DOG, ModItems.MUSIC_DISC_PIES_E, ModItems.MUSIC_DISC_RIGMAROLE,
                            ModItems.MUSIC_DISC_SLITHER, ModItems.MUSIC_DISC_WANDERER))));
            fxy.accept(ModLootTables.CAPTAINZEPHYRR_DISCS, LootTable.lootTable()
                    .withPool(poolOf(List.of(ModItems.MUSIC_DISC_DROWN, ModItems.MUSIC_DISC_NEMATODE,
                            ModItems.MUSIC_DISC_DUMA, ModItems.MUSIC_DISC_AVIDIT_E,
                            ModItems.MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD, ModItems.MUSIC_DISC_RIGMAROLE))));
            fxy.accept(ModLootTables.ELABORATIONS_DISCS,
                    LootTable.lootTable().withPool(poolOf(List.of(ModItems.MUSIC_DISC_AVIDIT_E))));
            fxy.accept(ModLootTables.ACORNMAN_AND_MISCELLANY_DISCS, LootTable.lootTable()
                    .withPool(poolOf(List.of(ModItems.MUSIC_DISC_DROWN, ModItems.MUSIC_DISC_NEMATODE,
                            ModItems.MUSIC_DISC_AEON))));
            fxy.accept(ModLootTables.ELABORATIONS_II_DISCS,
                    LootTable.lootTable().withPool(poolOf(List.of(ModItems.MUSIC_DISC_OLD_WHITE_STRAIGHT_ROAD))));
            fxy.accept(ModLootTables.FLOWERS_THROWING_PAPER_AIRPLANES_DISCS,
                    LootTable.lootTable().withPool(poolOf(List.of(ModItems.MUSIC_DISC_RIGMAROLE))));
            fxy.accept(ModLootTables.ALKALI_DISCS,
                    LootTable.lootTable().withPool(poolOf(List.of(ModItems.MUSIC_DISC_DUMA))));
            fxy.accept(ModLootTables.SATYRNIDAE_DISCS, LootTable.lootTable()
                    .withPool(poolOf(List.of(ModItems.MUSIC_DISC_PIES_E, ModItems.MUSIC_DISC_REBOOT,
                            ModItems.MUSIC_DISC_SLITHER, ModItems.MUSIC_DISC_OUTSKIRTS, ModItems.MUSIC_DISC_MINIMALIST,
                            ModItems.MUSIC_DISC_WANDERER, ModItems.MUSIC_DISC_LOST, ModItems.MUSIC_DISC_PET_THE_DOG,
                            ModItems.MUSIC_DISC_LOCKER))));
            fxy.accept(ModLootTables.SKETCHES_DISCS, LootTable.lootTable()
                    .withPool(poolOf(List.of(ModItems.MUSIC_DISC_MINIMALIST, ModItems.MUSIC_DISC_WANDERER))));
            fxy.accept(ModLootTables.KORG_FILES_DISCS, LootTable.lootTable()
                    .withPool(poolOf(List.of(ModItems.MUSIC_DISC_LOST, ModItems.MUSIC_DISC_PET_THE_DOG,
                            ModItems.MUSIC_DISC_LOCKER))));
            fxy.accept(ModLootTables.MOBIQUUM_DISCS, LootTable.lootTable()
                    .withPool(poolOf(List.of(ModItems.MUSIC_DISC_PIES_E, ModItems.MUSIC_DISC_REBOOT,
                            ModItems.MUSIC_DISC_SLITHER, ModItems.MUSIC_DISC_OUTSKIRTS))));
            fxy.accept(ModLootTables.FAILROAD_DISCS, LootTable.lootTable()
                    .withPool(poolOf(List.of(ModItems.MUSIC_DISC_SPARKPLUGS, ModItems.MUSIC_DISC_NIGHTTIME_TRANSIT))));

            final LootTable.Builder musicDiscsModifierTable = getModifierTable(ModLootTables.MUSIC_DISCS);
            final LootTable.Builder captainZephyrrDiscsModifierTable = getModifierTable(
                    ModLootTables.CAPTAINZEPHYRR_DISCS);
            final LootTable.Builder satyrnidaeDiscsModifierTable = getModifierTable(ModLootTables.SATYRNIDAE_DISCS);
            final LootTable.Builder flowersThrowingPaperAirplanesDiscsModifierTable = getModifierTable(
                    ModLootTables.FLOWERS_THROWING_PAPER_AIRPLANES_DISCS);

            fxy.accept(ModLootTables.ANCIENT_CITY_MODIFIER, musicDiscsModifierTable);
            fxy.accept(ModLootTables.SIMPLE_DUNGEON_MODIFIER, musicDiscsModifierTable);
            fxy.accept(ModLootTables.STRONGHOLD_CORRIDOR_MODIFIER, musicDiscsModifierTable);

            fxy.accept(ModLootTables.getLootModifier("nova_structures", "chests/illager_hideout_heart_loot"),
                    flowersThrowingPaperAirplanesDiscsModifierTable);
            fxy.accept(ModLootTables.getLootModifier("nova_structures", "chests/illager_hideout_lesser_tresure"),
                    captainZephyrrDiscsModifierTable);
            fxy.accept(ModLootTables.getLootModifier("nova_structures", "chests/stray_fort_tresure"),
                    satyrnidaeDiscsModifierTable);
        }

        private LootTable.Builder getModifierTable(ResourceLocation lootTable) {
            return LootTable.lootTable()
                    .withPool(LootPool.lootPool()
                            .setBonusRolls(ConstantValue.exactly(0.25F))
                            .setRolls(UniformGenerator.between(0.0F, 1.0F))
                            .add(LootTableReference.lootTableReference(lootTable)));
        }

        private LootPool.Builder poolOf(final List<Supplier<Item>> items) {
            final LootPool.Builder lootPool = LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F));

            for(final Supplier<Item> item : items) {
                lootPool.add(LootItem.lootTableItem(item.get()).setWeight(1));
            }

            return lootPool;
        }
    }
}
