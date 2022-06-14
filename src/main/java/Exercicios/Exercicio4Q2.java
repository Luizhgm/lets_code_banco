package Exercicios;

import java.util.Scanner;

public class Exercicio4Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[]  array = {"Nathan", "Gabriel", "Nathan", "Matheus", "Roberta"};

        System.out.println("Nome para buscar");
        String input = scanner.nextLine();

        int index = 0;
        int indexStart = -1;
        int indexEnd = -1;

        for (String word : array){
            if (word.equals(input)){
                if (indexStart == -1){
                    indexStart = index;
                }
                else{
                    indexEnd = index;
                }

            }
            index++;
        }

        if (indexStart == -1) {
            System.out.println("Nome não encontrado");
            return;
        }
        System.out.printf("Primeiro indice encontrado foi %s\n", indexStart);
        System.out.printf("Ultimo indice encontrado foi %s", (indexEnd==-1 ? indexStart:indexEnd));
        return;


    }
}
