package ru.geekbrains.homework1;

public class HomeWork1 {
    public static void main(String[] args ){
        //---------------------- Пункт 2
        byte byte_var = 127;
        short short_var = 1467; //такого codestyle не придерживаемся при объявлении переменных?
        int intVar = 1424536734; // а правильнее придерживаться вот такого codestyle?
        long longVar = 929885728898l; // здесь у меня среда разработки подсвечивает - число слишком большое для long, хотя оно явно меньше чем 2^64
        float floatVar = 1.644567574f;
        double doubleVar = 1.56788456453737475;
        char charVar = (char)10101100;
        boolean boleanVar = true;
        //-----------------------------------
        
        //---------------Вывожу результаты методов
        System.out.println(result1(3.7f, 4.3f, 5, 6.1456f) );
        System.out.println(result2(4, 1));
        result3(-5);
        System.out.println(result4(2));
        hello_method("anton");
        System.out.println(visokos_god(0));
        //-----------------------------------------
    }
    //--------------------------Пункт 3
    public static float result1 (float a , float b, float c, float d){ //не оговорено - какой тип данных должен возвращать метод. Я выбрал float
        return (a * (b + (c / d)));
    }
    //-----------------------------------------------

    //--------------------------Пункт 4
    public static boolean result2 (int a, int b){
        if(a + b >= 10 && a + b <=20 ){
            return true;
        }
        else{
            return false;
        }
    }
    //-------------------------------------------------

    //----------------------Пункт 5
    public static void result3(int a){
        if (a>=0){
            System.out.println("Положительное");
        }
        else{
            System.out.println("Отрицательное");
        }
    }

    //------------------------------------------

    //-----------------------------Пункт 6
    public static boolean result4(int a){
        if (a>=0){
            return true;
        }
        else{
            return false;
        }
    }
    //--------------------------------------

    //-----------------------------Пункт 7
    public static void hello_method(String a){
        System.out.println("«Привет, " + a + "!»");
    }
    //------------------------------------

    //------------------------------Пункт 8
    public static String visokos_god(int a){
        if(a % 4 == 0 ){
            if( a % 100 == 0 && a % 400 != 0) {
                return ("Это НЕ високосный год");
            }
            else {
                return ("Это високосный год");
            }
        }
        else{
            return ("Это Не високосный год");
        }

    }


    //-------------------------------------
}
