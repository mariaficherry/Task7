package utils;

import java.util.Random;

public class RandomUtils {
    public static String createRandomPassword() {
        String upper = "ABCDEFGHIJKLMNOPQRSTuvWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String emailLetter = "m";
        String num = "0123456789";
        String combination = upper + lower + emailLetter + num;
        int length = 13;
        char[] password = new char[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            password[i] = combination.charAt(r.nextInt(combination.length()));
        }
        return String.valueOf(password);
    }

    public static String createRandomEmail() {
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String num = "0123456789";
        String letterFromEmail = "mar";
        String combination = lower + num;
        int length = 8;
        char[] password = new char[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            password[i] = combination.charAt(r.nextInt(combination.length()));
        }
        return letterFromEmail + String.valueOf(password);
    }

    public static String createRandomDomain() {
        String[] domains = {"gmail", "aol", "somethingelse"};
        return domains[new Random().nextInt(domains.length)];
    }
}