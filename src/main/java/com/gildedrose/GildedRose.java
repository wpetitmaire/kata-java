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

            if (typeOfItem != TypeArticle.AGED_BRIE
                && typeOfItem != TypeArticle.BACKSTAGE_PASSES) {
                if (item.quality > 0) {
                    if (typeOfItem != TypeArticle.SULFURAS) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (typeOfItem == TypeArticle.BACKSTAGE_PASSES) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
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
