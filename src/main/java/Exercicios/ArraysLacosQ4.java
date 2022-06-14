package Exercicios;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysLacosQ4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maior=0;
        int menor=0;
        int soma=0;
        int numero=0;

        boolean gotCorrect = false;
        for (int idx=0; idx<5; idx++){
            System.out.println("Digite o numero de #" + idx);
            numero= scanner.nextInt();
            scanner.nextLine();
            soma +=numero;
            if (idx==0){
                maior=numero;
                menor=numero;
            }
            else if (maior<numero) maior=numero;
            else if (menor>numero) menor=numero;

        }


        System.out.println("media é "+soma/5);
        System.out.println("maior é "+maior);
        System.out.println("menor é "+menor);
    }
}
