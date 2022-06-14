package Exercicios;

import java.util.*;


public class ArraysLacosQ8 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, double[]> pessoas = new HashMap<>();

        String nome = "";
        double altura=0.0;
        double peso=0.0;
        boolean gotCorrect = false;

        for (int idx = 0; idx < 5; idx++) {
            gotCorrect = false;
            while (!gotCorrect) {
                System.out.println("Qual o Nome de #" + idx + " ?");
                nome = scanner.nextLine();
                if (nome.trim().matches("^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$")) {
                    gotCorrect = true;
                } else {
                    System.out.println("Lembre-se que é um nome");
                }
            }
            gotCorrect=false;
            while (!gotCorrect) {
                try{
                    System.out.println("Digite o peso do " + nome);
                    peso = scanner.nextDouble();
                    scanner.nextLine();
                    gotCorrect = true;
                }
                catch(Exception e){
                    scanner.nextLine();
                    System.out.println("Digite um peso valido para o " + nome);
                }
            }
            gotCorrect=false;
            while (!gotCorrect) {
                try{
                    System.out.println("Digite o altura do " + nome);
                    altura = scanner.nextDouble();
                    scanner.nextLine();
                    gotCorrect = true;
                }
                catch(Exception e){
                    scanner.nextLine();
                    System.out.println("Digite um altura valida para o " + nome);
                }
            }
            pessoas.put(nome, new double[]{peso, altura});

        }
        pessoas.entrySet().forEach(entry -> {
            double imc = entry.getValue()[0]/(Math.pow(entry.getValue()[1],2));
            System.out.println(entry.getKey() + ((imc<=25 & imc>=18.5)? " está no peso ideal":" não está no peso ideal"));
        });
    }
}
