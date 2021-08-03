public class Conta {
    private  Pessoa cliente;
    private int nrConta;
    private double saldo;

    
    public Pessoa getCliente() {
        return cliente;
    }
    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }
    public double getSaldo() {
        return saldo;
    }
    public int getNrConta() {
        return nrConta;
    }
    public void abrirConta() {
        System.out.println("Abrir Conta...");
    }
    public void sacar(){
        System.out.println("Sacar...");
    }
    private void debitar(){
        System.out.println("Debitar...");
    }
    protected void temSaldo(){
        System.out.println("Tem saldo...");
    }
    public void depositar() {
        System.out.println("Depositar...");
    }
    public void transferir(){
        System.out.println("Tranferir...");
    }
    
}
