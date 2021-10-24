package com.gildedrose.items;

import com.gildedrose.Item;

public class Conjured extends Item {
    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        super.updateQuality();
        super.updateQuality();
    }
}
