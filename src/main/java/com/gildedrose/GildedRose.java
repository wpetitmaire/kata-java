package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    TypeArticle GetTypeArticle(String name) {

        for(TypeArticle typeArticle: TypeArticle.values()) {

            if(typeArticle.getNom().equals(name))
                return typeArticle;
        }

        return TypeArticle.DEFAULT;
    }

    public void updateQuality() {

        System.out.println("--updateQuality--");

        for (Item item : items) {

            TypeArticle typeOfItem = this.GetTypeArticle(item.name);

            // Pour articles normaux avec encore de la qualité, elle baisse
            if(typeOfItem == TypeArticle.DEFAULT && item.quality > 0) {
                item.quality -= 1;
            }
            // Les autres montent en qualité
            else if (item.quality < 50) {

                // Pour les articles de types "Backstages Passes"
                if (typeOfItem == TypeArticle.BACKSTAGE_PASSES) {

                    // ... De 5 jours ou moins
                    if(item.sellIn <= 5 ) {
                        item.quality += 3;
                    }
                    // ... De 10 jours ou moins
                    else if(item.sellIn <= 10 ) {
                        item.quality += 2;
                    }
                    else {
                        item.quality += 1;
                    }

                    if(item.quality > 50) {
                        item.quality = 50;
                    }
                }
                else {
                    item.quality += 1;
                }





            }

            if (typeOfItem != TypeArticle.SULFURAS) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (typeOfItem != TypeArticle.AGED_BRIE) {
                    if (typeOfItem != TypeArticle.BACKSTAGE_PASSES) {
                        if (item.quality > 0) {
                            if (typeOfItem != TypeArticle.SULFURAS) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }


    }
}
