package br.com.caelum.estoque;

import java.util.List;

import br.com.caelum.estoque.dao.ProdutoDAO;

public class GerenciadorDeProdutos {

	private ProdutoDAO produtoDao;
	
	/*
	public void setProdutoDao(ProdutoDAO produtoDao) {
		this.produtoDao = produtoDao;
	}*/

	public GerenciadorDeProdutos(ProdutoDAO produtoDao) {
		this.produtoDao = produtoDao;
	}
	
	public void novoProduto(Produto produto){
		System.out.println("Salvando o produto");
		this.produtoDao.salvar(produto);
	}
	
	public List<Produto> getProdutos(){
		return produtoDao.listar();
	}

}
