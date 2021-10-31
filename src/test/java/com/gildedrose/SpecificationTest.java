package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.specifications.agedbrie.OutdatedSpecification;
import com.gildedrose.specifications.common.ItemQualityUnderMaxQualitySpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpecificationTest {

    @Test
    void ItemQualityUnderMaxQualitySpecificationTest() {

        AgedBrie agedBrie = new AgedBrie("Aged brie", 2, 10);
        ItemQualityUnderMaxQualitySpecification specification = new ItemQualityUnderMaxQualitySpecification();

        assertTrue(specification.isSatisfiedBy(agedBrie));
    }

    @Test
    void OutdatedSpecificationTest() {

        AgedBrie agedBrie = new AgedBrie("Aged brie", 2, 10);
        OutdatedSpecification specification = new OutdatedSpecification();

        assertFalse(specification.isSatisfiedBy(agedBrie));

    }
}
