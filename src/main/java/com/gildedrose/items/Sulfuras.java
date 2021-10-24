package com.gildedrose.items;

import com.gildedrose.Item;

public class Sulfuras extends Item {

    public final static int MAX_QUALITY = 80;

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {

        // La qualité est toujours de 80
        if(this.quality != Sulfuras.MAX_QUALITY) {
            this.quality = Sulfuras.MAX_QUALITY;
        }
    }
}
