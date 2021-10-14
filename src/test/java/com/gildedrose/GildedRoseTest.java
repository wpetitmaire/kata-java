package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }

    @Test
    void getTypeArticle() {

        Item[] items = new Item[] {
            new Item("TEST", 0, 0),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80)
        };

        GildedRose app = new GildedRose(items);

        TypeArticle typeArticle = app.GetTypeArticle(items[0].name);
        assertEquals(TypeArticle.DEFAULT, typeArticle);

        typeArticle = app.GetTypeArticle(items[1].name);
        assertEquals(TypeArticle.SULFURAS, typeArticle);
    }

    @Test
    void updateDefaultArticleQuality() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20)
        };

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 16; i++) {
            app.updateQuality();
        }

        assertEquals(-6, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void updateAgedBrieArticleQuality() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 2, 0)
        };

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 16; i++) {
            app.updateQuality();
        }

        assertEquals(-14, items[0].sellIn);
        assertEquals(30, items[0].quality);
    }

    @Test
    void updateBackstagePassesQuality() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)
        };

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 16; i++) {
            app.updateQuality();
        }

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void updateSulfurasArticleQuality() {
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 0, 80)
        };

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < 16; i++) {
            app.updateQuality();
        }

        assertEquals(0, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

}
