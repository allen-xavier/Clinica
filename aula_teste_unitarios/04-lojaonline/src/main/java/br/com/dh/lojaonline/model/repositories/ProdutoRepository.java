package br.com.dh.lojaonline.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.lojaonline.model.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
	Produto findByNome(String nome);
	
	List<Produto> findByNomeContaining(String ano);
	
	List<Produto> findByEstoque(Integer quantidade);

	Produto findOneByNome(String nome);
}
