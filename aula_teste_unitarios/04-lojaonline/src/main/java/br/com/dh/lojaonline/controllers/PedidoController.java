package br.com.dh.lojaonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.lojaonline.model.entities.Pedido;
import br.com.dh.lojaonline.model.repositories.PedidoRepository;

@RestController
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public Iterable<Pedido> getPedido() {
		return pedidoRepository.findAll();
	}
	
	@PostMapping
	public void setPedido(@RequestBody Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
}
