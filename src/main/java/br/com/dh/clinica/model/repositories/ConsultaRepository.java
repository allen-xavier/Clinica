package br.com.dh.clinica.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.clinica.model.entities.Consulta;

public interface ConsultaRepository extends CrudRepository<Consulta, Integer>{
	
	Consulta findOneByCodigo(int codigo);
	
}
