package presentation.frames.contas;

import Enums.TipoConta;
import Enums.TipoPessoa;
import Model.Agencia;
import Model.Conta;
import Servicos.ServicoCliente;
import Servicos.ServicoConta;
import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class AbrirContaPoupanca extends Frame {

    public AbrirContaPoupanca(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() throws Exception {
        printFrameTitle("ABRIR CONTA POUPANÇA");

        System.out.println();

        System.out.println("1. Abrir conta investimento PF");

        System.out.print("Digite a opção desejada: ");

        int option = scanner.nextInt();
        this.scanner.nextLine();


        ServicoConta servicoConta = ServicoConta.getInstance();
        ServicoCliente servicoCliente = ServicoCliente.getInstance();
        Agencia agencia = servicoConta.getInstanceAgencia();

        Conta conta;
        switch (option) {
            case 1:
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                conta = servicoConta.abrirConta(TipoConta.CONTA_POUPANCA,
                        agencia,
                        servicoCliente.ConsultarCliente(TipoPessoa.PESSOA_FISICA, cpf));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }


        System.out.println("Conta poupança "+ conta.getNumero() +"  aberta com sucesso!");
        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
}
