package com.gildedrose.model;

import com.gildedrose.Item;

public class InventoryItem {

    public static final String CONJURED = "Conjured";
    protected Item item;

    public static InventoryItem createInstance(Item item) {

        switch(item.name)
        {
            case Legendary.NAME:
                return new Legendary(item);
            case Cheese.NAME:
                return new Cheese(item);
            case BackstagePass.NAME:
                return new BackstagePass(item);
            case Conjuring.NAME:
                return new Conjuring(item);
            default:
                return new InventoryItem(item);
        }
    }

    protected InventoryItem(Item item) {
        this.item = item;
    }

    public void updateItem() {
        updateQuality();
        updateExpiry();

        if (isExpired()) {
            handleExpired();
        }
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void updateExpiry() {
        item.sellIn--;
    }

    protected void handleExpired() {
        decreaseQuality();
    }

    protected boolean isExpired() {
        return item.sellIn < 0;
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
