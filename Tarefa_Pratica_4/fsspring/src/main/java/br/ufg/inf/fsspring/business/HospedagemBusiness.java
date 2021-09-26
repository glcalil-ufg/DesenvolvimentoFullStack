package br.ufg.inf.fsspring.business;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.ufg.inf.fsspring.entities.Hospedagem;
import br.ufg.inf.fsspring.exceptions.HospedagemException;
import br.ufg.inf.fsspring.repositories.HospedagemRepository;

@Service
public class HospedagemBusiness {
	
	@Autowired
	private HospedagemRepository repository;
	
	public List<Hospedagem> findAll(){
		return repository.findAll();		
	}

	public Page<Hospedagem> paginator(Pageable pageable){
		return repository.findAll(pageable);		
	}

	public List<Hospedagem> findDtCheckin(Date data){
		return repository.findByDtCheckin(data);
	}

	public List<Hospedagem> findDtCheckout(Date data){
		return repository.findByDtCheckout(data);
	}
	
	public Hospedagem findById(Integer id) {
		Optional<Hospedagem> retorno = repository.findById(id);
		return retorno.get();
	}
	
	public Hospedagem insert(Hospedagem hospedagem) throws HospedagemException {
		this.validaHospedagem(hospedagem);
		return repository.save(hospedagem);
	}
	
	public Hospedagem update(Hospedagem hospedagem)throws HospedagemException {
		this.validaHospedagem(hospedagem);
		return repository.save(hospedagem);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private void validaHospedagem(Hospedagem hospedagem) throws HospedagemException {
		if(hospedagem.getDtCheckin() == null) {
			throw new HospedagemException("0128");
		}	
	}
	
}