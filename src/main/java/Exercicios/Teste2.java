package Exercicios;

import java.text.Normalizer;
import java.util.Locale;
import java.util.Scanner;

public class Teste2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite sua palavra");
        String entrada = scanner.nextLine();
        entrada = Normalizer.normalize(entrada.toLowerCase(Locale.ROOT), Normalizer.Form.NFD).toLowerCase(Locale.ROOT).replaceAll("[^\\p{ASCII}]", "");

        System.out.print(entrada.equals(new StringBuilder(entrada).reverse().toString())? "é verdade": "nem é verdade");

    }
}
