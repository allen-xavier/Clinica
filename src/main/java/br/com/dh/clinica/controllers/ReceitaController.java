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
import br.com.dh.clinica.model.entities.Receita;
import br.com.dh.clinica.model.repositories.ConsultaRepository;
import br.com.dh.clinica.model.repositories.ReceitaRepository;

@RestController
@RequestMapping("receita")

public class ReceitaController {
	
	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	@GetMapping
	public Iterable<Receita> getReceita(){
		return receitaRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public Optional<Receita> getReceita(@PathVariable int codigo) {
		return receitaRepository.findById(codigo);
	}
	
	@PostMapping
	public Receita adicionarReceita(@RequestBody Receita receita) {
		Consulta consulta = consultaRepository.findOneByCodigo(receita.getCodigoConsulta());
		receita.setConsulta(consulta);
		receitaRepository.save(receita);
		return receita;
	}
	
	@PutMapping("/{id}")
	public Receita updateReceita(@RequestBody Receita receita, @PathVariable int codigo) {
		Receita receitaDb = receitaRepository.findOneByCodigo(codigo);

		if (receita.getDescricao() != null
				&& !receita.getDescricao().isEmpty()
				&& !receita.getDescricao().equals(receitaDb.getDescricao()))
			receitaDb.setDescricao(receita.getDescricao());
		
		if (receita.getTempo() != null
				&& !receita.getTempo().equals(receitaDb.getTempo()))
			receitaDb.setTempo(receita.getTempo());
		
		if (receita.getDosagem() != null
				&& !receita.getDosagem().isEmpty()
				&& !receita.getDosagem().equals(receitaDb.getDosagem()))
			receitaDb.setDosagem(receita.getDosagem());
		
		receitaRepository.save(receitaDb);
		return receitaDb;
	}
	
	
	
	@DeleteMapping("/id}")
	public void deleteReceita(@PathVariable int idReceita) {
		receitaRepository.deleteById(idReceita);
	}

}
