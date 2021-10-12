package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OldGildedRoseTest {

    Item[] createItems() {
        Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };

        return items;
    }

    /**
     * Comparaison entre l'ancienne application et la nouvelle pour s'assurer que rien n'est cassé pendant la
     * refactorisation.
     */
    @Test
     void compareOldAndNew() {

        // Ancienne application
        Item[] oldItems = createItems();
        OldGildedRose oldApp = new OldGildedRose(oldItems);

        // Nouvelle application
        Item[] newItems = createItems();
        GildedRose newApp = new GildedRose(newItems);

        int days = 16;

        for (int i = 0; i < days; i++) {

            System.out.println("--- " + i + "---");

            System.out.println("====AVANT====");
            for (int j = 0; j < newItems.length; j++) {

                System.out.println("[NEW] - " + j + " - " + newItems[j]);
                System.out.println("[OLD] - " + j + " - " + oldItems[j]);

                assertEquals(newItems[j].sellIn, oldItems[j].sellIn);
                assertEquals(newItems[j].quality, oldItems[j].quality);
            }

            newApp.updateQuality();
            oldApp.updateQuality();

            System.out.println("====APRES====");

            // Comparaison de chaque item entre ancienne et nouvelle gestion
            for (int j = 0; j < newItems.length; j++) {

                System.out.println("[NEW] - " + j + " - " + newItems[j]);
                System.out.println("[OLD] - " + j + " - " + oldItems[j]);

                assertEquals(newItems[j].sellIn, oldItems[j].sellIn);
                assertEquals(newItems[j].quality, oldItems[j].quality);
            }
        }

    }

}
