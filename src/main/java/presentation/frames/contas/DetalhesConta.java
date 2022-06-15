package presentation.frames.contas;

import java.util.HashMap;

import Model.Conta;
import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class DetalhesConta extends Frame {

    public DetalhesConta(String key, Navigator navigator, HashMap<String, Object> params) {
        super(key, navigator, params);
    }

    @Override
    public void render() {
        printFrameTitle("DETALHES DA CONTA");
        
        Conta conta = (Conta) this.params.get("conta");
        System.out.println("Codigo da agencia: "+ conta.getAgencia().getNumero());
        System.out.println("Codigo da conta: "+ conta.getNumero());
        System.out.println("Tipo de conta: "+ conta.getTipoConta());
        System.out.println("Nome do cliente: " + conta.getCliente().getPessoa().getPessoa());
        System.out.println();

        System.out.println("1. Saque");
        System.out.println("2. Depósito");
        System.out.println("3. Transferência");
        System.out.println("4. Investir");
        System.out.println("5. Desinvestir");
        System.out.println("6. Voltar");

        System.out.println();
        System.out.print("Digite a opção desejada: ");

        int option = this.scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                this.navigator.navigate("sacar", this.params);
                break;
            case 2:
                this.navigator.navigate("depositar", this.params);
                break;
            case 3:
                this.navigator.navigate("transferir", this.params);
                break;
            case 6:
                this.navigator.goBack();
                break;
            default:
                break;
        }
    }
    
}
