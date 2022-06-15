package presentation.frames.contas;

import java.math.BigDecimal;
import java.util.HashMap;

import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class Depositar extends Frame {
    private BigDecimal valor;

    public Depositar(String key, Navigator navigator, HashMap<String, Object> params) {
        super(key, navigator, params);
    }

    @Override
    public void render() {
        printFrameTitle("DEPOSITAR");
        System.out.print("Digite o valor a ser depositado: ");
        valor = scanner.nextBigDecimal();
        scanner.nextLine();

        // TODO: implementar o lógica de depósito

        System.out.println("Depósito realizado com sucesso!");
        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
    
}
