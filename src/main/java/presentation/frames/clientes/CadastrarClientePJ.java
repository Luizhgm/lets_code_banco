package presentation.frames.clientes;

import presentation.navigation.Frame;
import presentation.navigation.Navigator;

public class CadastrarClientePJ extends Frame {
    private String nome;
    private String cnpj;

    public CadastrarClientePJ(String key, Navigator navigator) {
        super(key, navigator);
    }

    @Override
    public void render() {
        printFrameTitle("CADASTRAR CLIENTE PESSOA JURÍDICA");
        
        System.out.println();
        System.out.print("Nome: ");
        nome = scanner.nextLine();
        System.out.print("CNPJ: ");
        cnpj = scanner.nextLine();

        // TODO: implementar a criação de um cliente pessoa jurídica

        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("Aperte ENTER para continuar...");

        if(this.scanner.hasNextLine()) {
            this.scanner.nextLine();
            navigator.goBack();
        }
    }
}
