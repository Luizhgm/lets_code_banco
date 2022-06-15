package Model;

import Enums.TipoConta;
import Enums.TipoPessoa;

public class ContaInvestimento extends Conta {
    private double valorInvestido=0;


    public ContaInvestimento(Agencia agencia, Cliente cliente) {
        super(agencia, cliente, TipoConta.CONTA_INVESTIMENTO);
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    @Override
    public void transferencia(Conta conta, double Valor) throws Exception {
        if (conta==null){
            throw new Exception("Conta não existe");
        }
        else if (this.getSaldo()<Valor){
            throw new Exception("Saldo insuficiente");
        }

        this.setSaldo(this.getSaldo()-Valor);
        conta.setSaldo(conta.getSaldo()+Valor);

    }

    @Override
    public void saque(double Valor) throws Exception {
        if (this.getSaldo()<Valor){
            throw new Exception("Saldo insuficiente");
        }
        this.setSaldo(this.getSaldo()-Valor);

    }

    @Override
    public void deposito(double Valor) {
        this.setSaldo(this.getSaldo()+Valor);

    }

    @Override
    public void remuneracao() {
        //CDI+2 em porcentagem (/100) e diario (/365)
        double taxa = Math.max(MacroEconomia.getInstance().getCDI(), MacroEconomia.getInstance().getIPCA());
        if (this.getCliente().getPessoa().getPessoa().equals(TipoPessoa.PESSOA_JURIDICA)){
            taxa+=2;
        }
        taxa=(1+(taxa)/100/365);

        this.setValorInvestido(this.getValorInvestido()*taxa);
    }

    public void investir(double Valor) throws Exception {
        if (this.getSaldo()<Valor){
            throw new Exception("Saldo insuficiente");
        }
        this.setSaldo(this.getSaldo()-Valor);
        this.setValorInvestido(this.getValorInvestido()+Valor);

    }
    public void desinvestir(double Valor) throws Exception {
        if (this.getValorInvestido()<Valor){
            throw new Exception("Saldo investido insuficiente");
        }
        this.setSaldo(this.getSaldo()+Valor);
        this.setValorInvestido(this.getValorInvestido()-Valor);

    }

    @Override
    public String printContaDetalhada() {
        return "Conta do tipo: "+this.getTipoConta()+ "\n"+
                this.getCliente().printCliente()+
                "Conta de numero: "+this.getNumero()+ "\n"+
                "Agencia numero: "+this.getAgencia()+ "\n"+
                "Saldo: "+this.getSaldo()+ "\n"+
                "Valor investido: "+ this.valorInvestido;
    }

}
