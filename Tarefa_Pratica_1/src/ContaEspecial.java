public class ContaEspecial extends Conta{
    private double limite;

    public double getLimite() {
        return limite;
    }
    public void setLimite(double limite) {
        this.limite = limite;
    }
    @Override
    protected void temSaldo(){
        System.out.println("Tem Saldo Especial...");
    }
    @Override
    public void abrirConta(){
        System.out.println("Abrir Conta Especial...");
    }
    
}
