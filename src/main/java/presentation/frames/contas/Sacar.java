package presentation.frames.contas;

import java.math.BigDecimal;
import java.util.HashMap;

import Model.Conta;
import Servicos.ServicoConta;
import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class Sacar extends Frame {
    private double valor;
    
    public Sacar(String key, Navigator navigator, HashMap<String, Object> params) {
        super(key, navigator, params);
    }

    @Override
    public void render() throws Exception {
        printFrameTitle("SACAR");
        System.out.print("Digite o valor a ser sacado: ");
        valor = scanner.nextDouble();
        scanner.nextLine();

        ServicoConta servicoConta = ServicoConta.getInstance();

        servicoConta.Sacar(((Conta)this.params.get("conta")), valor);
        
        System.out.println("Saque realizado com sucesso!");
        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
    
}
