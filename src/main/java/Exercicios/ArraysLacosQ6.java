package Exercicios;

import java.util.Scanner;

public class ArraysLacosQ6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String palavra="";
        boolean gotCorrect = false;
        while(!gotCorrect) {
            System.out.println("Qual a palavra?");
            palavra = scanner.nextLine();
            if (palavra.trim().matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$")){
                gotCorrect=true;
            }
            else{
                System.out.println("Por favor digite uma palavra");
            }
        }
        char[] letras= palavra.toCharArray();

        for (int idx=1; idx<palavra.length()+1; idx++) {

            if (idx%2!=0){
                System.out.print( Character.toUpperCase(letras[idx-1]));
            }
            else{
                System.out.print(letras[idx-1]);
            }
        }

        System.out.println();

    }
}
