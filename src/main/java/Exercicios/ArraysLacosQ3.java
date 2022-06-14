package Exercicios;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysLacosQ3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numeros = new Integer[5];
        int pares=0;
        int numero=0;

        boolean gotCorrect = false;
        for (int idx=0; idx<5; idx++){
            gotCorrect = false;
            while(!gotCorrect) {
                System.out.println("Digite o numero de #" + idx);
                numero= scanner.nextInt();
                scanner.nextLine();
                if (numero%2==0){
                    numeros[4-pares] =numero;
                    pares++;
                    gotCorrect=true;
                }
                else{
                    numeros[idx-pares]=numero;
                    gotCorrect=true;
                }


            }
        }

        System.out.println(Arrays.toString(numeros));
    }
}
