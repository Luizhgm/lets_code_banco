package Exercicios;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double cotacao = 0.0;
        Double valor = 0.0;
        while(true) {
            try {
                System.out.println("Cotação dólar");
                cotacao = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (Exception  e) {
                scanner.nextLine();
                System.err.println("Lembre-se que estamos no Brasil, usamos numeros e virgula (,)");
                continue;
            }
        }

        boolean gotCorrect = false;
        while(!gotCorrect){
            try{
                System.out.println("Valor total em dólar");
                valor = scanner.nextDouble();
                scanner.nextLine();
                gotCorrect = true;
            }catch(Exception e){
                scanner.nextLine();
                System.err.println("Lembre-se que estamos no Brasil, usamos numeros e virgula (,)");
                continue;
            }

        }
        System.out.printf("Valor total convertido em reais %.2f R$", valor*cotacao);
    }
}
