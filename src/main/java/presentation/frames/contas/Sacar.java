package presentation.frames.contas;

import java.math.BigDecimal;
import java.util.HashMap;

import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class Sacar extends Frame {
    private BigDecimal valor;
    
    public Sacar(String key, Navigator navigator, HashMap<String, Object> params) {
        super(key, navigator, params);
    }

    @Override
    public void render() {
        printFrameTitle("SACAR");
        System.out.print("Digite o valor a ser sacado: ");
        valor = scanner.nextBigDecimal();
        scanner.nextLine();

        // TODO: implementar o lógica de saque
        
        System.out.println("Saque realizado com sucesso!");
        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
    
}
