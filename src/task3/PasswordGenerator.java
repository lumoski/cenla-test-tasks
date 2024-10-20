package task3;

import java.security.SecureRandom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    /**
     *  It takes values from 8 to 12.
     *  The default value is 10.
     */
    private int passwordLength = 10;

    public int getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(int passwordLength) {
        if (passwordLength >= 8 && passwordLength <= 12) {
            this.passwordLength = passwordLength;
        }
    }

    public PasswordGenerator(int passwordLength) {
        setPasswordLength(passwordLength);
    }

    public String generatePassword() {
        StringBuilder sb = new StringBuilder(passwordLength);
        SecureRandom rnd = new SecureRandom();

        sb.append(UPPERCASE.charAt(rnd.nextInt(UPPERCASE.length())));
        sb.append(LOWERCASE.charAt(rnd.nextInt(LOWERCASE.length())));
        sb.append(DIGITS.charAt(rnd.nextInt(DIGITS.length())));
        sb.append(SPECIAL_CHARACTERS.charAt(rnd.nextInt(SPECIAL_CHARACTERS.length())));

        String allCharacters = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
        for (int i = 4; i < passwordLength; i++) {
            sb.append(allCharacters.charAt(rnd.nextInt(allCharacters.length())));
        }

        return shufflePassword(sb.toString());
    }

    private String shufflePassword(String passwordString) {
        List<Character> characters = new ArrayList<>();
        for (char c : passwordString.toCharArray()) {
            characters.add(c);
        }

        Collections.shuffle(characters);

        StringBuilder shuffledString = new StringBuilder();
        for (char c : characters) {
            shuffledString.append(c);
        }

        return shuffledString.toString();
    }

}
