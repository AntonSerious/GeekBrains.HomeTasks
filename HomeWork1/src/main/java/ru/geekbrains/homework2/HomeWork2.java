package ru.geekbrains.homework2;

public class HomeWork2 {
    public static void main(String[] args) {
//1. Задать целочисленный массив, состоящий из элементов 0 и 1.
// Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("-----------------Task_1-----------------------------");
        byte[] array1 = {1, 0, 1, 1, 1, 0, 1, 0, 1, 0};

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) {
                array1[i] = 1;
            } else {
                array1[i] = 0;
            }
        }
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
        System.out.println("----------------------------------------------------");

//2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("-----------------Task_2-----------------------------");
        byte[] array2 = new byte[8];
        for (byte i = 0; i < array2.length; i++) {
            array2[i] = (byte) (3 * i);
        }
        for (byte value : array2) { //IDEA предложил мне вот такой модифицированный for
            System.out.println(value);
        }
        System.out.println("----------------------------------------------------");

//3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("-----------------Task_3-----------------------------");
        byte[] array3 = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (byte i = 0; i < array3.length; i++) {
            if(array3[i] < 6){
                array3[i] = (byte) ( array3[i] * 2);
            }
        }
        for (byte b : array3) {
            System.out.println(b);
        }

        System.out.println("----------------------------------------------------");

//4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами;


//Наверное имеется в виду заполнить главную и побочную диагональ.
        System.out.println("-----------------Task_4-----------------------------");
        int[][] array4 = new int[7][7];
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4[i].length; j++) {
                if (i == j || i + j + 1 == array4.length){
                    array4[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4[i].length; j++) {
                System.out.print(array4[i][j] + " ");
            }
            System.out.println(" ");
        }

        System.out.println("----------------------------------------------------");

        System.out.println("-----------------Task_5-----------------------------");
//5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] array5 = {1,5,3,2,11,4,5,2,4,8,9,1};
        int max = array5[0];
        int min = array5[0];
        for (int i = 0; i < array5.length; i++) {
            if(array5[i] > max){
                max = array5[i];
            }
            if(array5[i] < min){
                min = array5[i];
            }
        }
        System.out.println("max is : " + max +" "+ "min is : " + min);


        System.out.println("----------------------------------------------------");


        System.out.println("-----------------Task_6-----------------------------");
//6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
// Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.

        int[] array6 = {2,4,4,3,1,6,1,1,6};

        System.out.println(checkBalance(array6));
        for (int i = 0; i < array6.length; i++) {
            int sum_i = sumElemOfArrTillIndex(array6, i);
            if(sum_i == sumElemOfArrTillIndex(array6, array6.length-1) - sum_i){
                System.out.println("The balance between " + i + " and " + (int)(i+1) + " indexes");
                break;
            }
        }

        System.out.println("----------------------------------------------------");

        System.out.println("-----------------Task_7-----------------------------");

        //7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, илиотрицательным),
        // при этом метод должен сместить все элементымассива на n позиций.
        // Для усложнения задачи нельзя пользоваться вспомогательными массивами.

        int[] array7 = {1,5,3,2,11,4,5,2,4,8,9,1};

        int[] array7_2 = ArrShift(array7, 0);
        for (int i = 0; i < array7_2.length ; i++) {
            System.out.print(array7_2[i] + " ");
        }
        System.out.println(" ");
        System.out.println("----------------------------------------------------");


    }
    public static boolean checkBalance(int[] a){
        for (int i = 0; i <a.length ; i++) {
            int sum_i = sumElemOfArrTillIndex(a, i);
            if(sum_i == sumElemOfArrTillIndex(a, a.length-1) - sum_i){
                return (true);
            }
        }
        return(false);
    }
    public static int sumElemOfArrTillIndex(int[] a, int b){
        int sum = 0;
        for (int i = 0; i <= b; i++) {
            sum = sum + a[i];
        }
        return (sum);
    }

    public static int[] positiveArrShift(int[] a){
        int additional_slot;
        additional_slot = a[a.length-1];
        for (int i = a.length-1; i >0 ; i--) {

            a[i] = a[i-1];
        }
        a[0] = additional_slot;
        return (a);
    }
    public static int[] negativeArrShift(int[] a){
        int additional_slot;
        additional_slot = a[0];
        for (int i = 0; i < a.length-1 ; i++) {

            a[i] = a[i+1];
        }
        a[a.length-1] = additional_slot;
        return (a);
    }
    public static int[] ArrShift(int[] a, int s){
        if(s >= 0) {
            for (int i = 0; i < s; i++) {
                a = positiveArrShift(a);
            }
        }
        if(s < 0) {
            for (int i = 0; i < Math.abs(s); i++) {
                a = negativeArrShift(a);
            }
        }
        return (a);
    }
}
