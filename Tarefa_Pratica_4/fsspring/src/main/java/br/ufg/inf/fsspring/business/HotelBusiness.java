package br.ufg.inf.fsspring.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;


import br.ufg.inf.fsspring.entities.Hotel;
import br.ufg.inf.fsspring.repositories.HotelRepository;
import br.ufg.inf.fsspring.exceptions.HotelException;

@Service
public class HotelBusiness {
	
	@Autowired
	public HotelRepository repository;
	
	public List<Hotel> findAll(){
		return repository.findAll();		
	}

	public Page<Hotel> paginator(Pageable pageable){
		return repository.findAll(pageable);		
	}


	public List<Hotel> findName(String str){
		return repository.findByNmHotel(str);
	}

	public List<Hotel> findEstelas(Integer qtd){
		return repository.findByQtdEstelas(qtd);
	}
	
	public Hotel findById(Integer id) {
		Optional<Hotel> retorno = repository.findById(id);
		return retorno.get();
	}
	
	public Hotel insert(Hotel hotel) throws HotelException {
		this.validaHotel(hotel);
		return repository.save(hotel);
	}
	
	public Hotel update(Hotel hotel) throws HotelException {
		this.validaHotel(hotel);
		return repository.save(hotel);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private void validaHotel(Hotel hotel) throws HotelException {
		if(hotel.getNmHotel() == null || hotel.getNmHotel().length() == 0) {
			throw new HotelException("0109");
		}
		if(hotel.getQtdEstrelas() < 1 || hotel.getQtdEstrelas() > 5) {
			throw new HotelException("0108");
		}
		if(hotel.getEndereco() == null || hotel.getEndereco().length() == 0) {
			throw new HotelException("0110");
		}
	}
	
}