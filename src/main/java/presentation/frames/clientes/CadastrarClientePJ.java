package presentation.frames.clientes;

import Enums.TipoPessoa;
import Model.Cliente;
import Servicos.ServicoCliente;
import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class CadastrarClientePJ extends Frame {
    private String nome;
    private String cnpj;

    public CadastrarClientePJ(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() throws Exception {
        printFrameTitle("CADASTRAR CLIENTE PESSOA JURÍDICA");
        
        System.out.println();
        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("CNPJ: ");
        cnpj = scanner.nextLine();

        ServicoCliente servicoCliente=ServicoCliente.getInstance();

        Cliente cliente = servicoCliente.CadastrarCliente(servicoCliente.CadastrarPessoa(TipoPessoa.PESSOA_JURIDICA, nome, cnpj));

        System.out.println("Pessoa Juridica cadastrada, cliente de codigo "+ cliente.getCodigoCliente()+" cadastrado com sucesso!");
        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
}
