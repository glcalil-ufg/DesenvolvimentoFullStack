package br.ufg.inf.fsspring.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import br.ufg.inf.fsspring.entities.Hotel;
import br.ufg.inf.fsspring.entities.Quarto;
import br.ufg.inf.fsspring.repositories.QuartoRepository;

@Service
public class QuartoBusiness {
	
	@Autowired
	private QuartoRepository repository;
	
	public List<Quarto> findAll(){
		return repository.findAll();		
	}
	
	public Quarto findById(Integer id) {
		Optional<Quarto> retorno = repository.findById(id);
		return retorno.get();
	}
	
	public Quarto insert(Quarto quarto) {
		return repository.save(quarto);
	}
	
	public Quarto update(Quarto quarto) {
		return repository.save(quarto);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}