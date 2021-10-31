package com.gildedrose.specifications.common;

import com.gildedrose.Item;
import com.pattern.AbstractSpecification;

public class NotNullQualitySpecification extends AbstractSpecification<Item> {
    @Override
    public boolean isSatisfiedBy(Item item) {
        return item.quality > 0;
    }
}
