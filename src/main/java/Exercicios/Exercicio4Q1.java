package Exercicios;

import java.util.Scanner;

public class Exercicio4Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[]  array = {"Nathan", "Gabriel", "Matheus", "Roberta"};

        System.out.println("Nome para buscar");
        String input = scanner.nextLine();

        for (String word : array){
            if (word.equals(input)){
                System.out.println("Nome encontrado");
                return ;
            }
        }
        System.out.println("Nome não encontrado");
        return ;
    }
}
