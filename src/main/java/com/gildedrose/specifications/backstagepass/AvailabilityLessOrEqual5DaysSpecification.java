package com.gildedrose.specifications.backstagepass;

import com.gildedrose.Item;
import com.gildedrose.items.BackstagePass;
import com.pattern.AbstractSpecification;

public class AvailabilityLessOrEqual5DaysSpecification extends AbstractSpecification<BackstagePass> {

    @Override
    public boolean isSatisfiedBy(BackstagePass item) {
        return item.sellIn <= 5;
    }
}
