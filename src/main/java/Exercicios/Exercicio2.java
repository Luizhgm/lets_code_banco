package Exercicios;

import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Para finalizar operação digite 'sair'");


        String entrada = "";
        String caro = "";
        String barato = "";
        double valorEntrada = 0.0;
        double valorCaro = 0.0;
        double valorBarato = 0.0;


        boolean finalizar = false;
        while(!finalizar){
            System.out.println("Nome do produto:");
            entrada = scanner.nextLine();
            if (entrada.equals("sair")){
                finalizar=true;
            }
            else {
                boolean gotCorrect = false;
                while (!gotCorrect) {
                    try {
                        System.out.printf("Valor do %s\n", entrada);
                        valorEntrada = scanner.nextDouble();
                        scanner.nextLine();
                        break;
                    } catch (Exception e) {
                        scanner.nextLine();
                        System.err.println("Lembre-se que estamos no Brasil, usamos numeros e virgula (,)");
                        continue;
                    }
                }

                if (valorEntrada > valorCaro) {
                    valorCaro = valorEntrada;
                    caro = entrada;
                }
                if ((valorEntrada < valorBarato) || (valorBarato==0.0)) {
                    valorBarato = valorEntrada;
                    barato = entrada;
                }
            }
        }


        System.out.printf("O produto mais caro é %s e custa %f", caro, valorCaro );

        System.out.printf("O produto mais barato é %s e custa %f", barato, valorBarato );

    }
}
