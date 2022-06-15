package presentation.frames.contas;

import Enums.TipoConta;
import Enums.TipoPessoa;
import Model.Agencia;
import Model.Conta;
import Servicos.ServicoCliente;
import Servicos.ServicoConta;
import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class AbrirContaCorrente extends Frame {
    public AbrirContaCorrente(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() throws Exception {
        printFrameTitle("ABRIR CONTA CORRENTE");

        System.out.println();

        System.out.println("1. Abrir conta corrente PF");
        System.out.println("2. Abrir conta corrente PJ");

        System.out.print("Digite a opção desejada: ");

        int option = scanner.nextInt();
        this.scanner.nextLine();


        ServicoConta servicoConta = ServicoConta.getInstance();
        ServicoCliente servicoCliente = ServicoCliente.getInstance();
        Agencia agencia = servicoConta.getInstanceAgencia();

        switch (option) {
            case 1:
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                servicoConta.abrirConta(TipoConta.CONTA_CORRENTE,
                        agencia,
                        servicoCliente.ConsultarCliente(TipoPessoa.PESSOA_FISICA, cpf));
                break;
            case 2:
                System.out.print("CNPJ: ");
                String cnpj = scanner.nextLine();
                servicoConta.abrirConta(TipoConta.CONTA_CORRENTE,
                        agencia,
                        servicoCliente.ConsultarCliente(TipoPessoa.PESSOA_JURIDICA, cnpj));
                break;
        }

        System.out.println("Conta corrente aberta com sucesso!");
        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
}
