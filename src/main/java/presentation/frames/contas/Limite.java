package presentation.frames.contas;

import Model.Conta;
import Servicos.ServicoConta;
import presentation.navigation.Frame;
import presentation.navigation.Navigator;

import java.util.HashMap;

public class Limite extends Frame {
    private double valor;

    public Limite(String key, Navigator navigator, HashMap<String, Object> params) {
        super(key, navigator, params);
    }

    @Override
    public void render() throws Exception {
        printFrameTitle("Limite");
        System.out.print("Digite o valor do novo Limite: ");
        valor = scanner.nextDouble();
        scanner.nextLine();

        ServicoConta servicoConta = ServicoConta.getInstance();

        servicoConta.MudarLimite(((Conta)this.params.get("conta")), valor);

        System.out.println("Limite atualizado com sucesso!");
        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
    
}
