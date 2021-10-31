package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.specifications.backstagepass.AvailabilityLessOrEqual10DaysSpecification;
import com.gildedrose.specifications.backstagepass.AvailabilityLessOrEqual5DaysSpecification;
import com.gildedrose.specifications.common.ItemQualityUnderMaxQualitySpecification;
import com.gildedrose.specifications.common.OutdatedSpecification;

public class BackstagePass extends Item {

    public final static int QUALITY_STEP_LESS_10_DAYS = 2;
    public final static int QUALITY_STEP_LESS_5_DAYS = 3;

    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {

        ItemQualityUnderMaxQualitySpecification itemQualityUnderMaxQuality = new ItemQualityUnderMaxQualitySpecification();
        AvailabilityLessOrEqual5DaysSpecification availabilityLessOrEqual5Days = new AvailabilityLessOrEqual5DaysSpecification();
        AvailabilityLessOrEqual10DaysSpecification availabilityLessOrEqual10Days = new AvailabilityLessOrEqual10DaysSpecification();
        OutdatedSpecification outdated = new OutdatedSpecification();

        // Si la qualité n'est pas encore au maximum, elle augmente différemment selon le nombre le
        // nombre de jours de validité restants
        if (itemQualityUnderMaxQuality.isSatisfiedBy(this)) {

            // Moins de 5 jours restant
            if(availabilityLessOrEqual5Days.isSatisfiedBy(this)) {
                this.quality += BackstagePass.QUALITY_STEP_LESS_5_DAYS;
            }
            // Moins de 10 jours restant
            else if(availabilityLessOrEqual10Days.isSatisfiedBy(this)) {
                this.quality += BackstagePass.QUALITY_STEP_LESS_10_DAYS;
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
        if(outdated.isSatisfiedBy(this) && this.quality > 0) {
            this.quality = 0;
        }
    }
}
