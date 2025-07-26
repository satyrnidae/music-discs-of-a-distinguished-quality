package com.satyrn.mdoadq.forge.loot;

import com.mojang.serialization.Codec;
import com.satyrn.mdoadq.Mdoadq;
import com.satyrn.mdoadq.util.NotInitializable;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModLootModifiers {

    public static final RegistryObject<Codec<OverlayLootTableModifier>> DISC_DUNGEON_LOOT_MODIFIER;
    static final DeferredRegister<Codec<? extends IGlobalLootModifier>> REGISTRAR = DeferredRegister.create(
            ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Mdoadq.MOD_ID);

    static {
        DISC_DUNGEON_LOOT_MODIFIER = REGISTRAR.register("overlay_loot_table", OverlayLootTableModifier.CODEC);;
    }

    private ModLootModifiers() {
        NotInitializable.staticClass(ModLootModifiers.class);
    }

    public static void register(IEventBus eventBus) {
        REGISTRAR.register(eventBus);
    }
}
