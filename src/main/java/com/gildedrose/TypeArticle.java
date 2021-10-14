package com.gildedrose;

public enum TypeArticle {
    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED("Conjured Mana Cake"),
    DEFAULT("");

    private String nom;

    @Override
    public String toString() {
        return "TypeArticle{" +
            "nom='" + nom + '\'' +
            '}';
    }

    public String getNom() {
        return nom;
    }

    TypeArticle(String nom) {
        this.nom = nom;
    }
}
