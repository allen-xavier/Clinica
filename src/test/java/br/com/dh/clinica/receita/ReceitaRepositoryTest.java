package br.com.dh.clinica.receita;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dh.clinica.model.entities.Consulta;
import br.com.dh.clinica.model.entities.Receita;
import br.com.dh.clinica.model.repositories.ConsultaRepository;
import br.com.dh.clinica.model.repositories.ReceitaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReceitaRepositoryTest {
	
	@Autowired
	ConsultaRepository consultaRepository;

	@Autowired
	ReceitaRepository receitaRepository;
	
	@Test
	public void verificaReceitaDescricaoNull() {
		Consulta consulta = new Consulta();
		Receita receita = new Receita();
		consultaRepository.save(consulta);
		receita.setConsulta(consulta);
		receita.setDescricao("remedio para pressao");
		receita.setDosagem("8 em 8 horas");
		receita.setTempo(10);

	    this.receitaRepository.save(receita);
	    Receita receitaDb = this.receitaRepository.findOneByCodigo(receita.getCodigo());
	    Assertions.assertThat(receitaDb.getDescricao()).isNotNull();
	  }
	
	@Test
	public void verificaReceitaTempoNull() {
		Consulta consulta = new Consulta();
		Receita receita = new Receita();
		consultaRepository.save(consulta);
		receita.setConsulta(consulta);
		receita.setDescricao("remedio para pressao");
		receita.setDosagem("8 em 8 horas");
		receita.setTempo(10);

	    this.receitaRepository.save(receita);
	    Receita receitaDb = this.receitaRepository.findOneByCodigo(receita.getCodigo());
	    Assertions.assertThat(receitaDb.getTempo()).isNotNull();
	  }
	
	@Test
	public void verificaReceitaDosagemNull() {
		Consulta consulta = new Consulta();
		Receita receita = new Receita();
		consultaRepository.save(consulta);
		receita.setConsulta(consulta);
		receita.setDescricao("remedio para pressao");
		receita.setDosagem("8 em 8 horas");
		receita.setTempo(10);

	    this.receitaRepository.save(receita);
	    Receita receitaDb = this.receitaRepository.findOneByCodigo(receita.getCodigo());
	    Assertions.assertThat(receitaDb.getDosagem()).isNotNull();
	  }
	
	@Test
	public void verificaReceitaAtualizado() {
		Consulta consulta = new Consulta();
		Receita receita = new Receita();
		consultaRepository.save(consulta);
		receita.setConsulta(consulta);
		receita.setDescricao("remedio para pressao");
		receita.setDosagem("8 em 8 horas");
		receita.setTempo(10);

	    this.receitaRepository.save(receita);
	    
	    receita.setDescricao("remedio para alergia");
		
		receitaRepository.save(receita);
	    Receita receitaDb = this.receitaRepository.findOneByCodigo(receita.getCodigo());
	    Assertions.assertThat(receitaDb.getDescricao()).isEqualTo(receita.getDescricao());
	  }
	
	@Test
	public void verificaReceitaDeletado()  {
		Consulta consulta = new Consulta();
		Receita receita = new Receita();
		consultaRepository.save(consulta);
		receita.setConsulta(consulta);
		receita.setDescricao("remedio para pressao");
		receita.setDosagem("8 em 8 horas");
		receita.setTempo(10);

	    this.receitaRepository.save(receita);
		
	    receitaRepository.delete(receita);
		
		Assertions.assertThat(receitaRepository.findOneByCodigo(receita.getCodigoConsulta())).isNull();
	}
}



