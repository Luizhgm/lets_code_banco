package Model;

import Enums.TipoPessoa;

public class PessoaJuridica extends Pessoa{
    String razaoSocial;
    String CNPJ;

    public PessoaJuridica(String razaoSocial,
                             String CNPJ) {
        super(TipoPessoa.PESSOA_JURIDICA);
        this.razaoSocial= razaoSocial;
        this.CNPJ= CNPJ;
    }

    @Override
    public String getNomeTratamento(){
        if (this.NomeTratamento==null) {
            return this.razaoSocial.split(" ")[0];
        }
        return this.NomeTratamento;
    }

    @Override
    public String printPessoa() {
        return "Pessoa Juridica \n" +
                "Razão Social: "+this.getRazaoSocial()+"\n"+
                "CNPJ: "+this.getCNPJ()+"\n";
    }

    ;

    public String getRazaoSocial(){
        return this.razaoSocial;
    }

    public String getCNPJ(){
        return this.CNPJ;
    }

}
