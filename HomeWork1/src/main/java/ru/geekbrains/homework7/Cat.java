package ru.geekbrains.homework7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean isFed;
    public Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
        this.isFed = false;
    }
    public void eat(Plate p) {
        System.out.println("Кот "+this.name +" пытается поесть");
        if (!isFed()) {
            if (this.appetite > p.getFood()) {
                System.out.println("Для кота " + this.name + " в этой тарелке слишком мало еды. Коту нужно "+this.appetite+ ". В тарелке: "+p.getFood());
            } else {
                p.decreaseFood(this.appetite);
                this.isFed = true;
                System.out.println("Кот "+this.name +" успешно поел");
            }
        }
        else{
            System.out.println("Кот сыт. Не трогай его.");
        }
    }
    public boolean isFed(){
        return this.isFed;
    }
}
