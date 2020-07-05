package ru.ayupov.task;

/**
 * Добавить в программу "Вендинговый автомат" журналирование событий, при этом стоит указать различные уровни
 * логирования, как информационного уровня, так и предупреждения и ошибки.
 * <p>
 * Настроить сбор логов в файл.
 * <p>
 * Фреймворк логирования - на ваш выбор.
 */


public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.start();

    }
}
