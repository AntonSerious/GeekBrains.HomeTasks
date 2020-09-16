package ru.geekbrains.homework6;

public class Cat extends Animal{
    public int Catcount;
    public Cat(String a, int b){
        super(a,b);
        Catcount ++;
    }
    @Override //переопределяю методы для котов
    public void toRun(int distance){
        if(distance > 200){
            System.out.println("It's too long distance for cats!");
        }
        else{
            System.out.println(this.getName() + " has run for "+ distance + " metres!");
        }
    }
    @Override
    public void jumpOver(float height){
        if(height > 2){
            System.out.println("It's too high for cats!");
        }
        else{
            System.out.println(this.getName() + " has jumped over the barrier with "+ height + " metres!");
        }
    }
    public void toSwim(int distance){
        System.out.println("Cat can not swim!!");
    }
}
