package br.com.dh.lojaonline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.lojaonline.model.entities.Cliente;
import br.com.dh.lojaonline.model.entities.Telefone;
import br.com.dh.lojaonline.model.repositories.ClienteRepository;
import br.com.dh.lojaonline.model.repositories.TelefoneRepository;

@RestController
@RequestMapping("telefone")
public class TelefoneController {
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public Iterable<Telefone> getTelefone() {
		return telefoneRepository.findAll();
	}
	
	@PostMapping
	public Telefone addTelefone(@RequestBody Telefone telefone)
			throws Exception{
		Cliente cliente = clienteRepository.findById(telefone.getId_cliente())
			.orElseThrow(() -> new Exception());
		telefone.setCliente(cliente);
		telefoneRepository.save(telefone);
		return telefone;
	}
}
