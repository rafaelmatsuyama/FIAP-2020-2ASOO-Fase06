package br.com.fiap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.entity.Produto;
import br.com.fiap.repository.ProdutoRepository;

@Component
public class ProdutoService implements IProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto getProdutoById(long id) {
		System.out.println("getProdutoById()");		
		return produtoRepository.findById(id).get();
	}
		
	public List<Produto> getAllProdutos(){
		System.out.println("getAllProdutos()");
		List<Produto> lista = new ArrayList<>();
		produtoRepository.findAll().forEach(e -> lista.add(e));
		return lista;
	}
	
	public Produto addProduto(Produto produto){
		System.out.println("addProduto()");		
		return produtoRepository.save(produto);
	}
	
	public Produto updateProduto(Produto produto) {
		System.out.println("addProduto()");		
		return produtoRepository.save(produto);
	}
	
	public void deleteProduto(long id) {
		System.out.println("deleteProduto()");		
		produtoRepository.delete(produtoRepository.findById(id).get());
	}
} 