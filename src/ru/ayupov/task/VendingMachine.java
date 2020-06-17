package ru.ayupov.task;

import java.util.Scanner;

public class VendingMachine {
    private static int balance;
    private Scanner scn = new Scanner(System.in);

    public VendingMachine() {
        this.mainMenu();
    }

    private void mainMenu() {

        System.out.println("Введите номер команды:");
        System.out.println("1. Посмотреть меню");
        System.out.println("2. Внести деньги");
        System.out.println("3. Выйти из программы");

        int commandNum = scn.nextInt();

        if (commandNum > 0 && commandNum <= 3) {
            switch (commandNum) {
                case 1:
                    drinksMenu();
                    break;
                case 2:
                    addMoney();
                    break;
                case 3:
                    break;
            }
        } else {
            incorrectValue();
            mainMenu();
        }
    }

    private void drinksMenu() {
        System.out.println("Выберите напиток и введите его номер");
        for (Drinks drink : Drinks.values()) {
            System.out.println((drink.ordinal() + 1) + ". " + drink.title + " " + drink.price + " руб.");
        }

        int drinkNum = scn.nextInt();

        if (drinkNum > 0 && drinkNum <= Drinks.length()) {
            getDrink(drinkNum - 1);
        } else {
            incorrectValue();
            drinksMenu();
        }
    }

    private void getDrink(int drinkNum) {
        for (Drinks drink : Drinks.values()) {
            if (drink.ordinal() == drinkNum) {
                if (drink.price > balance) {

                    System.out.println("Недостаточно средств");

                    printBalance();
                    mainMenu();
                } else {
                    System.out.println("Получите " + drink.title);

                    removeMoney(drink.price);

                    printBalance();
                    mainMenu();
                }
            }
        }
    }

    private void addMoney() {
        System.out.println("Введите сумму внесенных денег");

        int money = scn.nextInt();

        if (money > 0) {
            balance += money;
            printBalance();
            mainMenu();
        } else {
            incorrectValue();
            addMoney();
        }
    }

    private int getBalance() {
        return balance;
    }

    private void printBalance() {
        System.out.println("Ваш баланс " + getBalance());
    }

    private void removeMoney(int removeSum) {
        balance -= removeSum;
    }

    private void incorrectValue() {
        System.out.println("Введено некорректное значение. Пожалуйста повторите попытку");
    }
}
