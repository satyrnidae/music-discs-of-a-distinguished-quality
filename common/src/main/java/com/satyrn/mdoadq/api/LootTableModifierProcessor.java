package com.satyrn.mdoadq.api;

import com.satyrn.mdoadq.Mdoadq;
import com.satyrn.mdoadq.data.loot.ModLootTables;
import com.satyrn.mdoadq.util.NotInitializable;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public final class LootTableModifierProcessor {
    private LootTableModifierProcessor() {
        NotInitializable.staticClass(LootTableModifierProcessor.class);
    }

    public static void modifyTables(LootTables lootManager, ResourceLocation id, LootTable.Builder tableBuilder) {
        if (id.getPath().equals(Mdoadq.MOD_ID)) {
            Mdoadq.info("Skipping modifier check for our own loot table {}");
            return;
        }

        final ResourceLocation dynamicModifierTable = ModLootTables.getLootModifier(id);

        if (lootManager.get(dynamicModifierTable) != LootTable.EMPTY) {
            Mdoadq.info("Modifying loot table {} with modifier table {}...", id, dynamicModifierTable);
            final LootPool.Builder modifierPool = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0F))
                    .setBonusRolls(ConstantValue.exactly(0.1F))
                    .add(LootTableReference.lootTableReference(dynamicModifierTable));
            tableBuilder.withPool(modifierPool);
        } else {
            Mdoadq.info("Skipped unmodified loot table {} ({} not found)", id, dynamicModifierTable);
        }
    }
}
