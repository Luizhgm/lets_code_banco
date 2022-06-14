package Model;

import Enums.TipoPessoa;

import java.util.UUID;

public abstract class Pessoa {


    final String CodigoPessoa;
    public String NomeTratamento;
    public TipoPessoa tipo;

    protected Pessoa(TipoPessoa tipo) {
        if (tipo == TipoPessoa.PESSOA_FISICA) {

            this.CodigoPessoa = "0" + UUID.randomUUID().toString();
        }
        else{
            this.CodigoPessoa = "1" + UUID.randomUUID().toString();
        }
        this.tipo = tipo;
    }

    public TipoPessoa getPessoa(){
        return this.tipo;
    };

    public String getCodigoPessoa(){
        return this.CodigoPessoa;
    };

    protected String getNomeTratamento(){
        return this.NomeTratamento;
    };

    protected void setNomeTratamento(String nomeTratamento){
        this.NomeTratamento=nomeTratamento;
    }

    public abstract String printPessoa();


}
