package Servicos;

import Enums.TipoPessoa;
import Model.*;

import java.util.*;
import java.util.stream.Stream;

public class ServicoCliente {
    private static ServicoCliente  ServicoCliente;


    private Map<String, Pessoa> Pessoas = new HashMap<>();
    private Map<String, Cliente> Clientes = new HashMap<>();


    private ServicoCliente() {
    }

    public static synchronized ServicoCliente getInstance() {
        if (ServicoCliente == null)
            ServicoCliente = new ServicoCliente();

        return ServicoCliente;
    }



    public Pessoa CadastrarPessoa(TipoPessoa tipo, String nome, String identificador) throws Exception {
        if (TipoPessoa.PESSOA_JURIDICA.equals(tipo)){
            PessoaJuridica pessoa = new PessoaJuridica(nome, identificador);
            Pessoas.put(pessoa.getCodigoPessoa(), pessoa);
            return pessoa;
        }
        else if (TipoPessoa.PESSOA_FISICA.equals(tipo)){
            PessoaFisica pessoa = new PessoaFisica(nome, identificador);
            Pessoas.put(pessoa.getCodigoPessoa(), pessoa);
            return pessoa;
        }
        throw new Exception("Exception message");
    }

    public Cliente CadastrarCliente(Pessoa pessoa){
        Cliente cliente=new Cliente(pessoa);
        Clientes.put(cliente.getCodigoCliente(), cliente);
        return cliente;
    }



    public void ListarPessoas(){
        Stream<Pessoa> pessoa = Pessoas.values().stream();

        // no futuro sorted no pessoa;

        pessoa.forEach(x->System.out.println(x.printPessoa()));

    };

    public void ListarPessoasFisicas(){
        Stream<Pessoa> pessoa = Pessoas.values().stream().filter(x->x.getPessoa().equals(TipoPessoa.PESSOA_FISICA));

        // no futuro sorted no pessoa;

        pessoa.forEach(x->System.out.println(x.printPessoa()));

    };

    public void ListarPessoasJuridica(){
        Stream<Pessoa> pessoa = Pessoas.values().stream().filter(x->x.getPessoa().equals(TipoPessoa.PESSOA_JURIDICA));

        // no futuro sorted no pessoa;

        pessoa.forEach(x->System.out.println(x.printPessoa()));

    };



    public void ListarClientes(){
        Stream<Cliente> cliente = Clientes.values().stream();

        // no futuro sorted no cliente;

        cliente.forEach(x->System.out.println(x.printCliente()));

    };

    public void ListarClientesFisicos(){
        Stream<Cliente> cliente = Clientes.values().stream().filter(x->x.pessoa.getPessoa().equals(TipoPessoa.PESSOA_FISICA));

        // no futuro sorted no cliente;

        cliente.forEach(x->System.out.println(x.printCliente()));

    };

    public void ListarClientesJuridica(){
        Stream<Cliente> cliente = Clientes.values().stream().filter(x->x.pessoa.getPessoa().equals(TipoPessoa.PESSOA_JURIDICA));

        // no futuro sorted no cliente;

        cliente.forEach(x->System.out.println(x.printCliente()));

    };


    public Pessoa ConsultarPessoa(TipoPessoa tipo, String identificador) throws Exception {

        for (Pessoa pessoa: Pessoas.values()) {

            if (!pessoa.getPessoa().equals(tipo)){
                // Caso o tipo de pessoa seja diferente do tipo da lista
            }
            else if ((TipoPessoa.PESSOA_JURIDICA.equals(tipo) && ((PessoaJuridica) pessoa).getCNPJ().equals(identificador)) ||
                    (TipoPessoa.PESSOA_FISICA.equals(tipo) && ((PessoaFisica) pessoa).getCPF().equals(identificador))) {
                    System.out.println(pessoa.printPessoa());
                    return pessoa;
            }
        }
        throw new Exception("Pessoa não existe");
    }

    public Cliente ConsultarCliente(TipoPessoa tipo, String identificador) throws Exception {
        for (Cliente cliente: Clientes.values()) {

            if (!cliente.pessoa.getPessoa().equals(tipo)){
                // Caso o tipo de pessoa seja diferente do tipo da lista
            }
            else if ((TipoPessoa.PESSOA_JURIDICA.equals(tipo) && ((PessoaJuridica) cliente.pessoa).getCNPJ().equals(identificador)) ||
                    (TipoPessoa.PESSOA_FISICA.equals(tipo) && ((PessoaFisica) cliente.pessoa).getCPF().equals(identificador))) {
                System.out.println(cliente.printCliente());
                return cliente;
            }
        }
        throw new Exception("Cliente não existe");
    }

}
