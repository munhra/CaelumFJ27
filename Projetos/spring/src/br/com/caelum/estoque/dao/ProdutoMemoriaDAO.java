package br.com.caelum.estoque.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.estoque.Produto;

public class ProdutoMemoriaDAO implements ProdutoDAO{

	private List<Produto> produtos = new ArrayList<Produto>();
	
	@Override
	public void salvar(Produto produto) {
		produtos.add(produto);
		
	}

	@Override
	public void alterar(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto> listar() {
		return produtos;
	}

	@Override
	public Produto buscarPorId(Long id) {
		return produtos.get(id.intValue() - 1);
	}

	

}
