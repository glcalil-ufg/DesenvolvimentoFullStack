package br.ufg.inf.fsspring.repositories;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufg.inf.fsspring.entities.Hospedagem;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem, Integer>{

    @Query("SELECT h FROM Hospedagem h WHERE h.dtCheckin LIKE %:dtc%")
	public List<Hospedagem> findByDtCheckin(@Param("dtc") Date dtc);

    @Query("SELECT h FROM Hospedagem h WHERE h.dtCheckout LIKE %:dtc%")
	public List<Hospedagem> findByDtCheckout(@Param("dtc") Date dtc);
}