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

            switch (typeOfItem) {
                case DEFAULT:

                    if(item.quality > 0) {
                        item.quality -= 1;
                    }

                    item.sellIn = item.sellIn - 1;

                    if(item.sellIn < 0 && item.quality > 0) {
                        item.quality -= 1;
                    }

                    continue;

                case AGED_BRIE:

                    if (item.quality < 50) {
                        item.quality += 1;
                    }

                    item.sellIn = item.sellIn - 1;

                    if(item.quality < 50 && item.sellIn < 0) {
                        item.quality = item.quality + 1;
                    }

                    continue;

                case BACKSTAGE_PASSES:

                    if (item.quality < 50) {

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

                    item.sellIn = item.sellIn - 1;

                    if(item.sellIn < 0 && item.quality > 0) {
                        item.quality = 0;
                    }

                    continue;

                case SULFURAS:

                    if(item.quality < 50) {
                        item.quality += 1;
                    }

                    continue;
            }
        }
    }
}
