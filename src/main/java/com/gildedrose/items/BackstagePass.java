package com.gildedrose.items;

import com.gildedrose.Item;

public class BackstagePass extends Item {

    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {

        // Si la qualité n'est pas encore au maximum, elle augmente différemment selon le nombre le
        // nombre de jours de validité restants
        if (this.quality < Item.MAX_QUALITY) {

            // Moins de 5 jours restant
            if(this.sellIn <= 5 ) {
                this.quality += Item.BACKSTAGE_QUALITY_STEP_LESS_5_DAYS;
            }
            // Moins de 10 jours restant
            else if(this.sellIn <= 10 ) {
                this.quality += Item.BACKSTAGE_QUALITY_STEP_LESS_10_DAYS;
            }
            else {
                this.quality += Item.QUALITY_STEP;
            }

            if(this.quality > Item.MAX_QUALITY) {
                this.quality = Item.MAX_QUALITY;
            }
        }

        this.sellIn -= Item.SELLIN_STEP;

        // Une fois la date passée, la qualité tombe à 0.
        if(this.sellIn < 0 && this.quality > 0) {
            this.quality = 0;
        }
    }
}
