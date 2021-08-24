package br.ufg.inf.fsspring.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tb_hospedagem")
public class Hospedagem {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_hospedagem")
	private Integer idHospedagem;

    @Column(name="id_quarto")
	private Integer idQuarto;

    @Column(name="id_hospede")
	private Integer idHospede;

    @Column(name="dt_checkin")
	private Date dtCheckin;

    @Column(name="dt_checkout")
	private Date dtCheckout;

    public Hospedagem() {
        super();
    }

    public Hospedagem(Integer idHospedagem, Integer idQuarto, Integer idHospede, Date dtCheckin, Date dtCheckout){
        super();
        this.idHospedagem = idHospedagem;
        this.idHospede = idHospede;
        this.idQuarto = idQuarto;
        this.dtCheckin = dtCheckin;
        this.dtCheckout = dtCheckout;
    }

    public Integer getIdHospedagem(){
        return this.idHospedagem;
    }

    public Integer getIdQuarto() {
        return this.idQuarto;
    }

    public Integer getIdHospede(){
        return this.idHospede;
    }

    public void setDtCheckin(Date checkin){
        this.dtCheckin = checkin;
    }

    public Date getDtCheckin() {
        return this.dtCheckin;
    }

    public void setDtCheckout(Date checkout){
        this.dtCheckout = checkout;
    }

    public Date getDtCheckout() {
        return this.dtCheckout;
    }

    @Override
	public String toString() {
		return "Hotel [idHospedagem=" + idHospedagem + ", idHospede=" + idHospede + ", idQuarto=" + idQuarto + ", dtCheckin="
				+ dtCheckin + ", dtCheckout=" + dtCheckout + "]";
	}

}
