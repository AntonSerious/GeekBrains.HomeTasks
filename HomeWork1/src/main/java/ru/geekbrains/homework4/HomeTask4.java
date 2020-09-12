package ru.geekbrains.homework4;

import com.sun.glass.ui.Size;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeTask4 {
    static final int SIZE = 5;

    static char[][] map;
    static final char DOT_X = 'X';
    static final char DOT_0 = '0';
    static final char DOT_EMPTY = '.';
    static final int NUMBER_OF_ELEMENTS_TO_WIN = 4;
    static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    static void printMap(){// Убрал отрисовку координат, чтобы не загромождать рисунок
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {        //Рисуем наш массив в виде  a[0][0] a[0][1] a[0][2] ...
                System.out.print(map[i][j] + " ");  //                          a[1][0] a[1][1] a[1][2] ...
            }                                       //                          a[2][0] a[2][1] a[2][2] ...
            System.out.println();                   //                          ...     ...     ...
        }
    }
    static void humanTurn(){
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;

        do{
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt()-1;
            y = scanner.nextInt()-1;

        } while (!isCellValid(x,y));
        map[x][y] = DOT_X;
    }

    static void aiTurn(){
        Random random = new Random();
        int x;
        int y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));

        System.out.println("Компьютер походил: " + (x+1) + " и " + (y+1));
        map[x][y] = DOT_0;
    }
/*    static void aiCleverTurn(char map[][]){
        Random random = new Random();
        int x;
        int y;

        int coord[] = aiAnalyze(map);
        if(coord[0] == -1) {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
        }
        else{
            x = coord[0];
            y = coord[1];
        }
        System.out.println("Компьютер походил: " + (x+1) + " и " + (y+1));
        map[x][y] = DOT_0;
    }
*/
   /* static int[] aiAnalyze(char a[][]){ //метод будет анализировать - какой следующий ход будет выигрышным для различных
                                      //по длине посследовательностей из символов
        int x;
        int y;
        int aiTurnCoord[] = {-1,-1};
        char[][] b = new char[a.length][a.length];
        b = Arrays.copyOf(a, a.length); // создаем копию текущей карты
        for(int currSequence = NUMBER_OF_ELEMENTS_TO_WIN; currSequence>=3; currSequence--) {
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b[i].length; j++) {
                    if (b[i][j] == DOT_EMPTY) {
                        b[i][j] = DOT_X;
                        if (isWiner(b, DOT_X, currSequence)) {
                            aiTurnCoord[0] = i;
                            aiTurnCoord[1] = j;
                            return (aiTurnCoord);
                        }
                        else{
                            b = null;
                            b = Arrays.copyOf(a, a.length);
                        }
                    }
                }

            }
        }
        return (aiTurnCoord);
    }
*/
    static boolean isWiner(char map[][], char symb, int chipNumber){
        int numberOfElements = 0;

        for (int i = 0; i < map.length; i++) { //Ищем победную последовательность в каждой строке
            for (int j = 0; j < map[i].length ; j++) {
                if(map[i][j] != symb){
                    numberOfElements =0;
                }
                else{
                    numberOfElements++;
                }
                if(numberOfElements >= chipNumber){//если количество символов, идущих подряд достигло необходимого для выигрыша, то выходим из метода
                    return true;
                }
            }
        }

        for (int j = 0; j < map.length; j++) { //Ищем победную последовательность в каждом столбце
            numberOfElements = 0;
            for (int i = 0; i < map.length ; i++) {
                if(map[i][j] != symb){
                    numberOfElements =0;
                }
                else{
                    numberOfElements++;
                }
                if(numberOfElements >= NUMBER_OF_ELEMENTS_TO_WIN){ //если дошли до последнего элемента Строки и наш флаг не поменялся, значит мы прошлись по победной последовательности.
                    return (true);
                }
            }
        }

        numberOfElements = 0;
        for (int i = 0; i < SIZE ; i++) {       //поиск победной последовательности '\' в диагоналях  * * * * *
            for (int j = i; j < SIZE; j++) {    //                                                    . * * * *
                if (map[j-i][j] != symb) {      //                                                    . . * * *
                    numberOfElements = 0;       //                                                    . . . * *
                                                //                                                    . . . . *
                    //System.out.println("элемент map["+(j-i)+"]["+j+"] = "+ map[j-i][j]);
                }
                else{
                    numberOfElements++;
                }
                //System.out.println("элемент map["+(j-i)+"]["+j+"] = "+ map[j-i][j]);
                if (numberOfElements >= NUMBER_OF_ELEMENTS_TO_WIN) { //если дошли до последнего элемента Строки и наш флаг не поменялся, значит мы прошлись по победной последовательности.
                    return (true);
                }
            }
        }

        numberOfElements = 0;                    //поиск победной последовательности '\' в диагоналях  * . . . .
        for (int i = 0; i < SIZE ; i++) {        //                                                    * * . . .
            for (int j = i; j < SIZE ; j++) {    //                                                    * * * . .
                if (map[j][j - i] != symb) {     //                                                    * * * * .
                    numberOfElements = 0;        //                                                    * * * * *
                } else {
                    numberOfElements++;
                }
                if (numberOfElements >= NUMBER_OF_ELEMENTS_TO_WIN) { //если дошли до последнего элемента Строки и наш флаг не поменялся, значит мы прошлись по победной последовательности.
                    return (true);

                }
            }
        }

        numberOfElements = 0;                    //поиск победной последовательности '/' в диагоналях  * * * * *
        for (int i = SIZE-1; i >= 0; i--) {      //                                                    * * * * .
            for (int j = 0; j <= i ; j++) {      //                                                    * * * . .
                if (map[i - j][j] != symb) {     //                                                    * * . . .
                    numberOfElements = 0;        //                                                    * . . . .
                }
                else{
                    numberOfElements++;
                }
                if (numberOfElements >= NUMBER_OF_ELEMENTS_TO_WIN) { //если дошли до последнего элемента Строки и наш флаг не поменялся, значит мы прошлись по победной последовательности.
                    return (true);
                }
            }
        }

        numberOfElements = 0;                       //поиск победной последовательности '/' в диагоналях  . . . . *
        for (int i = 0; i < SIZE; i++) {            //                                                    . . . * *
            for (int j = i; j < SIZE ; j++) {       //                                                    . . * * *
                if (map[SIZE - 1 + i - j][j] != symb) { //                                                . * * * *
                    numberOfElements = 0;           //                                                    * * * * *
                }
                else{
                    numberOfElements++;
                }
                if (numberOfElements >= NUMBER_OF_ELEMENTS_TO_WIN) { //если дошли до последнего элемента Строки и наш флаг не поменялся, значит мы прошлись по победной последовательности.
                    return (true);
                }
            }
        }


        numberOfElements = 0;
        for (int i = 0; i < map.length; i++) { //Ищем победную последовательность в побочной диагонале
            if(map[i][map.length-1-i] != symb) {
                //isWinSequence = false;//останавливаем поиск
                numberOfElements = 0; //переходим к поиску в следующей строке
            }
            else{
                numberOfElements++;
            }
            if(numberOfElements >= NUMBER_OF_ELEMENTS_TO_WIN){ //если дошли до последнего элемента Строки и наш флаг не поменялся, значит мы прошлись по победной последовательности.
                return (true);
            }
        }
        return (false);
    }

    static boolean isCellValid(int x, int y){
        if (x<0 || x >=SIZE || y < 0 || y >=SIZE){
            return false;
        }
        if (map[x][y] == DOT_EMPTY){
            return true;
        }
        return false;

    }
    static boolean isMapFull(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true){
            humanTurn();
            printMap();
            if(isWiner(map, DOT_X, NUMBER_OF_ELEMENTS_TO_WIN)){
                System.out.println("Человек победил");
                break;
            }
            aiTurn();
            printMap();
            if(isWiner(map, DOT_0, NUMBER_OF_ELEMENTS_TO_WIN)){
                System.out.println("Компьютер победил");
                break;
            }

            if(isMapFull()){
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра окончена");
    }
}
