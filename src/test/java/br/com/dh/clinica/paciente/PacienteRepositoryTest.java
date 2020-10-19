package br.com.dh.clinica.paciente;

<<<<<<< HEAD
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PacienteRepositoryTest {

=======
import java.time.LocalDate;
import java.util.List;

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
public class PacienteRepositoryTest {
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	/*
		-cpf: string // pk not null-nome: string
		-endereco: Endereco
		-dataNascimento: date
		-telefone: string
		-dataPrimeiraConsulta: date
		-email: string
		-peso: int
		-altura: int
		-consultas: list<Consulta>
		+getPeso()
		+requisitarConsulta()
		+getAltura()
		+getDataPrimeiraConsulta()
		+getConsultas()
	*/
	
	@Test
	public void verificaPacienteCpfNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		paciente.setNome("Vanderson");
		paciente.setEndereco("Rua Osaka");
		paciente.setDataNascimento(new LocalDate.of(1991, 2, 28));
		paciente.setTelefone("11 93214-4561");
		paciente.setDataPrimeiraConsulta(new LocalDate.of(2020, 2, 10));
		paciente.setEmail("vanderson@email.com");
		paciente.setPeso(70);
		paciente.setAltura(180);

		pacienteRepository.save(paciente);
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getId()).isNotNull();
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

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getEndereco()).isNotNull();
	}
	
	@Test
	public void verificaPacienteDataNascimentoNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getDataNascimento()).isNotNull();
	}
	
	@Test
	public void verificaPacienteTelefoneNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getTelefone()).isNotNull();
	}
	
	@Test
	public void verificaPacienteDataPrimeiraConsultaNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getDataPrimeiraConsulta()).isNotNull();
	}
	
	@Test
	public void verificaPacienteEmailNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getEmail()).isNotNull();
	}
	
	@Test
	public void verificaPacientePesoNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getPeso()).isNotNull();
	}
	
	@Test
	public void verificaPacienteAlturaNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getAltura()).isNotNull();
	}
	
	@Test
	public void verificaPacienteConsultasNull() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		Consulta consulta = new Consulta();
		Consulta consulta2 = new Consulta();
		
		consulta.setCodigo(1);
		consulta.setPaciente("123.456.789-99");
		
		consulta2.setCodigo(2);
		consulta2.setPaciente("123.456.789-99");
		
		consultaRepository.save(consulta);
		consultaRepository.save(consulta2);

		pacienteRepository.save(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getConsultas()).isNotNull();
	}
	
	@Test
	public void verificaPacienteRequisitarConsulta() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		Consulta consulta = new Consulta();
		
		consulta.setCodigo(1);
		consulta.setPaciente("123.456.789-99");
		
		consultaRepository.save(consulta);
		
		pacienteRepository.save(paciente);

		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getRequisitarConsulta(1)).isNotNull();
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
	public void verificaPacienteDeletado() {
		Paciente paciente = new Paciente();
		paciente.setCpf("123.456.789-99");
		paciente.setNome("Vanderson");
		
		pacienteRepository.save(paciente);
		
		pacienteRepository.delete(paciente);
		
		Paciente pacienteDb = pacienteRepository.findOneByCpf(paciente.getCpf());
		Assertions.assertThat(pacienteDb.getCpf()).isNull();
	}
	
>>>>>>> 528c05f90cadc337669ef3938d0d93f69f28669a
}
