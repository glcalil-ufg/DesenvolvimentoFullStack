package br.ufg.inf.fsspring.business;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.fsspring.entities.Hospede;
import br.ufg.inf.fsspring.exceptions.HospedeException;
import br.ufg.inf.fsspring.repositories.HospedeRepository;

@Service
public class HospedeBusiness {
	
	@Autowired
	private HospedeRepository repository;
	
	public List<Hospede> findAll(){
		return repository.findAll();		
	}
	
	public Hospede findById(Integer id) {
		Optional<Hospede> retorno = repository.findById(id);
		return retorno.get();
	}

	public List<Hospede> findName(String str){
		return repository.findByNmHospede(str);
	}

	public List<Hospede> findNascimento(Date data){
		return repository.findByDtNascimento(data);
	}
	
	public Hospede insert(Hospede hospede) throws HospedeException {
		this.validaHospede(hospede);
		return repository.save(hospede);
	}
	
	public Hospede update(Hospede hospede) throws HospedeException {
		this.validaHospede(hospede);
		return repository.save(hospede);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private void validaHospede(Hospede hospede) throws HospedeException {
		if(hospede.getNmHospede() == null || hospede.getNmHospede().length() == 0) {
			throw new HospedeException("0118");
		}
		if(hospede.getCpf() == null || hospede.getCpf() == 0) {
			throw new HospedeException("0119");
		}
		if(hospede.getDtNascimento() == null) {
			throw new HospedeException("0120");
		}
	}
	
}
