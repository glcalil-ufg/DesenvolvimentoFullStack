import java.util.Calendar;

public class PessoaFisica extends Pessoa{
    private int cpf;
    private Calendar dtNascimento;
    private String genero;
    

    public int getCpf() {
        return cpf;
    }
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Calendar getDtNascimento() {
        return dtNascimento;
    }
    public void setDtNascimento(Calendar dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    public void getIdade(){
        System.out.println("Idade...");
    }
}
