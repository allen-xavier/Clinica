package br.com.dh.clinica.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.clinica.model.entities.Receita;

public interface ReceitaRepository extends CrudRepository<Receita, Integer>{
	
	Receita findOneById(int Id);
	
}