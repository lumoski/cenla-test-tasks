package task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter cc = new CurrencyConverter();

        System.out.print("Введите вашу валюту (три заглавные буквы): ");
        String fromCurrency = scanner.nextLine();

        System.out.print("Введите количество вашей валюты: ");
        double amount = scanner.nextDouble();

        System.out.println("Результат перевода:");
        System.out.println(cc.convertOneToAll(fromCurrency, amount));
    }

}
