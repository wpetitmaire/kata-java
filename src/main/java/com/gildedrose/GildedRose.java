package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    TypeArticle GetTypeArticle(String name) {

        return Arrays.stream(TypeArticle.values())
            .filter(typeArticle -> typeArticle.getNom().equals(name))
            .findFirst()
            .orElse(TypeArticle.DEFAULT);
    }

    public void updateQuality() {

        Arrays.stream(items).forEach(item -> {

            TypeArticle typeOfItem = this.GetTypeArticle(item.name);

            switch (typeOfItem) {

                case DEFAULT:
                    updateDefaultArticleQuality(item);
                    return;

                case AGED_BRIE:
                    updateAgedBrieArticleQuality(item);
                    return;

                case BACKSTAGE_PASSES:
                    updateBackstagePassesQuality(item);
                    return;

                case SULFURAS:
                    updateSulfurasArticleQuality(item);
                    return;

                case CONJURED:
                    updateConjuredArticleQuality(item);
                    return;
            }
        });
    }

    private void updateSulfurasArticleQuality(Item item) {

        // La qualité est toujours de 80
        if(item.quality != Item.SULFURAS_QUALITY) {
            item.quality = Item.SULFURAS_QUALITY;
        }
    }

    private void updateBackstagePassesQuality(Item item) {

        // Si la qualité n'est pas encore au maximum, elle augmente différemment selon le nombre le
        // nombre de jours de validité restants
        if (item.quality < Item.MAX_QUALITY) {

            // Moins de 5 jours restant
            if(item.sellIn <= 5 ) {
                item.quality += Item.BACKSTAGE_QUALITY_STEP_LESS_5_DAYS;
            }
            // Moins de 10 jours restant
            else if(item.sellIn <= 10 ) {
                item.quality += Item.BACKSTAGE_QUALITY_STEP_LESS_10_DAYS;
            }
            else {
                item.quality += Item.QUALITY_STEP;
            }

            if(item.quality > Item.MAX_QUALITY) {
                item.quality = Item.MAX_QUALITY;
            }
        }

        item.sellIn -= Item.SELLIN_STEP;

        // Une fois la date passée, la qualité tombe à 0.
        if(item.sellIn < 0 && item.quality > 0) {
            item.quality = 0;
        }
    }

    private void updateAgedBrieArticleQuality(Item item) {

        item.sellIn -= Item.SELLIN_STEP;

        // Si la qualité de l'article n'est pas au maximum, elle augmente
        if (item.quality < Item.MAX_QUALITY) {

            item.quality += Item.QUALITY_STEP;

            // Elle augmente doublement si l'article est périmé
            if(item.quality < Item.MAX_QUALITY && item.sellIn < 0) {
                item.quality += Item.QUALITY_STEP;
            }
        }
    }

    private void updateDefaultArticleQuality(Item item) {

        item.sellIn -= Item.SELLIN_STEP;

        // Si la qualité n'est pas encore nulle, elle se dégrade
        if(item.quality > 0) {

            item.quality -= Item.QUALITY_STEP;

            // Elle se dégrade doublement si l'article est périmé
            if(item.quality > 0 && item.sellIn < 0) {
                item.quality -= Item.QUALITY_STEP;
            }
        }
    }

    private void updateConjuredArticleQuality(Item item) {
        updateDefaultArticleQuality(item);
        updateDefaultArticleQuality(item);
    }
}
