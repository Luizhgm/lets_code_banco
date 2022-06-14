package Exercicios;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double valor1, valor2, resultado = 0.0;

        String caracter="";

        boolean gotCorrect = false;
        while(!gotCorrect){
            System.out.println("Operação");
            caracter = scanner.nextLine();

            if (caracter.equals("somar") ||
                    caracter.equals("subtrair") ||
                    caracter.equals("multiplicar") ||
                    caracter.equals("dividir")) {
                gotCorrect = true;
            }
            else{
                System.err.println("Lembre-se que as operações são (somar, subtrair, multiplicar ou dividir)");
            }
        }


        while(true) {
            try {
                System.out.println("Número 1");
                valor1 = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (Exception  e) {
                scanner.nextLine();
                System.err.println("Número 1 (,)");
                continue;
            }
        }
        while(true) {
            try {
                System.out.println("Número 2");
                valor2 = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (Exception  e) {
                scanner.nextLine();
                System.err.println("Número 2(,)");
                continue;
            }
        }


        if (caracter.equals("multiplicar ")){
            resultado=valor1*valor2;
        }
        else if (caracter.equals("somar")){
            resultado=valor1+valor2;
        }
        else if (caracter.equals("subtrair")){
            resultado=valor1-valor2;
        }
        else if (caracter.equals("dividir")){
            resultado=valor1/valor2;
        }

        System.out.printf("Resultado da operaçao %f", resultado);
    }

}
