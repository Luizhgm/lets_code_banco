package Model;

import java.util.UUID;

public class Cliente {
    final String CodigoCliente;
    public Pessoa pessoa;



    public Cliente(Pessoa pessoa) {
        this.CodigoCliente = "8" + UUID.randomUUID().toString();
        this.pessoa = pessoa;
    }

    public String printCliente() {
        return "Cliente \n"+
                this.pessoa.printPessoa();
    }

    public String getCodigoCliente() {
        return CodigoCliente;
    }
}
