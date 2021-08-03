public class ContaPoupanca extends Conta {
    private double txCorrecao;

    public double getTxCorrecao() {
        return txCorrecao;
    }
    public void setTxCorrecao(double txCorrecao) {
        this.txCorrecao = txCorrecao;
    }
    public void atualizaSaldoRendimento(){
        System.out.println("Atualiza Saldo Rendimento...");
    }
    @Override
    public void abrirConta(){
        System.out.println("Abrir Conta Poupança...");
    }

}
