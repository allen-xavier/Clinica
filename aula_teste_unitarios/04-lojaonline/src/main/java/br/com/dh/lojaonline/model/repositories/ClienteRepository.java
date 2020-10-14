package br.com.dh.lojaonline.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.lojaonline.model.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
	List<Cliente> findByCpfContaining(String cpf);

	Cliente findOneByNome(String nome);

	Cliente findOneByCpf(String nome);
}
