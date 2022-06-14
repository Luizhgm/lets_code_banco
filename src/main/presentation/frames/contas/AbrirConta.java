package presentation.frames.contas;

import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class AbrirConta extends Frame {

    public AbrirConta(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() {
        printFrameTitle("ABRIR CONTA");
        System.out.println("1. Abrir conta poupança");
        System.out.println("2. Abrir conta corrente");
        System.out.println("3. Abrir conta investimento");
        System.out.println("4. Voltar");
        System.out.println();

        System.out.print("Digite a opção desejada: ");

        int option = scanner.nextInt();
        this.scanner.nextLine();

        switch (option) {
            case 1:
                navigator.navigate("abrir-conta-poupanca");
                break;
            case 2:
                navigator.navigate("abrir-conta-corrente");
                break;
            case 3:
                navigator.navigate("abrir-conta-investimento");
                break;
            case 4:
                navigator.goBack();
                break;
            default:
                break;
        }
    }
}
