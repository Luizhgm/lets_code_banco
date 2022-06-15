package presentation.frames.contas;

import Model.Conta;
import Servicos.ServicoConta;
import presentation.navigation.Frame;
import presentation.navigation.Navigator;

import java.util.HashMap;

public class Desinvestimento extends Frame {
    private double valor;

    public Desinvestimento(String key, Navigator navigator, HashMap<String, Object> params) {
        super(key, navigator, params);
    }

    @Override
    public void render() throws Exception {
        printFrameTitle("Desinvestimento");
        System.out.print("Digite o valor a ser Desinvestimento: ");
        valor = scanner.nextDouble();
        scanner.nextLine();

        ServicoConta servicoConta = ServicoConta.getInstance();

        servicoConta.Desinvestir(((Conta)this.params.get("conta")), valor);

        System.out.println("Desinvestimento realizado com sucesso!");
        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
    
}
