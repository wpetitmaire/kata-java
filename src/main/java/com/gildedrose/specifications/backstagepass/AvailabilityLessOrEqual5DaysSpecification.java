package com.gildedrose.specifications.backstagepass;

import com.gildedrose.Item;
import com.pattern.AbstractSpecification;

public class AvailabilityLessOrEqual5DaysSpecification extends AbstractSpecification<Item> {

    @Override
    public boolean isSatisfiedBy(Item item) {
        return item.sellIn <= 5;
    }
}
