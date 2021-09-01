package br.ufg.inf.fsspring.repositories;

import java.util.List;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ufg.inf.fsspring.entities.Hospede;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Integer>{

    @Query("SELECT h FROM Hospede h WHERE h.nmHospede LIKE %:str%")
	public List<Hospede> findByNmHospede(@Param("str") String str);

    @Query("SELECT h FROM Hospede h WHERE h.dtNascimento LIKE %:nsc%")
	public List<Hospede> findByDtNascimento(@Param("nsc") Date nsc);

}