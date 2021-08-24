package br.ufg.inf.fsspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fsspring.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}