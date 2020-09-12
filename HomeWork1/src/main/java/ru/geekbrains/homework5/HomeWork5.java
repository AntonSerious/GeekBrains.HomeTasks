package ru.geekbrains.homework5;

public class HomeWork5 {
    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Nemchenko Anton Valerievich","System Analyst", "anemchenko@nes.ru", "89295494066", 103000,26);
        persArray[1] = new Employee("Monahova Alina Olegovna","System Analyst", "alina@mail.ru", "89231234567", 50000,25);
        persArray[2] = new Employee("Scherbakov Oleg Olegovich","Engineer", "oleg@mail.ru", "89212345678", 56000,30);
        persArray[3] = new Employee("Savin Aleksandr Kirillovich","Junior Developer", "sasha@mail.ru", "89223456789", 30000,20);
        persArray[4] = new Employee("Obidin Andrey Viktorovich ","Head of IT Department", "andrey@mail.ru", "89245678912", 200000,41);

        for (Employee employee : persArray) {
            if (employee.getAge() > 40) {
                employee.getInfo();
            }
        }
    }
}
