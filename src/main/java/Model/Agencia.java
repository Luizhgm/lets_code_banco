package Model;

public class Agencia {
    final String numero;
    public String nome;

    public Agencia(String codigo, String nome) {
        this.numero = codigo;
        this.nome = nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }


}
