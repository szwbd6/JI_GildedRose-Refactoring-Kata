package com.gildedrose.model;

import com.gildedrose.Item;

public class Conjuring extends InventoryItem {
    public static final String NAME = "Conjuring";

    public Conjuring(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        decreaseQuality();
        decreaseQuality();
    }

    @Override
    protected void handleExpired() {
        decreaseQuality();
        decreaseQuality();
    }
}
