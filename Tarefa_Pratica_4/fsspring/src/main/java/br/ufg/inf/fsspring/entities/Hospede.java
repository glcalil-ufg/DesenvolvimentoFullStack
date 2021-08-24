package br.ufg.inf.fsspring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_hospede")
public class Hospede {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_hospede")
	private Integer idHospede;

    @Column(name="nm_hospede")
	private String nmHospede;

    @Column(name="cpf")
	private Integer cpf;

    @Column(name="dt_nascimento")
	private Date dtNascimento;

    public Hospede(){
        super();
    }

    public Hospede(Integer idHospede, String nmHospede, Integer cpf, Date dtNascimento){
        super();
        this.idHospede = idHospede;
        this.nmHospede = nmHospede;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
    }

    public Integer getIdHospede(){
        return this.idHospede;
    }

    public void setnmHospede(String nmHospede){
        this.nmHospede = nmHospede;
    }

    public String getNmHospede(){
        return this.nmHospede;
    }

    public void setCpf(Integer cpf){
        this.cpf = cpf;
    }

    public Integer getCpf(){
        return this.cpf;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    public Date getDtNascimento() {
        return this.dtNascimento;    
    }

    @Override
	public String toString() {
		return "Hotel [idHospede=" + idHospede + ", nmHospede=" + nmHospede + ", cpf=" + cpf + ", dtNascimento="
				+ dtNascimento + "]";
	}

    
}
