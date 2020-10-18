package br.com.dh.clinica.controllers;

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

import br.com.dh.clinica.model.entities.Consulta;
import br.com.dh.clinica.model.entities.Paciente;
import br.com.dh.clinica.model.repositories.ConsultaRepository;
import br.com.dh.clinica.model.repositories.PacienteRepository;

@RestController
@RequestMapping("consulta")
public class ConsultaController {
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	// Criar o repositório de paciente para cadastrá-lo em consulta
	// como chave estrangeira
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping
	public Iterable<Consulta> getConsultas(){
		return consultaRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public Optional<Consulta> getConsulta(@PathVariable int codigo) {
		return consultaRepository.findById(codigo);
	}
	
	@PostMapping
	public Consulta adicionarConsulta(@RequestBody Consulta consulta) {
		Paciente paciente = pacienteRepository.findOneByCpf(consulta.getPacienteCpf());
		consulta.setPaciente(paciente);
		consultaRepository.save(consulta);
		return consulta;
	}
	
	@PutMapping("/{codigo}")
	public Consulta updateConsulta(@RequestBody Consulta consulta, @PathVariable int codigo) {
		Consulta consultaDB = consultaRepository.findOneByCodigo(codigo);

		// LocalDate != null		
		if(consulta.getData() != null) consulta.setData(consulta.getData());
		
		// Valor != null
		if(consulta.getValor() != null) consulta.setValor(consulta.getValor());
		
		if(consulta.getDescricao().isEmpty() &&  consulta.getDescricao() != null)
			consulta.setDescricao(consulta.getDescricao());
		
		// LocalDate != null
		//if(consulta.getDataConsulta() != null)
			//consulta.setDataConsulta(consulta.getDataConsulta());
		
		consultaRepository.save(consultaDB);
		return consultaDB;
	}
	
	
	
	@DeleteMapping("/{codigo}")
	public void deleteConsulta(@PathVariable int codigo) {
		consultaRepository.deleteById(codigo);
	}
}
