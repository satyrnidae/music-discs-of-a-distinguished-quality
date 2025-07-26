package com.satyrn.mdoadq.api;

import com.google.common.collect.ImmutableList;
import com.satyrn.mdoadq.Mdoadq;
import com.satyrn.mdoadq.data.tags.ModItemTags;
import com.satyrn.mdoadq.util.NotInitializable;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

// TODO: This sucks, redo this.
public final class WanderingTradesHelper {
    private static @Nullable ImmutableList<VillagerTrades.ItemListing> ALL_MUSIC_DISC_TRADES;

    private WanderingTradesHelper() {
        NotInitializable.staticClass(WanderingTradesHelper.class);
    }

    public static ImmutableList<VillagerTrades.ItemListing> getAllMusicDiscTrades() {
        if (ALL_MUSIC_DISC_TRADES == null || ALL_MUSIC_DISC_TRADES.isEmpty()) {
            final List<VillagerTrades.ItemListing> itemListings = new ArrayList<>();
            itemListings.add((entity, randomSource) -> {
                final List<Holder<Item>> discs = ImmutableList.copyOf(
                        Registry.ITEM.getTagOrEmpty(ModItemTags.MUSIC_DISCS));
                final List<Holder<Item>> creeperDrops = ImmutableList.copyOf(
                        Registry.ITEM.getTagOrEmpty(ItemTags.CREEPER_DROP_MUSIC_DISCS));
                return new MerchantOffer(new ItemStack(Items.EMERALD, randomSource.nextInt(4, 16)),
                        new ItemStack(creeperDrops.get(randomSource.nextInt(creeperDrops.size()))),
                        new ItemStack(discs.get(randomSource.nextInt(discs.size()))), 1, 0, 0.05f);
            });
            ALL_MUSIC_DISC_TRADES = ImmutableList.copyOf(itemListings);
        }

        Mdoadq.info("Loaded " + ALL_MUSIC_DISC_TRADES.size() + " wandering trader trades.");

        return ALL_MUSIC_DISC_TRADES;
    }
}
