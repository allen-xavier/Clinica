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
		Receita receita = new Receita();
		Consulta consulta = new Consulta();
		consulta.setCodigo(12);
		consultaRepository.save(consulta);
		receita.setFk_consulta(consulta);
		
		receita.setDescricao("remedio para pressao");
		receita.setDosagem("8 em 8 horas");
		receita.setTempo(10);

	    this.receitaRepository.save(receita);
	    Receita receitaDb = this.receitaRepository.findOneByIdReceita(receita.getCodigoConsulta());
	    Assertions.assertThat(receitaDb.getDescricao()).isNotNull();
	  }
	
	@Test
	public void verificaReceitaTempoNull() {
		Receita receita = new Receita();
		Consulta consulta = new Consulta();
		consulta.setCodigo(12);
		consultaRepository.save(consulta);
		receita.setFk_consulta(consulta);
		
		receita.setDescricao("remedio para pressao");
		receita.setDosagem("8 em 8 horas");
		receita.setTempo(10);

	    this.receitaRepository.save(receita);
	    Receita receitaDb = this.receitaRepository.findOneByIdReceita(receita.getCodigoConsulta());
	    Assertions.assertThat(receitaDb.getTempo()).isNotNull();
	  }
	
	@Test
	public void verificaReceitaDosagemNull() {
		Receita receita = new Receita();
		Consulta consulta = new Consulta();
		consulta.setCodigo(12);
		consultaRepository.save(consulta);
		receita.setFk_consulta(consulta);
		
		receita.setDescricao("remedio para pressao");
		receita.setDosagem("8 em 8 horas");
		receita.setTempo(10);

	    this.receitaRepository.save(receita);
	    Receita receitaDb = this.receitaRepository.findOneByIdReceita(receita.getCodigoConsulta());
	    Assertions.assertThat(receitaDb.getDosagem()).isNotNull();
	  }
	
	@Test
	public void verificaReceitaAtualizado() {
		Receita receita = new Receita();
		Consulta consulta = new Consulta();
		consulta.setCodigo(12);
		consultaRepository.save(consulta);
		receita.setFk_consulta(consulta);
		
		receita.setDescricao("remedio para pressao");
		receita.setDosagem("8 em 8 horas");
		receita.setTempo(10);

	    this.receitaRepository.save(receita);
	    
	    receita.setDescricao("remedio para alergia");
		
		receitaRepository.save(receita);
	    Receita receitaDb = this.receitaRepository.findOneByIdReceita(receita.getCodigoConsulta());
	    Assertions.assertThat(receitaDb.getDescricao()).isEqualTo(receita.getDescricao());
	  }
	
	@Test
	public void verificaReceitaDeletado() throws Exception {
		Receita receita = new Receita();
		Consulta consulta = new Consulta();
		consulta.setCodigo(12);
		consultaRepository.save(consulta);
		receita.setFk_consulta(consulta);
		
		receita.setDescricao("remedio para pressao");
		receita.setDosagem("8 em 8 horas");
		receita.setTempo(10);

	    this.receitaRepository.save(receita);
		
	    receitaRepository.delete(receita);
		
		Assertions.assertThat(receitaRepository.findOneByIdReceita(receita.getCodigoConsulta())).isNull();
	}
}



