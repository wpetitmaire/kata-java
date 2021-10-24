package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends Item {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {

        this.sellIn -= Item.SELLIN_STEP;

        // Si la qualité de l'article n'est pas au maximum, elle augmente
        if (this.quality < Item.MAX_QUALITY) {

            this.quality += Item.QUALITY_STEP;

            // Elle augmente doublement si l'article est périmé
            if(this.quality < Item.MAX_QUALITY && this.sellIn < 0) {
                this.quality += Item.QUALITY_STEP;
            }
        }
    }
}
