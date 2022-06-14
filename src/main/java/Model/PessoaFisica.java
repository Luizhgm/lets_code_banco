package Model;

import Enums.TipoPessoa;

public class PessoaFisica extends Pessoa{

    String nome;
    String CPF;


    public PessoaFisica(String nome,
                           String CPF) {
        super(TipoPessoa.PESSOA_FISICA);
        this.nome=nome;
        this.CPF=CPF;
    }

    @Override
    public String getNomeTratamento(){
        if (this.NomeTratamento==null) {
            return this.nome.split(" ")[0];
        }
        return this.NomeTratamento;
    }

    @Override
    public String printPessoa() {
        return "Pessoa Fisica \n" +
                "Nome: "+this.getNome()+"\n"+
                "CPF: "+this.getCPF()+"\n";
    }

    public String getNome(){
        return this.nome;
    }

    public String getCPF(){
        return this.CPF;
    }


}
