package br.com.dh.clinica.consulta;

import java.time.LocalDate;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dh.clinica.model.entities.Consulta;
import br.com.dh.clinica.model.entities.Paciente;
import br.com.dh.clinica.model.repositories.ConsultaRepository;
import br.com.dh.clinica.model.repositories.PacienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ConsultaRepositoryTest {
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Autowired
	PacienteRepository pacienteRepository;
	
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
//		consulta.setCodigo(1);
		// Precisa de importar o paciente
		Paciente paciente = new Paciente();
		consulta.setPaciente(paciente);
//		consulta.setData(LocalDate.of(2020, 2, 10));
		consulta.setValor(150.00);
		consulta.setDescricao("dermatologia");			

		consultaRepository.save(consulta);
		
		Optional<Consulta> consultaDb = consultaRepository.findById(consulta.getCodigo());
		// Busca pelo código
		Assertions.assertThat(consultaDb.get().getCodigo()).isNotNull();
	}
	
	@Test
	public void verificaConsultaPacienteNull() {
		Consulta consulta = new Consulta();
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789.55");
		
		pacienteRepository.save(paciente);
		
		consulta.setPaciente(paciente);
		
		consultaRepository.save(consulta);
		
		Consulta consultaDb = consultaRepository.findOneByCodigo(consulta.getCodigo());
		Assertions.assertThat(consultaDb.getPaciente()).isNotNull();
	}
	
	@Test
	public void verificaConsultaDataNull() {
		Consulta consulta = new Consulta();
		consulta.setData(LocalDate.of(2020,1,10));

		consultaRepository.save(consulta);
		
		Consulta consultaDb = consultaRepository.findOneByCodigo(consulta.getCodigo());
		Assertions.assertThat(consultaDb.getData()).isNotNull();
	}
	
	@Test
	public void verificaConsultaValorNull() {
		Consulta consulta = new Consulta();
		consulta.setValor(150.00);

		consultaRepository.save(consulta);
		
		Consulta consultaDb = consultaRepository.findOneByCodigo(consulta.getCodigo());
		Assertions.assertThat(consultaDb.getValor()).isNotNull();
	}
	
	@Test
	public void verificaConsultaDescricaoNull() {
		Consulta consulta = new Consulta();
		consulta.setDescricao("Teste descricao");

		consultaRepository.save(consulta);
		
		Consulta consultaDb = consultaRepository.findOneByCodigo(consulta.getCodigo());
		Assertions.assertThat(consultaDb.getDescricao()).isNotNull();
	}
	
	@Test
	public void verificaConsultaAtualizada() {
		Consulta consulta = new Consulta();
		
		// Valor como double
		consulta.setValor(150.00);
		
		consultaRepository.save(consulta);
		
		consulta.setValor(200.00);
		
		consultaRepository.save(consulta);
		
		Consulta consultaDb = consultaRepository.findOneByCodigo(consulta.getCodigo());
		Assertions.assertThat(consultaDb.getValor()).isEqualTo(consulta.getValor());
	}
	
	@Test
	public void verificaConsultaDeletada() {
		Consulta consulta = new Consulta();
		consulta.setPaciente(new Paciente());
		//
		consultaRepository.save(consulta);
		
		consultaRepository.delete(consulta);
		
		Consulta consultaDb = consultaRepository.findOneByCodigo(consulta.getCodigo());
		Assertions.assertThat(consultaDb).isNull();
	}
}
