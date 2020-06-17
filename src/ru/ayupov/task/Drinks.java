package ru.ayupov.task;

public enum Drinks {
    COLA("Coca-Cola", 100),
    PEPSI("Pepsi", 90),
    SPRITE("Sprite", 80),
    LIPTON("Lipton", 70),
    BONAQUA("Bonaqua", 60);

    String title;
    int price;

    Drinks(String title, int price) {
        this.title = title;
        this.price = price;
    }

    static public int length() {
        return values().length;
    }

}
