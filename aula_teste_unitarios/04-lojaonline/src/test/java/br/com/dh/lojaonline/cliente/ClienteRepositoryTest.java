package br.com.dh.lojaonline.cliente;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.dh.lojaonline.model.entities.Cliente;
import br.com.dh.lojaonline.model.repositories.ClienteRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteRepositoryTest {
	@Autowired
  ClienteRepository clienteRepository;

	@Test
  public void verificaIdClienteNull() {
    Cliente cliente = new Cliente("Vanderson", "123465590-04");

    this.clienteRepository.save(cliente);
    Cliente clienteDb = this.clienteRepository.findOneByCpf(cliente.getCpf());
    Assertions.assertThat(clienteDb.getId()).isNotNull();
  }
	
	@Test
  public void verificaNomeClienteNull() {
    Cliente cliente = new Cliente("Vanderson", "123465590-04");

    this.clienteRepository.save(cliente);
    Cliente clienteDb = this.clienteRepository.findOneByCpf(cliente.getCpf());
    Assertions.assertThat(clienteDb.getNome()).isNotNull();
  }
	
	@Test
  public void verificaClienteDeletado() {
    Cliente cliente = new Cliente("Vanderson", "123465590-04");

    this.clienteRepository.save(cliente);
    this.clienteRepository.delete(cliente);
    Assertions.assertThat(this.clienteRepository.findOneByCpf(cliente.getCpf())).isNull();
  }
	
	@Test
  public void verificaClienteAtualizado() {
    Cliente cliente = new Cliente("Vanderson", "123465590-04");

    this.clienteRepository.save(cliente);
    
    cliente.setNome("Vanderson Sander");
    cliente.setCpf("123465590-05");
    
    this.clienteRepository.save(cliente);
    Cliente clienteAtualizado = this.clienteRepository.findOneByCpf(cliente.getCpf());
    Assertions.assertThat(clienteAtualizado.getCpf()).isEqualTo(cliente.getCpf());
  }
}
