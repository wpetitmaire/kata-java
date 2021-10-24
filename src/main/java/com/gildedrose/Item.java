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

    public void updateQuality() {
        this.sellIn -= Item.SELLIN_STEP;

        // Si la qualité n'est pas encore nulle, elle se dégrade
        if(this.quality > 0) {

            this.quality -= Item.QUALITY_STEP;

            // Elle se dégrade doublement si l'article est périmé
            if(this.quality > 0 && this.sellIn < 0) {
                this.quality -= Item.QUALITY_STEP;
            }
        }
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
