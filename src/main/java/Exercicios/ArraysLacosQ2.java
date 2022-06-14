package Exercicios;

import java.text.Normalizer;
import java.util.Locale;
import java.util.Scanner;

public class ArraysLacosQ2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean gotCorrect = false;
        String palavra = "";
        while(!gotCorrect) {
            System.out.println("Digite a palavra");
            palavra = scanner.nextLine();

            if (palavra.trim().matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$")){
                gotCorrect=true;
            }
            else{
                System.out.println("Por favor lembre-se que é uma palavra é formado apenas por letras, acentos  e espaços");
            }
        }
        System.out.println(new StringBuilder(palavra).reverse().toString());
    }
}
