package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstagePass;
import com.gildedrose.specifications.backstagepass.AvailabilityLessOrEqual10DaysSpecification;
import com.gildedrose.specifications.backstagepass.AvailabilityLessOrEqual5DaysSpecification;
import com.gildedrose.specifications.common.NotNullQualitySpecification;
import com.gildedrose.specifications.common.OutdatedSpecification;
import com.gildedrose.specifications.common.ItemQualityUnderMaxQualitySpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpecificationTest {

    @Test
    void itemQualityUnderMaxQualitySpecificationTest() {

        AgedBrie agedBrie = new AgedBrie("Aged brie", 2, 10);
        ItemQualityUnderMaxQualitySpecification specification = new ItemQualityUnderMaxQualitySpecification();

        assertTrue(specification.isSatisfiedBy(agedBrie));
    }

    @Test
    void outdatedSpecificationTest() {

        AgedBrie agedBrie = new AgedBrie("Aged brie", 2, 10);
        OutdatedSpecification specification = new OutdatedSpecification();

        assertFalse(specification.isSatisfiedBy(agedBrie));

    }

    @Test
    void availabilityLessOrEqual5DaysSpecificationTest() {
        BackstagePass backstagePass = new BackstagePass("Item", 3, 20);
        AvailabilityLessOrEqual5DaysSpecification specification = new AvailabilityLessOrEqual5DaysSpecification();

        assertTrue(specification.isSatisfiedBy(backstagePass));
    }

    @Test
    void availabilityLessOrEqual10DaysSpecificationTest() {
        BackstagePass backstagePass = new BackstagePass("Item", 3, 20);
        AvailabilityLessOrEqual10DaysSpecification specification = new AvailabilityLessOrEqual10DaysSpecification();

        assertTrue(specification.isSatisfiedBy(backstagePass));
    }

    @Test
    void notNullQualitySpecificationTest() {
        NotNullQualitySpecification specification = new NotNullQualitySpecification();
        Item item = new Item("item", 10, 15);

        assertTrue(specification.isSatisfiedBy(item));
    }

}
