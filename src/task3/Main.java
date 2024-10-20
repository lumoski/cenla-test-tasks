package task3;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int passwordLength;

        do {
            System.out.print("Введите длину пароля (от 8 до 12 символов): ");
            passwordLength = scanner.nextInt();
        } while (passwordLength < 8 || passwordLength > 12);

        scanner.close();

        PasswordGenerator pg = new PasswordGenerator(passwordLength);

        String password = pg.generatePassword();
        System.out.println("Длина вашего пароля: " + pg.getPasswordLength());
        System.out.println("Сгенерированный пароль: " + password);
    }

}
