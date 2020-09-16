package ru.geekbrains.homework6;

public class Main {
    public static void main(String[] args) {
        System.out.println("Понеслась");

        Animal animal1 = new Animal("Tuzik", 10);

        //Cat cat1 = new Cat("Barsevich", 1);
        //System.out.println("cats qnty: "+ cat1.Catcount);
        //Cat cat2 = new Cat("Drujok", 1);
        //System.out.println("cats qnty: "+ cat2.Catcount);

        Dog dog1 = new Dog("Rex", 11, 400);
        Dog dog2 = new Dog("Grand", 5, 600);
        Dog dogWithoutMaxDistance = new Dog("Slowy", 7);

        animal1.getInfo();
        animal1.toRun(10);
        animal1.toSwim(20);


        dog1.toRun(300);
        dog1.toRun(500);
        dog2.toRun(500);
        dog2.toRun(700);
        dogWithoutMaxDistance.toRun(500);
        dogWithoutMaxDistance.toRun(600);



    }
}
