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

                    item.sellIn -= 1;

                    // Si la qualité n'est pas encore nulle, elle se dégrade
                    if(item.quality > 0) {

                        item.quality -= 1;

                        // Elle se dégrade doublement si l'article est périmé
                        if(item.quality > 0 && item.sellIn < 0) {
                            item.quality -= 1;
                        }
                    }

                    continue;

                case AGED_BRIE:

                    item.sellIn = item.sellIn - 1;

                    // Si la qualité de l'article n'est pas au maximum, elle augmente
                    if (item.quality < 50) {

                        item.quality += 1;

                        // Elle augmente doublement si l'article est périmé
                        if(item.quality < 50 && item.sellIn < 0) {
                            item.quality += 1;
                        }
                    }

                    continue;

                case BACKSTAGE_PASSES:

                    // Si la qualité n'est pas encore au maximum, elle augmente différemment selon le nombre le
                    // nombre de jours de validité restants
                    if (item.quality < 50) {

                        // Moins de 5 jours restant
                        if(item.sellIn <= 5 ) {
                            item.quality += 3;
                        }
                        // Moins de 10 jours restant
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

                    // Une fois la date passée, la qualité tombe à 0.
                    if(item.sellIn < 0 && item.quality > 0) {
                        item.quality = 0;
                    }

                    continue;

                case SULFURAS:

                    // La qualité est toujours de 80
                    if(item.quality != 80) {
                        item.quality = 80;
                    }

                    continue;
            }
        }
    }
}
