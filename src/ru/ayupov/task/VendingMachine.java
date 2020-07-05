package ru.ayupov.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class VendingMachine {
    private static final Logger log = LogManager.getLogger(VendingMachine.class);

    private static int balance;
    private Scanner scn = new Scanner(System.in);

    public void start() {
        log.trace("запуск вендинга");
        this.mainMenu();
    }


    private void mainMenu() {

        log.trace("переход в главное меню");

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
                    log.trace("выход");
                    break;
            }
        } else {
            incorrectValue();
            mainMenu();
        }
    }

    private void drinksMenu() {
        log.trace("переход в меню напитков");
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

                    log.warn("Недостаточно средств");

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
        log.error("Введено некорректное значение. Пожалуйста повторите попытку");
    }
}
