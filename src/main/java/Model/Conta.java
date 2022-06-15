package Model;

import Enums.TipoConta;

import java.util.UUID;

public abstract class Conta {


    private static Integer count = 1 ;
    final private String CodigoConta;
    final private String numero;
    private Agencia agencia;
    private Cliente cliente;
    final private TipoConta tipoConta;


    private double saldo=0.0;
    private double spread=0.0;

    public double getSpread() {
        return spread;
    }

    public void setSpread(double spread) {
        this.spread = spread;
    }


    public Conta(Agencia agencia, Cliente cliente, TipoConta tipoConta) {
        this.tipoConta = tipoConta;
        this.CodigoConta = "8" + UUID.randomUUID().toString();
        this.numero = String.format("8%05d", count) ;
        this.agencia = agencia;
        this.cliente = cliente;
        count++;

    }

    public Cliente getCliente(){return this.cliente;}

    public String printConta(){
        return "Conta do tipo: "+this.tipoConta+ "\n"+
                "Conta de numero: "+this.numero+ "\n"+
                "Agencia numero: "+this.agencia.getNumero()+ "\n"+
                this.cliente.printCliente();
    }

    public TipoConta getTipoConta(){
        return tipoConta;
    };

    public String getCodigoConta() {
        return CodigoConta;
    }

    public String getNumero() {
        return numero;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public abstract void transferencia(Conta conta, double Valor) throws Exception;
    public abstract void saque(double Valor) throws Exception;
    public abstract void deposito(double Valor);
    public abstract void remuneracao();
    public abstract String printContaDetalhada();


}
