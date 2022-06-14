package Exercicios;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;

public class ArraysLacosQ7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> nomesMap = new HashMap<>();
        String Nome="";
        boolean gotCorrect = false;

        for (int idx=0; idx<5; idx++){
            gotCorrect = false;
            while(!gotCorrect) {
                System.out.println("Qual o Nome de #"+idx+" ?");
                Nome = scanner.nextLine();
                if (Nome.trim().matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$")){
                    gotCorrect=true;
                }
                else{
                    System.out.println("Lembre-se que é um nome");
                }
            }

            System.out.println("Digite a idade do "+Nome);
            nomesMap.put(Nome, scanner.nextInt());
            scanner.nextLine();

        }
        Integer soma=nomesMap.values().stream().reduce(0, (subtotal, element) -> subtotal + element);


        Integer maiorIdade=Collections.max(nomesMap.values());
        Integer menorIdade=Collections.min(nomesMap.values());


        System.out.println("Media é "+soma/nomesMap.size());
        System.out.println("Os mais velhos tem "+maiorIdade+" e são os: ");
        nomesMap.entrySet().forEach(entry -> {
            if (maiorIdade.equals(entry.getValue())){
                System.out.println(entry.getKey());
            };
        });
        System.out.println("Os mais velhos tem "+menorIdade+" e são os: ");
        nomesMap.entrySet().forEach(entry -> {
            if (menorIdade.equals(entry.getValue())){
                System.out.println(entry.getKey());
            };
        });


    }

}

