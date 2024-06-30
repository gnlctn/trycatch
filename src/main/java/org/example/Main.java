package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Lütfen bir giriş yapın: ");
            String input = scanner.nextLine();
            klavyegirisi(input);
            System.out.println("Giriş doğru: " + input);

        } catch (CustomException e){
            System.out.println("Hata: " + e.getMessage());
        }
    }

    public static void klavyegirisi(String input) throws CustomException {
        if (input.length() != 1) {
            throw new CustomException("Lütfen sadece bir karakter girişi yapınız: ");
        }

        char karakter = input.charAt(0);

        if (Character.isLetter(karakter)) {
            throw new CustomException("Hata: Harf girdiniz,lütfen rakam giriniz");
        } else {
            try {
                int sayi = Integer.parseInt(input);
                if (sayi < 0) {
                    throw new CustomException("Hata: Pozitif rakam girmelisiniz.");
                }
            } catch (NumberFormatException e) {
                throw new CustomException("Geçersiz giriş,lütfen rakam giriniz");
            }
        }
    }
}