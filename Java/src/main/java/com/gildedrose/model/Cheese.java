package com.gildedrose.model;

import com.gildedrose.Item;

public class Cheese extends InventoryItem {
    public static final String NAME = "Aged Brie";

    public Cheese(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
    }

    @Override
    protected void handleExpired() {
        increaseQuality();
    }
}
