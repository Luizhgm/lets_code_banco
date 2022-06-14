import Enums.TipoPessoa;
import Model.Pessoa;
import Servicos.ServicoCliente;

public class Cliente {
    public static void main(String[] args) throws Exception {

        ServicoCliente servicoCliente = ServicoCliente.getInstance();

        // Criando pessoa fisica
        servicoCliente.CadastrarPessoa(TipoPessoa.PESSOA_FISICA, "Luiz", "1111");
        Pessoa pessoa = servicoCliente.CadastrarPessoa(TipoPessoa.PESSOA_FISICA, "Henrique", "1112");

        //Criando um Cliente fisico
        servicoCliente.CadastrarCliente(pessoa);

        // Criando pessoa juridica
        servicoCliente.CadastrarPessoa(TipoPessoa.PESSOA_JURIDICA, "Goncalves", "2111");
        pessoa = servicoCliente.CadastrarPessoa(TipoPessoa.PESSOA_JURIDICA, "Miranda", "2112");

        //Criando um Cliente juridico
        servicoCliente.CadastrarCliente(pessoa);

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


        // Consultando pessoas
        System.out.println("Consultar Pessoa Fisica, cpf: 1111");
        servicoCliente.ConsultarPessoa(TipoPessoa.PESSOA_FISICA, "1111");
        System.out.println("Consultar Pessoa Juridica, cpnj: 2112");
        servicoCliente.ConsultarPessoa(TipoPessoa.PESSOA_JURIDICA, "2112");


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


        // Consultando Cliente
        try{

            System.out.println("Consultar Cliente Pessoa Fisica, cpf: 1111 QUE NÃO EXISTE");
            servicoCliente.ConsultarCliente(TipoPessoa.PESSOA_FISICA, "1111");
        }catch (Exception e){
            if (e.getMessage().equals("Cliente não existe")){
                System.out.println("REALMENTE NÃO EXISTIA");
            }
        }


        System.out.println("Consultar Pessoa Juridica, cpnj: 2112");
        servicoCliente.ConsultarCliente(TipoPessoa.PESSOA_JURIDICA, "2112");


    }
}
