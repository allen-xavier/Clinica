package br.com.dh.clinica.consulta;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dh.clinica.model.entities.Consulta;
import br.com.dh.clinica.model.repositories.ConsultaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConsultaRepositoryTest {
	@Autowired
	ConsultaRepository consultaRepository;
	
	/*
	-codigo: int
	-paciente: Paciente
	-data: date
	-valor: float
	-descricao: string
	-medico: Medico
	+getPaciente()
	+getCodigo()
	+getMedico()
	 */
	
	@Test
	public void verificaConsultaCodigoNull() {
		Consulta consulta = new Consulta();
		consulta.setCodigo(1);
		Paciente paciente = new Paciente();
		consulta.setPaciente("123.456.789-99");
		consulta.setData(LocalDate.of(2020, 2, 10));
		consulta.setValor(150.00);
		consulta.setDescricao("dermatologia");			

		consultaRepository.save(consulta);
		
		Consulta consultaDb = consultaRepository.findOneByCodigo(consulta.getCodigo());
		Assertions.assertThat(consultaDb.getId()).isNotNull();
	}
	
	@Test
	public void verificaConsultaPacienteNull() {
		Consulta consulta = new Consulta();
		
		consulta.setCodigo(1);
		

		consultaRepository.save(consulta);
		
		Consulta consultaDb = consultaRepository.findOneByCodigo(consulta.getCodigo());
		Assertions.assertThat(consultaDb.getPaciente()).isNotNull();
	}
	
	@Test
	public void verificaConsultaDataNull() {
		Consulta consulta = new Consulta();
		
		consulta.setCodigo(1);
		

		consultaRepository.save(consulta);
		
		Consulta consultaDb = consultaRepository.findOneByCodigo(consulta.getCodigo());
		Assertions.assertThat(consultaDb.getData()).isNotNull();
	}
	
	@Test
	public void verificaConsultaValorNull() {
		Consulta consulta = new Consulta();
		
		consulta.setCodigo(1);
		

		consultaRepository.save(consulta);
		
		Consulta consultaDb = consultaRepository.findOneByCodigo(consulta.getCodigo());
		Assertions.assertThat(consultaDb.getValor()).isNotNull();
	}
	
	@Test
	public void verificaConsultaDescricaoNull() {
		Consulta consulta = new Consulta();
		
		consulta.setCodigo(1);
		

		consultaRepository.save(consulta);
		
		Consulta consultaDb = consultaRepository.findOneByCodigo(consulta.getCodigo());
		Assertions.assertThat(consultaDb.getDescricao()).isNotNull();
	}
	
	@Test
	public void verificaConsultaAtualizada() {
		Consulta consulta = new Consulta();
		
		consulta.setCodigo(1);
		
		
		consulta.setValor("150.00");
		
		consultaRepository.save(consulta);
		
		consulta.setValor("200.00");
		
		consultaRepository.save(consulta);
		
		Consulta consultaDb = consultaRepository.findOneByCodigo(consulta.getCodigo());
		Assertions.assertThat(consultaDb.getValor()).isEqualTo(consulta.getValor());
	}
	
	@Test
	public void verificaConsultaDeletada() {
		Consulta consulta = new Consulta();
		
		consulta.setCodigo(1);
		
		
		consultaRepository.save(consulta);
		
		pacienteRepository.delete(consulta);
		
		Consulta consultaDb = consultaRepository.findOneByCodigo(consulta.getCodigo());
		Assertions.assertThat(consultaDb.getCodigo()).isNull();
	}
}
