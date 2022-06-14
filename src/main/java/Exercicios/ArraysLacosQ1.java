package Exercicios;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysLacosQ1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruta="";
        String[] carrinho = new String[5];

        boolean gotCorrect = false;
        for (int idx=1; idx<6; idx++){
            gotCorrect = false;
            while(!gotCorrect) {
                System.out.println("Qual a fruta #" + idx + " no carrinho");
                fruta = scanner.nextLine();
                if (!fruta.isEmpty() & ! fruta.matches("-?(0|[1-9]\\d*)")){
                    gotCorrect=true;
                    carrinho[idx-1]=fruta;
                }
                else{
                    System.out.println("Por favor digite o nome de uma fruta");
                }
            }
        }

        System.out.println(Arrays.toString(carrinho));

    }
}
