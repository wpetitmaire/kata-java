package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.items.Sulfuras;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    TypeArticle GetTypeArticle(String name) {

        return Arrays.stream(TypeArticle.values())
            .filter(typeArticle -> typeArticle.getNom().equals(name))
            .findFirst()
            .orElse(TypeArticle.DEFAULT);
    }

    public void updateQuality() {

        Arrays.stream(items).forEach(Item::updateQuality);
    }

}
