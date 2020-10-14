package br.com.dh.lojaonline.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.lojaonline.model.entities.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

}
