package Exercicios;

import java.util.Arrays;
import java.util.Scanner;

public class Exercicio4Q3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String  array[] = {"Nathan", "Gabriel", "Matheus", "Roberta"};

        System.out.println(Arrays.toString(array));
        System.out.println("Nome para buscar");
        String input = scanner.nextLine();

        System.out.printf(" Novo array é : %s",
                Arrays.toString(Arrays.stream(array).filter(x->!x.equals(input)).toArray(String[]::new)));

    }
}
