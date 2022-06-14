package Exercicios;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;


public class chapa {

    static int colunas=5;
    static int linhas=6;

    static String formater="%8.2f";

    static  double erro_maximo=1e-3;
    static int iter_maximo=100;
    static double primeira_linha=20;
    static double ultima_linha=20;

    static double primeira_coluna=100;
    static double ultima_coluna=-3;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha qual questão quer responder:");
        int questao = scanner.nextInt();
        scanner.nextLine();

        if (questao==3){
            leitura_dim(scanner);
            leitura_valores(scanner);

        }
        if (questao!=1){
            leitura_condicao(scanner);
            leitura_formato(scanner);
        }


        double[][] chapa =  criar_chapa();

        System.out.println("Chapa que foi montada é: ");
        print_chapa(chapa);

        int interacao=calcula_chapa(chapa);

        System.out.println("Utilizamos "+interacao+" para atingir este ponto.");
        System.out.println("Chapa em equilibrio: ");
        print_chapa(chapa);
    }

    public static void leitura_dim(@org.jetbrains.annotations.NotNull Scanner scanner){
        System.out.println("Numero de colunas");
        colunas = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Numero de linhas");
        linhas = scanner.nextInt();
        scanner.nextLine();

    }

    public static void leitura_valores(@org.jetbrains.annotations.NotNull Scanner scanner) {

        boolean gotCorrect = false;
        while(!gotCorrect) {
            try {
                System.out.println("Valor da primeira linha");
                primeira_linha = scanner.nextDouble();
                scanner.nextLine();
                gotCorrect=true;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Lembre-se que está no Brasil e usamos virgulas");
            }
        }
        gotCorrect=false;
        while(!gotCorrect) {
            try {
                System.out.println("Valor da ultima linha");
                ultima_linha = scanner.nextDouble();
                scanner.nextLine();
                gotCorrect=true;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Lembre-se que está no Brasil e usamos virgulas");
            }

        }
        gotCorrect=false;
        while(!gotCorrect) {
            try {
                System.out.println("Valor da primeira coluna");
                primeira_coluna = scanner.nextDouble();
                scanner.nextLine();
                gotCorrect=true;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Lembre-se que está no Brasil e usamos virgulas");
            }

        }
        gotCorrect=false;
        while(!gotCorrect) {
            try {
                System.out.println("Valor da ultima coluna");
                ultima_coluna = scanner.nextDouble();
                scanner.nextLine();
                gotCorrect=true;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Lembre-se que está no Brasil e usamos virgulas");
            }

        }
    }

    public static void leitura_condicao(@org.jetbrains.annotations.NotNull Scanner scanner){

        boolean gotCorrect = false;
        while(!gotCorrect) {
            try {
                System.out.println("Erro maximo");
                erro_maximo = scanner.nextDouble();
                scanner.nextLine();
                gotCorrect=true;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Lembre-se que está no Brasil e usamos virgulas");
            }
        }
        gotCorrect=false;
        while(!gotCorrect) {
            try {
                System.out.println("Interação maxima");
                iter_maximo = scanner.nextInt();
                scanner.nextLine();
                gotCorrect=true;
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Lembre-se que está no Brasil e usamos virgulas");
            }
        }

    }

    public static void leitura_formato(@org.jetbrains.annotations.NotNull Scanner scanner){
        System.out.println("Casas decimais");
        int decimal = scanner.nextInt();
        scanner.nextLine();


        OptionalInt teste = Arrays.stream((new int[]{String.valueOf(primeira_coluna).length(),
                String.valueOf(ultima_coluna).length(),
                String.valueOf(primeira_linha).length(),
                String.valueOf(ultima_linha).length()})).max();

        formater = "%"+(decimal+teste.getAsInt()+3)+"."+decimal+"f";

    }


    public static double[][] criar_chapa(){
        double[][] chapa = new double[linhas][colunas];
        for (int i=0; i<linhas; i++){
            for (int j=0; j<colunas; j++){
                chapa[i][j]=0.0;
                if (i==0){
                    chapa[i][j]=primeira_linha;
                }
                else if (i==linhas-1){
                    chapa[i][j]=ultima_linha;
                }
                else if (j==0){
                    chapa[i][j]=primeira_coluna;
                }
                else if (j==colunas-1){
                    chapa[i][j]=ultima_coluna;
                }
            }
        }
        return chapa;
    }

    public static void copia_chapa(double[][] chapa, double[][] chapa_nova){
        for (int i=0; i<linhas; i++){
            for (int j=0; j<colunas; j++) {
                chapa_nova[i][j]=chapa[i][j];
            }
        }

    }

    public static double atualizar_chapa(double[][] chapa){
        double [][] chapa_nova= new double[linhas][colunas];
        copia_chapa(chapa, chapa_nova);
        double erro_maximo=0.0;
        double valor_aux=0.0;
        for (int i=1; i<linhas-1; i++){
            for (int j=1; j<colunas-1; j++){
                valor_aux = (chapa_nova[i-1][j]+chapa_nova[i+1][j]+chapa_nova[i][j-1]+chapa_nova[i][j+1])/4;
                if (erro_maximo<Math.abs(valor_aux-chapa[i][j])){
                    erro_maximo = Math.abs(valor_aux-chapa[i][j]);
                }
                chapa[i][j]=valor_aux;
            }
        }
        return erro_maximo;
    }


    public static int calcula_chapa(double[][] chapa){
        double error_maximo=0;
        int interacao=0;
        do {
            error_maximo=atualizar_chapa(chapa);
            interacao++;
        }while (!(error_maximo<erro_maximo | iter_maximo<interacao));
        return interacao;
    }


    public static void print_chapa(double[][] chapa){

        for (int i=0; i<linhas; i++){
            for (int j=0; j<colunas; j++) {
                System.out.printf(formater, chapa[i][j]);
            }
            System.out.println();
        }

    }
}
