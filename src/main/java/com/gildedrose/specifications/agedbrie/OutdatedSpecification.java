package com.gildedrose.specifications.agedbrie;

import com.gildedrose.Item;
import com.pattern.AbstractSpecification;

public class OutdatedSpecification extends AbstractSpecification<Item> {

    @Override
    public boolean isSatisfiedBy(Item item) {
        return item.sellIn < 0;
    }
}
