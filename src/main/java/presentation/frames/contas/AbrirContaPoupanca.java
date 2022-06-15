package presentation.frames.contas;

import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class AbrirContaPoupanca extends Frame {

    public AbrirContaPoupanca(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() {
        printFrameTitle("ABRIR CONTA POUPANÇA");
        
        // TODO: implementar abertura de conta poupança

        System.out.println("Conta poupança aberta com sucesso!");
        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
}
