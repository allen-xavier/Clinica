package br.com.dh.clinica.paciente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
public class PacienteRepositoryTest {
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	@Test
	public void verificaPacienteCpfNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		paciente.setNome("Vanderson");
		paciente.setEndereco("Rua Osaka");
		paciente.setDataNascimento(LocalDate.of(1991, 2, 28));
		paciente.setTelefone("11 93214-4561");
		paciente.setDataPrimeiraConsulta(LocalDate.of(2020, 2, 10));
		paciente.setEmail("vanderson@email.com");
		paciente.setPeso(70);
		paciente.setAltura(180);

		pacienteRepository.save(paciente);
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getCpf()).isNotNull();
	}
	
	@Test
	public void verificaPacienteNomeNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		paciente.setNome("Vanderson");

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getNome()).isNotNull();
	}
	
	@Test
	public void verificaPacienteEnderecoNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		paciente.setEndereco("Rua Osaka");

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getEndereco()).isNotNull();
	}
	
	@Test
	public void verificaPacienteDataNascimentoNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		paciente.setDataNascimento(LocalDate.of(1991, 2, 28));

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getDataNascimento()).isNotNull();
	}
	
	@Test
	public void verificaPacienteTelefoneNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		paciente.setTelefone("11 93214-4567");

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getTelefone()).isNotNull();
	}
	
	@Test
	public void verificaPacienteDataPrimeiraConsultaNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		paciente.setDataPrimeiraConsulta(LocalDate.of(2020,2,15));

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getDataPrimeiraConsulta()).isNotNull();
	}
	
	@Test
	public void verificaPacienteEmailNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		paciente.setEmail("vanderson@email.com");

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getEmail()).isNotNull();
	}
	
	@Test
	public void verificaPacientePesoNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		paciente.setPeso(70);

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getPeso()).isNotNull();
	}
	
	@Test
	public void verificaPacienteAlturaNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		paciente.setAltura(180);

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getAltura()).isNotNull();
	}
	
	@Test
	public void verificaPacienteConsultasNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-00");
		paciente.setNome("Vanderson");
		
		pacienteRepository.save(paciente);
		
		Consulta consulta = new Consulta();
		Consulta consulta2 = new Consulta();
		/*consulta.setPaciente(paciente);
		consulta2.setPaciente(paciente);
		consultaRepository.save(consulta);
		consultaRepository.save(consulta2);//*/
		
		List<Consulta> consultas = new ArrayList<>();
		consultas.add(consulta);
		consultas.add(consulta2);
		paciente.setConsultas(consultas);
		
		pacienteRepository.save(paciente);
		Assertions.assertThat(pacienteRepository.findOneByCpf(paciente.getCpf())
				.getConsultas()).isNotNull();
	}
	
	@Test
	public void verificaPacienteAtualizado() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		
		paciente.setNome("Vanderson");
		
		pacienteRepository.save(paciente);
		
		paciente.setNome("Vanderson Sander");
		
		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getNome()).isEqualTo(paciente.getNome());
	}
	
	@Test
	public void verificaPacienteDeletado() throws Exception {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		paciente.setNome("Vanderson");
		
		pacienteRepository.save(paciente);
		
		pacienteRepository.delete(paciente);
		
		Assertions.assertThat(pacienteRepository.findOneByCpf(paciente.getCpf())).isNull();
	}
	
}
