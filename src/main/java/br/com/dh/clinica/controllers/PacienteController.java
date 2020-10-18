package br.com.dh.clinica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.clinica.model.entities.Paciente;
import br.com.dh.clinica.model.repositories.PacienteRepository;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping
	public Iterable<Paciente> getPacientes() {
		return pacienteRepository.findAll();
	}
	
	@GetMapping("/{cpf}")
	public Paciente getPaciente(@PathVariable String cpf) {
		return pacienteRepository.findOneByCpf(cpf);
	}
	
	@PostMapping
	public Paciente addPaciente(@RequestBody Paciente paciente) {
		pacienteRepository.save(paciente);
		return paciente;
	}
	
	@PutMapping("/{cpf}")
	public Paciente updatePaciente(@RequestBody Paciente paciente,
			@PathVariable String cpf) {
		Paciente pacienteDb = pacienteRepository.findOneByCpf(cpf);
		
		// Endereco
		if (paciente.getEndereco() != null
				&& !paciente.getEndereco().isEmpty()
				&& !paciente.getEndereco().equals(pacienteDb.getEndereco()))
			pacienteDb.setEndereco(paciente.getEndereco());
		
		// DataNascimento
		if (paciente.getDataNascimento() != null
				&& !paciente.getDataNascimento().equals(pacienteDb.getDataNascimento()))
			pacienteDb.setDataNascimento(paciente.getDataNascimento());
			
		// Telefone
		if (paciente.getTelefone() != null
				&& !paciente.getTelefone().isEmpty()
				&& !paciente.getTelefone().equals(pacienteDb.getTelefone()))
			pacienteDb.setTelefone(paciente.getTelefone());
			
		// DataPrimeiraConsulta
		if (paciente.getDataPrimeiraConsulta() != null
				&& !paciente.getDataPrimeiraConsulta().equals(pacienteDb.getDataPrimeiraConsulta()))
			pacienteDb.setDataPrimeiraConsulta(paciente.getDataPrimeiraConsulta());
			
		// Email
		if (paciente.getEmail() != null
				&& !paciente.getEmail().isEmpty()
				&& !paciente.getEmail().equals(pacienteDb.getEmail()))
			pacienteDb.setEmail(paciente.getEmail());
			
		// Peso
		if ((Integer) paciente.getPeso() != null
				&& paciente.getPeso() != 0
				&& paciente.getPeso() != pacienteDb.getPeso())
			pacienteDb.setPeso(paciente.getPeso());
			
		// Altura
		if ((Integer) paciente.getAltura() != null
				&& paciente.getAltura() != 0
				&& paciente.getAltura() != pacienteDb.getAltura())
			pacienteDb.setAltura(paciente.getAltura());
				
		pacienteRepository.save(pacienteDb);
		return pacienteDb;
	}
	/*
	-cpf: string // pk not null-nome: string
	-endereco: Endereco
	-dataNascimento: date
	-telefone: string
	-dataPrimeiraConsulta: date
	-email: string
	-peso: int
	-altura: int
*/
	
	@DeleteMapping("/{cpf}")
	public void deletePaciente(@PathVariable String cpf) {
		pacienteRepository.deleteByCpf(cpf);
	}

}
