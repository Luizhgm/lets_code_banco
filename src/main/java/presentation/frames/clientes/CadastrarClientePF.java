package presentation.frames.clientes;

import Enums.TipoPessoa;
import Model.Cliente;
import Model.Pessoa;
import Servicos.ServicoCliente;
import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class CadastrarClientePF extends Frame {
    private String nome;
    private String cpf;

    public CadastrarClientePF(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() throws Exception {
        printFrameTitle("CADASTRAR CLIENTE PESSOA FÍSICA");
        
        System.out.println();
        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("CPF: ");
        cpf = scanner.nextLine();

        ServicoCliente servicoCliente=ServicoCliente.getInstance();

        Cliente cliente = servicoCliente.CadastrarCliente(servicoCliente.CadastrarPessoa(TipoPessoa.PESSOA_FISICA, nome, cpf));


        System.out.println("Pessoa Fisica cadastrada, cliente de codigo "+ cliente.getCodigoCliente()+" cadastrado com sucesso!");
        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
}
