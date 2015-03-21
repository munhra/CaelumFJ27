package br.com.caelum.estoque.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.estoque.Produto;

@Repository
public class ProdutoHibernateDAO implements ProdutoDAO{

	private Session session;
	
	@Autowired
	public ProdutoHibernateDAO(SessionFactory factory){
		session = factory.openSession();
	}
	
	@Override
	public void salvar(Produto produto) {
		session.save(produto);
		
	}

	@Override
	public void alterar(Produto produto) {
		session.update(produto);
		
	}

	@Override
	public List<Produto> listar() {
		List<Produto> produtos = session.createQuery("from Produto").list();
		return produtos;
	}

	@Override
	public Produto buscarPorId(Long id) {
		return (Produto) session.get(Produto.class, id);
	}

}
