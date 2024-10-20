package task1;

import java.security.SecureRandom;
import java.util.Scanner;

public class ScaffoldGame {

    private static String[] dict = {
            "яблоко", "банан", "вишня", "груша", "апельсин",
            "киви", "персик", "слива", "ананас", "мандарин"
    };

    private int healthPoints;
    private char[] hiddenWord;
    private char[] userWord;

    public ScaffoldGame() {
        setFields();
    }

    private void setFields() {
        SecureRandom rnd = new SecureRandom();

        healthPoints = 3;
        hiddenWord = dict[rnd.nextInt(dict.length)].toCharArray();
        userWord = new char[hiddenWord.length];

        for (int i = 0; i < userWord.length; i++) {
            userWord[i] = '_';
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        String letter;

        System.out.println("Игра ВИСЕЛИЦА началась:\n");

        while (healthPoints > 0) {
            displayWord();
            displayHealth();

            System.out.print("Введите букву или слово: ");
            letter = scanner.next();

            if (letter.length() > 1) {
                if (letter.equals(String.valueOf(hiddenWord)))
                    System.out.println("| Вы победили! |");
                else
                    System.out.println("| Вы проиграли! |");

                setFields();

                return;
            }

            if (String.valueOf(hiddenWord).indexOf(letter.charAt(0)) != -1) {
                System.out.println("\\- Есть такая буква -/");

                for (int i = 0; i < hiddenWord.length; i++) {
                    if (hiddenWord[i] == letter.charAt(0)) {
                        userWord[i] = letter.charAt(0);
                    }
                }
            } else {
                System.out.println("\\- Такой буквы нет -/");

                healthPoints--;
            }

            System.out.println();
        }

        System.out.println("| Вы проиграли! |");
    }

    private void displayWord() {
        System.out.print("Загаданное слово: ");

        for (int i = 0; i < hiddenWord.length; i++) {
            System.out.print(userWord[i] + " ");
        }

        System.out.println();
    }

    private void displayHealth() {
        System.out.print("Количество ваших жизней: ");

        for (int i = 0; i < healthPoints; i++) {
            System.out.print("#");
        }

        System.out.println();
    }

}
