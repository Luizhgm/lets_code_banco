package Exercicios;

import java.util.Scanner;

public class Teste1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nome do aluno");
            String nome = scanner.nextLine();


            double[] note = new double[4];
            double soma = 0;
            for (int i=0; i < 4; i++) {
                System.out.println("Digite a nota de numero "+i);
                note[i] = scanner.nextDouble();
                scanner.nextLine();
                if (note[i]<0 || note[i]>10) {
                    System.out.println("Lembre-se que a nota é de 0 a 10");
                    i--;
                }
                else{
                    soma +=note[i];
                }
            }
            
            System.out.println("A média das notas do "+nome+" foi de "+ soma/4);
        }
}
