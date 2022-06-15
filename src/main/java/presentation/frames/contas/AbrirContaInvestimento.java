package presentation.frames.contas;

import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class AbrirContaInvestimento extends Frame {
    public AbrirContaInvestimento(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() {
        printFrameTitle("ABRIR CONTA INVESTIMENTO");
        
        // TODO: implementar abertura de conta investimento

        System.out.println("Conta investimento aberta com sucesso!");
        System.out.println("Aperte ENTER para continuar...");
        

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
}
