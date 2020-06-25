package ru.ayupov.task;

/**
 * Реализовать программу «Вендинговый автомат», которая позволит:
 * <p>
 * Посмотреть меню напитков;
 * Внести деньги на внутренний счет. Деньги можно только вносить, автомат сдачи не даёт;
 * Выбрать номер напитка и получить его, если на счету достаточно средств. При этом, сумма на внутреннем счёте должна
 * уменьшиться на стоимость выданного напитка.
 * <p>
 * Программа должна обрабатывать следующие ситуации:
 * Пользователь не внес деньги;
 * Пользователь выбрал более дорогой напиток, чем внесено денег;
 * Пользователь выбрал несуществующий номер напитка.
 * Для хранения напитков предлагается использовать enum. У напитка должна быть цена и название.  Для упрощения считаем,
 * что количество напитков не ограничено.
 */


public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.Start();

    }
}
