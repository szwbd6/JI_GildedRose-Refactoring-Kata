package com.gildedrose;

import com.gildedrose.model.InventoryItem;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        for (Item item : items) {
            InventoryItem.createInstance(item).updateItem();
        }
    }
}
