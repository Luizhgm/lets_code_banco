import Enums.TipoPessoa;
import Model.Cliente;
import Model.Pessoa;
import Servicos.ServicoCliente;

public class ClienteServer {
    public static void main(String[] args) throws Exception {

        ServicoCliente servicoCliente = ServicoCliente.getInstance();
        criarPessoasFisica(servicoCliente);
        criarPessoasJuridica(servicoCliente);
        listarPessoas(servicoCliente);
        consultarPessoas(servicoCliente);
        listarCliente(servicoCliente);


        // Consultando Cliente
        try {

            System.out.println("Consultar Cliente Pessoa Fisica, cpf: 1111 QUE NÃO EXISTE");
            servicoCliente.ConsultarCliente(TipoPessoa.PESSOA_FISICA, "1111");
        } catch (Exception e) {
            if (e.getMessage().equals("Cliente não existe")) {
                System.out.println("REALMENTE NÃO EXISTIA");
            }
        }


        System.out.println("Consultar Pessoa Juridica, cpnj: 2112");
        servicoCliente.ConsultarCliente(TipoPessoa.PESSOA_JURIDICA, "2112");


    }

    public static Cliente criarPessoasFisica(ServicoCliente servicoCliente) throws Exception {
        // Criando pessoa fisica
        servicoCliente.CadastrarPessoa(TipoPessoa.PESSOA_FISICA, "Luiz", "1111");
        Pessoa pessoa = servicoCliente.CadastrarPessoa(TipoPessoa.PESSOA_FISICA, "Henrique", "1112");

        //Criando um Cliente fisico
        return servicoCliente.CadastrarCliente(pessoa);
    }

    public static Cliente criarPessoasJuridica(ServicoCliente servicoCliente) throws Exception {

        // Criando pessoa juridica
        servicoCliente.CadastrarPessoa(TipoPessoa.PESSOA_JURIDICA, "Goncalves", "2111");
        Pessoa pessoa = servicoCliente.CadastrarPessoa(TipoPessoa.PESSOA_JURIDICA, "Miranda", "2112");

        //Criando um Cliente juridico
        return servicoCliente.CadastrarCliente(pessoa);
    }

    public static void listarPessoas(ServicoCliente servicoCliente) {

        // Listando pessoas
        System.out.println("listar Pessoas:");
        servicoCliente.ListarPessoas();
        System.out.println("---- Fim do listar Pessoas ----\n");

        System.out.println("Pessoas Juridicas:");
        servicoCliente.ListarPessoasJuridica();
        System.out.println("---- Fim do listar Pessoas Juridicas ----\n");

        System.out.println("Pessoas Fisica:");
        servicoCliente.ListarPessoasFisicas();
        System.out.println("---- Fim do listar Pessoas Fisica ----\n");

    }

    public static void consultarPessoas(ServicoCliente servicoCliente) throws Exception {
        // Consultando pessoas
        System.out.println("Consultar Pessoa Fisica, cpf: 1111");
        servicoCliente.ConsultarPessoa(TipoPessoa.PESSOA_FISICA, "1111");
        System.out.println("Consultar Pessoa Juridica, cpnj: 2112");
        servicoCliente.ConsultarPessoa(TipoPessoa.PESSOA_JURIDICA, "2112");

    }

    public static void listarCliente(ServicoCliente servicoCliente) throws Exception {

        // Listando pessoas
        System.out.println("listar Clientes:");
        servicoCliente.ListarClientes();
        System.out.println("---- Fim do Cliente ----\n");

        System.out.println("listar Clientes Fisica:");
        servicoCliente.ListarClientesFisicos();
        System.out.println("---- Fim do Cliente Fisica ----\n");

        System.out.println("listar Clientes Juridica:");
        servicoCliente.ListarClientesJuridica();
        System.out.println("---- Fim do Cliente Juridica ----\n");
    }
}
