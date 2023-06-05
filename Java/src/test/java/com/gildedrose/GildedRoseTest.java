package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

	@Test
	void normalItemQualityAndSellInChangeEachDayTest() {
		int startingSellIn = 10;
		int startingQuality = 20;
		final Item item = new Item("+5 Dexterity Vest", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(startingSellIn - 1, item.sellIn);
		assertEquals(startingQuality - 1, item.quality);
	}

	@Test
	void normalItemQualityPastSellInDateTest() {
		int startingSellIn = -1;
		int startingQuality = 20;
		final Item item = new Item("+5 Dexterity Vest", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(startingSellIn - 1, item.sellIn);
		assertEquals(startingQuality - 2, item.quality);

	}

	@Test
	void normalItemQualitySellInDateZeroTest() {
		int startingSellIn = 0;
		int startingQuality = 20;
		final Item item = new Item("+5 Dexterity Vest", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(startingSellIn - 1, item.sellIn);
		assertEquals(startingQuality - 2, item.quality);

	}

	@Test
	void itemQualityReducedToZeroTest() {
		Item item = new Item("+5 Dexterity Vest", 4, 1);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(0, item.quality);
	}

	@Test
	void itemQualityNotNegativeTest() {
		Item item = new Item("+5 Dexterity Vest", 4, 0);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(0, item.quality);
	}

	@Test
	void agedBrieItemQualityAndSellInChangeEachDayTest() {
		int startingSellIn = 2;
		int startingQuality = 0;
		Item item = new Item("Aged Brie", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(startingSellIn - 1, item.sellIn);
		assertEquals(startingQuality + 1, item.quality);
	}

	@Test
	void agedBrieItemNotOver50Test() {
		Item item = new Item("Aged Brie", 5, 50);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(50, item.quality);
	}

	@Test
	void agedBrieItemQualityPastSellInDateTest() {
		int startingSellIn = -1;
		int startingQuality = 20;
		Item item = new Item("Aged Brie", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(startingSellIn - 1, item.sellIn);
		assertEquals(startingQuality + 2, item.quality);
	}

	@Test
	void aged_item_quality_50_past_sellIn_date_does_not_increase() {
		int startingSellIn = 0;
		int startingQuality = 50;
		Item item = new Item("Aged Brie", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(startingSellIn - 1, item.sellIn);
		assertEquals(startingQuality, item.quality);
	}

	@Test
	void legendaryItemNeverSoldTest() {
		Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(0, item.sellIn);
	}

	@Test
	void legendaryItemNeverDecreaseInTest() {
		Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(80, item.quality);
	}

	@Test
	void backStagePassedItemQualityAndSellInChangeEachDayTest() {
		int startingSellIn = 15;
		int startingQuality = 20;
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(startingSellIn - 1, item.sellIn);
		assertEquals(startingQuality + 1, item.quality);
	}

	@Test
	void backStagePassedItemQualityAndSellInChange11DaysTest() {
		int startingSellIn = 11;
		int startingQuality = 20;
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(startingSellIn - 1, item.sellIn);
		assertEquals(startingQuality + 1, item.quality);
	}

	@Test
	void backStagePassedItemQualityAndSellInChange10DaysOrLessTest() {
		int startingSellIn = 10;
		int startingQuality = 20;
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(startingSellIn - 1, item.sellIn);
		assertEquals(startingQuality + 2, item.quality);
	}

	@Test
	void backStagePassedItemQualityAndSellInChange6DaysTest() {
		int startingSellIn = 6;
		int startingQuality = 20;
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(startingSellIn - 1, item.sellIn);
		assertEquals(startingQuality + 2, item.quality);
	}

	@Test
	void backStagePassedItemQualityAndSellInChange5DaysOrLessTest() {
		int startingSellIn = 5;
		int startingQuality = 20;
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(startingSellIn - 1, item.sellIn);
		assertEquals(startingQuality + 3, item.quality);
	}

	@Test
	void backStagePassedItemQualityTopValueWhenSellIn5DaysOrLessTest() {
		int startingSellIn = 5;
		int startingQuality = 48;
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(50, item.quality);
	}

	@Test
	void backStagePassedItemQualityValuePastConcertTest() {
		int startingSellIn = 0;
		int startingQuality = 48;
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(0, item.quality);
	}

	@Test
	void backStagePassedItemMaxQualityWhenSellIn10DaysOrLessTest() {
		int startingSellIn = 10;
		int startingQuality = 50;
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", startingSellIn, startingQuality);
		GildedRose app = new GildedRose(new Item[] { item });

		app.updateQuality();

		assertEquals(startingSellIn - 1, item.sellIn);
		assertEquals(startingQuality, item.quality);
	}

	@Test
	void multipleNormalItemQualityPastSellInDateTest() {
		Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20), new Item("Elixir of the Mongoose", -1, 7), };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(9, items[0].sellIn);
		assertEquals(19, items[0].quality);
		assertEquals(-2, items[1].sellIn);
		assertEquals(5, items[1].quality);
	}
}
