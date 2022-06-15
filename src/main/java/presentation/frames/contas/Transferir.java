package presentation.frames.contas;

import java.math.BigDecimal;
import java.util.HashMap;

import Model.Agencia;
import Model.Conta;
import Servicos.ServicoConta;
import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class Transferir extends Frame {
    private double valor;
    private String codigoContaDestino;

    public Transferir(String key, Navigator navigator, HashMap<String, Object> params) {
        super(key, navigator, params);
    }

    @Override
    public void render() throws Exception {
        printFrameTitle("TRANSFERIR");
        
        System.out.print("Digite o valor a ser transferido: ");
        valor = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.println("Digite o código da conta destino: ");
        codigoContaDestino = scanner.nextLine();

        ServicoConta servicoConta = ServicoConta.getInstance();
        Agencia agencia = servicoConta.getInstanceAgencia();


        servicoConta.Transferir(((Conta)this.params.get("conta")),
                servicoConta.ConsultarConta(codigoContaDestino, agencia.getNumero()),
                valor);

        System.out.println("Transferência realizada com sucesso!");
        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
    
}
