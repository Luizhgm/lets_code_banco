package Exercicios;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysLacosQ5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String palavra="";
        String[] convidados = new String[5];

        boolean gotCorrect = false;
        for (int idx=1; idx<6; idx++){
            gotCorrect = false;
            while(!gotCorrect) {
                System.out.println("Qual o convidado de #" + idx);
                palavra = scanner.nextLine();
                if (palavra.trim().matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$")){
                    gotCorrect=true;
                    convidados[idx-1]=palavra;
                }
                else{
                    System.out.println("Por favor digite o nome de uma convidado");
                }
            }
        }
        Arrays.sort(convidados, (a, b)->Integer.compare(b.length(), a.length()));//a e b inverte a ordem

        System.out.println(Arrays.toString(convidados));

    }
}
