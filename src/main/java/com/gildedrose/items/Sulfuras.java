package com.gildedrose.items;

import com.gildedrose.Item;

public class Sulfuras extends Item {
    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {

        // La qualité est toujours de 80
        if(this.quality != Item.SULFURAS_QUALITY) {
            this.quality = Item.SULFURAS_QUALITY;
        }
    }
}
