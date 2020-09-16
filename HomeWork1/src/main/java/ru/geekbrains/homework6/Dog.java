package ru.geekbrains.homework6;

public class Dog extends Animal{
    private int maxDistanceForRun;
    public Dog(String name, int age){
        super(name, age);
    }
    public Dog(String name, int age, int maxDistanceForRun){ //Перегрузил конструктор. Добавил необязательный парметр "Максимальня дистанция для бега"
        super(name, age);
        this.maxDistanceForRun = maxDistanceForRun;
    }
    @Override
    public void toRun(int distance){

        if(this.maxDistanceForRun ==0){ //если Dog создан без необязательного поля, то метод toRun выполняется как для суперкласса.
            if(distance > 500 ){
                System.out.println("It's too long distance for dogs!");
            }
            else{
                System.out.println(this.getName() + " has run for "+ distance + " metres!");
            }
        }
        else{
            if(distance > this.maxDistanceForRun ){
                System.out.println(this.getName() + " has restriction for run: "+ this.getMaxDistance()+ " metres");
            }
            else{
                System.out.println(this.getName() + " has run for "+ distance + " metres!");
            }
        }
    }
    @Override
    public void jumpOver(float height){
        if(height > 0.5){
            System.out.println("It's too high for dogs!");
        }
        else{
            System.out.println(this.getName() + " has jumped over the barrier with "+ height + " metres!");
        }
    }
    @Override
    public void toSwim(int distance){
        if(distance > 10){
            System.out.println("It's too long for dogs!");
        }
        else{
            System.out.println(this.getName() + " has swum for "+ distance + " metres!");
        }
    }

    public int getMaxDistance(){
        return this.maxDistanceForRun;
    }
}
