package Model;

import Enums.BandeirasCartao;

import java.time.LocalDate;

public class CartaoDeCredito {
    final String nome;
    final String numero;
    final String CVV;
    final LocalDate validade;
    final BandeirasCartao bandeira;

    public CartaoDeCredito(String nome, String numero, String cvv, LocalDate validade, BandeirasCartao bandeira) {
        this.nome = nome;
        this.numero = numero;
        this.CVV = cvv;
        this.validade = validade;
        this.bandeira = bandeira;
    }

    public String getCVV() {
        return CVV;
    }

    public BandeirasCartao getBandeira() {
        return bandeira;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

}
