package br.ufg.inf.fsspring.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufg.inf.fsspring.business.HospedeBusiness;
import br.ufg.inf.fsspring.entities.Hospede;

@RestController
@RequestMapping(value="hospedes")
public class HospedeCtrl {

	@Autowired
	private HospedeBusiness business;
	
	@GetMapping
	public ResponseEntity<List<Hospede>> findAll(){
		List<Hospede> list = business.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hospede> findById(@PathVariable Integer id){
		Hospede retorno = business.findById(id);
		return ResponseEntity.ok(retorno);
	}
	
	@PostMapping
	public ResponseEntity<Hospede> insert(@RequestBody Hospede Hospede){
		Hospede = business.insert(Hospede);
		return ResponseEntity.ok(Hospede);
	}
	
	@PutMapping
	public ResponseEntity<Hospede> update(@RequestBody Hospede Hospede){
		Hospede = business.update(Hospede);
		return ResponseEntity.ok(Hospede);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		business.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}