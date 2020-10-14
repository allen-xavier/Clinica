package br.com.dh.lojaonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.lojaonline.model.entities.Cliente;
import br.com.dh.lojaonline.model.entities.Endereco;
import br.com.dh.lojaonline.model.repositories.ClienteRepository;
import br.com.dh.lojaonline.model.repositories.EnderecoRepository;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public Iterable<Endereco> getEnderecos() {
		return enderecoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Endereco getEndereco(@PathVariable int id) throws Exception {
		return enderecoRepository.findById(id).orElseThrow(() -> new Exception());
	}
	
	@PostMapping
	public Endereco addEndereco(@RequestBody Endereco endereco) throws Exception {
		Cliente cliente = clienteRepository.findById(endereco.getId_cliente())
				.orElseThrow(() -> new Exception());
		endereco.setCliente(cliente);
		enderecoRepository.save(endereco);
		return endereco;
	}
	
//	delete
//	put
}
