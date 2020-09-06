package ru.geekbrains.homework3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeTask3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("В какую игру играем? (1 - 'Угадай число', 2 - 'Угадай слово')");
        String answer = scanner.nextLine();
        if(answer.equals("1")){
            game1();
        }
        if (answer.equals("2")){
            game2();
        }
        else{
            System.out.println("Вы ввели неправильный номер");
        }

        //2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        //сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
        //apple – загаданное
        //apricot - ответ игрока
        //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        //Для сравнения двух слов посимвольно, можно пользоваться:
        //String str = "apple";
        //str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        //Играем до тех пор, пока игрок не отгадает слово
        //Используем только маленькие буквы




    }
    public static void game1(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int x;
        String rawInput;
        int input;
        byte isRepeat=0;
        int bound = 9;
        int tryNumber = 3;
        do{
            x = random.nextInt(bound);
            System.out.println("Начинаем игру 'Угадай число'. Загадано число от 0 до 9. Попробуйте его угадать: ");
            for (int i = 0; i < tryNumber; i++) {
                //do{
                //    System.out.println("Вы ввели не целое число. Введите ЦЕЛОЕ число.");
                //}
                //while(Integer.class.isInstance(rawInput) == false);


                while (!scanner.hasNextInt()){ //Пока не разобрался с try-catch. Cделал вот такой обработчик.
                    //Если ввести сначала целое число, потом не целое, то println снизу отработает даважды.
                    //Я так понял, что scanner.hasNextInt() ждет на вход ввод, а потом использует этот ввод в следующем scanner.nextInt().
                    //И для этого я использую пустышку rawInput, в которое сбрасываю только что прочтенный ввод.
                    System.out.println("Вы ввели не целое число. Введите ЦЕЛОЕ число.");
                    if(scanner.hasNextInt()){
                        input = scanner.nextInt();
                    }
                    else{
                        rawInput = scanner.nextLine();
                    }

                }
                input = scanner.nextInt();

                if (input > x) {
                    if(i != tryNumber-1){
                        System.out.println("Загаданное число меньше. Повторите попытку: ");
                    }
                    else{
                        System.out.println("Попытки закончились. Вы проиграли. Повторим игру? (1 - да, 0 - нет): ");
                        isRepeat = scanner.nextByte();
                    }

                }
                if (input < x) {
                    if(i != tryNumber-1){
                        System.out.println("Загаданное число больше. Повторите попытку: ");
                    }
                    else{
                        System.out.println("Попытки закончились. Вы проиграли. Повторим игру? (1 - да, 0 - нет): ");
                        isRepeat = scanner.nextByte();
                    }
                }
                if (input == x) {
                    System.out.println("Поздравляем! Вы угадали. Повторим игру? (1 - да, 0 - нет): ");
                    isRepeat = scanner.nextByte();
                    break;
                }

            }

        } while (isRepeat == 1);

    }

    public static void game2() {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();

        String guessedWord = words[random.nextInt(words.length - 1)];
        //System.out.println(guessedWord);

        System.out.println("Загадано одно из следующих слов: ");
        System.out.println(Arrays.toString(words));
        System.out.println("Попробуйте его угадать");
        String answer;
        do {
            answer = scanner.nextLine();
            if(answer.equals(guessedWord)){
                System.out.println("Угадал! Спасибо за игру.");
                break;
            }
            else{
                System.out.println("Не угадал. Вот подсказка: ");
            }

            for (int i = 0; i < 15; i++) {
                if (i < guessedWord.length() && i <answer.length() && guessedWord.charAt(i) == answer.charAt(i)) {
                    System.out.print(answer.charAt(i));
                } else {
                    System.out.print("#");
                }

            }
            System.out.println("");
            System.out.println("");

        } while (!answer.equals(guessedWord));
    }
}


