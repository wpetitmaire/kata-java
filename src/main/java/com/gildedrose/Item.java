package com.gildedrose;

public class Item {

    public final static int MAX_QUALITY = 50;
    public final static int SULFURAS_QUALITY = 80;
    public final static int QUALITY_STEP = 1;
    public final static int BACKSTAGE_QUALITY_STEP_LESS_10_DAYS = 2;
    public final static int BACKSTAGE_QUALITY_STEP_LESS_5_DAYS = 3;
    public final static int SELLIN_STEP = 1;

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
