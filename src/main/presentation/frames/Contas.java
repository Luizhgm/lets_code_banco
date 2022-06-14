package presentation.frames;

import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class Contas extends Frame {
    public Contas(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() {
        printFrameTitle("CONTAS");
        System.out.println("1. Abrir conta");
        System.out.println("2. Listar contas");
        System.out.println("3. Acessar conta");
        System.out.println("4. Voltar");
        System.out.println();

        System.out.print("Digite a opção desejada: ");

        int option = this.scanner.nextInt();
        this.scanner.nextLine();

        switch (option) {
            case 1:
                navigator.navigate("abrir-conta");
                break;
            case 2:
                navigator.navigate("listar-contas");
                break;
            case 3:
                navigator.navigate("acessar-conta");
                break;
            case 4:
                navigator.goBack();
                break;
            default:
                break;
        }
    }
}
