package br.ufg.inf.fsspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.fsspring.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	public Usuario findByLogin(String login);
}
