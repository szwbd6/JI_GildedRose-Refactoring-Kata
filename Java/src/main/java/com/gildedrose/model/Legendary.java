package com.gildedrose.model;

import com.gildedrose.Item;

public class Legendary extends InventoryItem {
    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    public Legendary(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        //Do Nothing
    }

    @Override
    protected void updateExpiry() {
        //Do Nothing
    }
    @Override
    protected void handleExpired() {
        //Do Nothing
    }
}
