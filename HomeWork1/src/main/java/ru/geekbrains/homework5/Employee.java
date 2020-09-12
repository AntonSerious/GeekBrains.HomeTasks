package ru.geekbrains.homework5;

public class Employee {
    private String FIO;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    void getInfo(){
        System.out.println("FIO - "+ this.FIO);
        System.out.println("position - "+ this.position);
        System.out.println("email - "+ this.email);
        System.out.println("phone - "+ this.phone);
        System.out.println("salary - "+ this.salary);
        System.out.println("age - "+ this.age);
    }
    public Employee(){
        System.out.println("Объект класса 'Employee' создан, но поля не инициализированы.");

    }
    Employee(String FIO, String position, String email, String phone, int salary, int age){
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    int getAge(){
        return (this.age);
    }
}
