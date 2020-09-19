package ru.geekbrains.homework7;

public class Plate {
    private int food;
    private final int number;
    public Plate(int number, int food){
        this.food = food;
        this.number = number;
    }
    public void info(){
        System.out.println("plate: " + food);
    }
    public void decreaseFood(int a){
        if(a > this.food){
            System.out.println("В тарелке недостаточно еды для этого действия");
        }
        else{
            this.food -= a;
            System.out.println("В тарелке уменьшилось кол-во еды на "+ a );
        }

    }
    public int getFood(){
        return this.food;
    }
    public void addFood(int food){
        this.food += food;
        System.out.println("В тарелку добавлено еды: "+ food +". Всего еды: "+ this.food);
    }
}
