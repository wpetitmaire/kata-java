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
}
