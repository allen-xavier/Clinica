package br.com.dh.lojaonline.produto;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dh.lojaonline.model.entities.Produto;
import br.com.dh.lojaonline.model.repositories.ProdutoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProdutoRepositoryTest {
/*String nome, String descricao, int estoque, double preco*/
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Test
	public void veriricaNomeProdutoIsNull() {
		Produto produto = new Produto("Playstation 5", "Nem pensa nisso", 50, 5000);
		
		produtoRepository.save(produto);
		
		Assertions.assertThat(produtoRepository.findOneByNome(produto.getNome())).isNotNull();
	}
	
	@Test
	public void veriricaDescricaoProdutoNull() {
		Produto produto = new Produto("Playstation 5", "Nem pensa nisso", 50, 5000);
		
		produtoRepository.save(produto);
		
		Produto produtoDb = produtoRepository.findOneByNome(produto.getNome());
		
		Assertions.assertThat(produtoDb.getDescricao()).isNotNull();
	}
	
	@Test
	public void veriricaEstoqueProdutoNull() {
		Produto produto = new Produto("Playstation 5", "Nem pensa nisso", 50, 5000);
		
		produtoRepository.save(produto);
		
		Produto produtoDb = produtoRepository.findOneByNome(produto.getNome());
		
		Assertions.assertThat(produtoDb.getEstoque()).isNotNull();
	}
	
	@Test
	public void veriricaPrecoProdutoNull() {
		Produto produto = new Produto("Playstation 5", "Nem pensa nisso", 50, 5000);
		
		produtoRepository.save(produto);
		
		Produto produtoDb = produtoRepository.findOneByNome(produto.getNome());
		
		Assertions.assertThat(produtoDb.getPreco()).isNotNull();
	}
	
	@Test
	public void veriricaProdutoDeletado() {
		Produto produto = new Produto("Playstation 5", "Nem pensa nisso", 50, 5000);
		
		produtoRepository.save(produto);
		produtoRepository.delete(produto);
		
		Assertions.assertThat(produtoRepository.findOneByNome(produto.getNome())).isNull();
	}
	
	@Test
	public void veriricaProdutoAtualizado() {
		Produto produto = new Produto("Playstation 5", "Nem pensa nisso", 50, 5000);
		
		produtoRepository.save(produto);
		
		produto.setNome("Playstation 5 Novo");
		produto.setDescricao("Talvez");
		produto.setEstoque(20);
		produto.setPreco(1500);
		
		Produto produtoAtualizado = produtoRepository.findOneByNome(produto.getNome());
		
		Assertions.assertThat(produtoAtualizado.getNome()).isEqualTo(produto.getNome());
	}
}
