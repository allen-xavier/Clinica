package br.com.dh.lojaonline.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.lojaonline.model.entities.Produto;
import br.com.dh.lojaonline.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping()
	public Iterable<Produto> getProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> getProduto(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
	
	@GetMapping("/search")
	public Produto getProdutoNome(@RequestParam String nome) {
		return produtoRepository.findByNome(nome);
	}
	
	@GetMapping("/ano/{ano}")
	public List<Produto> getProdutoAno(@PathVariable String ano) {
		return produtoRepository.findByNomeContaining(ano);
	}
	
	@GetMapping("/quantidade/{quantidade}")
	public List<Produto> getProdutoQuantidade(@PathVariable Integer quantidade) {
		return produtoRepository.findByEstoque(quantidade);
	}
	
	@PostMapping()
	public void addProduto(@RequestBody Produto produto) {
		produtoRepository.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public void removeProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
	}
	
	@PutMapping("/{idProduto}")
	public void updateProduto(
			@PathVariable int idProduto,
			@RequestBody Produto produto
	) throws Exception {
		Produto produtoDB = produtoRepository.findById(idProduto).orElseThrow(() -> new Exception());
		if(!produto.getNome().isEmpty()) produtoDB.setNome(produto.getNome());
		if(!produto.getDescricao().isEmpty()) produtoDB.setDescricao(produto.getDescricao());
		if(produto.getEstoque() != null) produtoDB.setEstoque(produto.getEstoque());
		if(produto.getPreco() != null) produtoDB.setPreco(produto.getPreco());
		
		produtoRepository.save(produtoDB);
	}
}
