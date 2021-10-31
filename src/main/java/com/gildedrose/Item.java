package com.gildedrose;

import com.gildedrose.specifications.common.NotNullQualitySpecification;
import com.gildedrose.specifications.common.OutdatedSpecification;

public class Item {

    public final static int MAX_QUALITY = 50;
    public final static int QUALITY_STEP = 1;
    public final static int SELLIN_STEP = 1;

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void updateQuality() {

        OutdatedSpecification outdatedSpecification = new OutdatedSpecification();
        NotNullQualitySpecification notNullQuality = new NotNullQualitySpecification();

        this.sellIn -= Item.SELLIN_STEP;

        // Si la qualité n'est pas encore nulle, elle se dégrade
        if(notNullQuality.isSatisfiedBy(this)) {

            this.quality -= Item.QUALITY_STEP;

            // Elle se dégrade doublement si l'article est périmé
            if(notNullQuality.and(outdatedSpecification).isSatisfiedBy(this)) {
                this.quality -= Item.QUALITY_STEP;
            }
        }
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
