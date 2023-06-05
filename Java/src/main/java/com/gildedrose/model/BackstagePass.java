package com.gildedrose.model;

import com.gildedrose.Item;

public class BackstagePass extends InventoryItem {
    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePass(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();

        if (item.sellIn < 11) {
            increaseQuality();
        }

        if (item.sellIn < 6) {
            increaseQuality();
        }
    }

    @Override
    protected void handleExpired() {
        item.quality = 0;
    }
}
