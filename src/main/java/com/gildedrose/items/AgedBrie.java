package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.specifications.agedbrie.OutdatedSpecification;
import com.gildedrose.specifications.common.ItemQualityUnderMaxQualitySpecification;
import com.pattern.Specification;

public class AgedBrie extends Item {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {

        ItemQualityUnderMaxQualitySpecification itemQualityUnderMaxQualitySpecification = new ItemQualityUnderMaxQualitySpecification();
        OutdatedSpecification outdatedSpecification = new OutdatedSpecification();

        this.sellIn -= Item.SELLIN_STEP;

        // Si la qualité de l'article n'est pas au maximum, elle augmente
        // if (this.quality < Item.MAX_QUALITY) {
        if (itemQualityUnderMaxQualitySpecification.isSatisfiedBy(this)) {

            this.quality += Item.QUALITY_STEP;

            // Elle augmente doublement si l'article est périmé
            if(itemQualityUnderMaxQualitySpecification.and(outdatedSpecification).isSatisfiedBy(this)) {
                this.quality += Item.QUALITY_STEP;
            }
        }
    }
}
