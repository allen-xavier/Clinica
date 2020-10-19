package br.com.dh.clinica.receita;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReceitaRepositoryTest {

	@Autowired
	ReceitaRepository receitaRepository;
	
	@Test
	public void verificaIdReceitaNull() {
	    Receita cliente = new Receita("remedio para pressao", "10", "8 em 8 horas");

	    this.receitaRepository.save(cliente);
	    Receita receitaDb = this.receitaRepository.findOneByCpf(cliente.getCpf());
	    Assertions.assertThat(receitaDb.getId()).isNotNull();
	  }
}



