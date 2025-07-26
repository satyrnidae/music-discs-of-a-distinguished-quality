package com.satyrn.mdoadq.forge.data;

import com.satyrn.mdoadq.Mdoadq;
import com.satyrn.mdoadq.forge.data.provider.client.ModItemModelProvider;
import com.satyrn.mdoadq.forge.data.provider.client.ModUSEnglishLanguageProvider;
import com.satyrn.mdoadq.forge.data.provider.client.ModSoundDefinitionsProvider;
import com.satyrn.mdoadq.forge.data.provider.server.ModBlockTagsProvider;
import com.satyrn.mdoadq.forge.data.provider.server.ModGlobalLootModifierProvider;
import com.satyrn.mdoadq.forge.data.provider.server.ModItemTagsProvider;
import com.satyrn.mdoadq.forge.data.provider.server.ModLootTableProvider;
import com.satyrn.mdoadq.util.NotInitializable;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Mdoadq.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataEvents {
    private DataEvents() {
        NotInitializable.staticClass(DataEvents.class);
    }

    @SubscribeEvent
    static void onGatherData(final GatherDataEvent event) {
        // TODO: Generators
        final DataGenerator generator = event.getGenerator();
        final String modId = event.getModContainer().getModId();
        final ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeClient()) {
            generator.addProvider(true, new ModItemModelProvider(generator, modId, existingFileHelper));
            generator.addProvider(true, new ModUSEnglishLanguageProvider(generator, modId));
            generator.addProvider(true, new ModSoundDefinitionsProvider(generator, modId, existingFileHelper));
        }

        if (event.includeServer()) {
            final ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(generator, modId, existingFileHelper);
            generator.addProvider(true, blockTagsProvider);
            generator.addProvider(true, new ModItemTagsProvider(generator, blockTagsProvider, modId, existingFileHelper));
            generator.addProvider(true, new ModGlobalLootModifierProvider(generator, modId));
            generator.addProvider(true, new ModLootTableProvider(generator));
        }
    }
}
