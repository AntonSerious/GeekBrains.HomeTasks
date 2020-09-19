package ru.geekbrains.homework7;

public class MainClass {
    public static void main(String[] args) {
        Plate plate = new Plate(1,16);


        Cat cat1 = new Cat("Garfield", 10);
        Cat cat2 = new Cat("Tuz", 5);
        Cat cat3 = new Cat("Bars", 2);
        Cat cat4 = new Cat("Myatniy", 3);
        Cat[] cats = {cat1, cat2, cat3, cat4};
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat.isFed());
            plate.info();
        }

        System.out.println("Теперь пополним тарелку:");
        plate.addFood(50);
        plate.info();
    }

}
