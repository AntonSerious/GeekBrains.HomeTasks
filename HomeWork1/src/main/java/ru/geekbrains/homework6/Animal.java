package ru.geekbrains.homework6;

import java.sql.SQLOutput;

public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void getInfo(){
        System.out.println("Name is: "+ this.name + " Age is: "+ this.age );
    }
    public void toRun(int distance){
        System.out.println("The animal has run for " + distance + " metres" );
    }
    public void toSwim(int distance){
        System.out.println("The animal has swum for " + distance + " metres" );
    }
    public void jumpOver(float height){
        System.out.println("The animal has jumped up for " + height + " metres" );
    }
    public String getName(){
        return this.name;
    }

}
