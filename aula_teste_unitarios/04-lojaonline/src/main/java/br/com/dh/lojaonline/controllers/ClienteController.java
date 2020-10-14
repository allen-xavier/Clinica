package br.com.dh.lojaonline.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.lojaonline.model.entities.Cliente;
import br.com.dh.lojaonline.model.repositories.ClienteRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@GetMapping()
	public Iterable<Cliente> getClientes() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Cliente> getCliente(@PathVariable int id) {
		return clienteRepository.findById(id);
	}
	
	@GetMapping("/cpf/{cpf}")
	public List<Cliente> getClientesCpf(@PathVariable String cpf) {
		return clienteRepository.findByCpfContaining(cpf);
	}
	
	@PostMapping()
	public void addCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCliente(@PathVariable int id) {
		clienteRepository.deleteById(id);
	}
	
	@PutMapping("/{idCliente}")
	public void updateCliente(
			@PathVariable int id,
			@RequestBody Cliente cliente)
	throws Exception {
		Cliente clienteDB = clienteRepository.findById(id)
				.orElseThrow(() -> new Exception());
		if(cliente.getNome().isEmpty()) clienteDB.setNome(cliente.getNome());
		if(cliente.getCpf().isEmpty()) clienteDB.setCpf(cliente.getCpf());
		
		clienteRepository.save(clienteDB);
	}
}