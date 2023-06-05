package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateInventory() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private  void updateItem(Item item) {
        updateQuality(item);
        updateExpiry(item);

        if (isExpired(item)) {
            handleExpired(item);
        }
    }
    private void updateQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality(item);

            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }

        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            }
        else {
            decreaseQuality(item);
        }
    }

    private void updateExpiry(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn--;
    }

    private void handleExpired(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        }
        else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        else {
            decreaseQuality(item);
        }

    }
    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }
    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
    private void decreaseQuality(Item item) {
        if  (item.quality > 0){
            item.quality--;
        }
    }
}
