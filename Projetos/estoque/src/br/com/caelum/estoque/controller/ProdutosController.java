package br.com.caelum.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.estoque.Movimentacao;
import br.com.caelum.estoque.Produto;
import br.com.caelum.estoque.dao.MovimentacaoDAO;
import br.com.caelum.estoque.dao.ProdutoDAO;
import br.com.caelum.estoque.service.GeradorDeMovimentacao;


@Controller
@RequestMapping(value="/produtos")
public class ProdutosController {

	@Autowired
	//@Qualifier("produtoHibernateDAO")
	private ProdutoDAO produtoDao;
	
	@Autowired
	private GeradorDeMovimentacao geradorDeMovimentacao;
	@Autowired
	private MovimentacaoDAO movimentacao;
	
	
	@RequestMapping("/index")
	public String index(){
		return "produtos/index";
	}
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject(produtoDao.listar());
		return modelAndView;
	}
	
	@RequestMapping(value="/mostrar/{id}",method=RequestMethod.GET)
	public ModelAndView mostrar(@PathVariable Long id){
		ModelAndView modelAndView = new ModelAndView("produtos/mostrar");
		modelAndView.addObject(produtoDao.buscarPorId(id));
		return modelAndView;
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(){
		return "produtos/form";
	}
	
	@RequestMapping(value="salvar",method=RequestMethod.POST)
	public String salvar(Produto produto){
		produtoDao.salvar(produto);
		return "redirect:/produtos/listar";
		
	}
	
	@RequestMapping(value="/alterar",method=RequestMethod.POST)
	@Transactional
	public String alterar(Produto produto){
		Movimentacao movimentacao = geradorDeMovimentacao.geraMovimentacao(produto);
		this.movimentacao.salvar(movimentacao);
		produtoDao.alterar(produto);
		return "redirect:/produtos/listar";
	}
	
	@RequestMapping(value="/editar",method=RequestMethod.GET)
	public ModelAndView editar(Long id){
		Produto produto = produtoDao.buscarPorId(id);
		ModelAndView modelAndView = new ModelAndView("produtos/editar");
		modelAndView.addObject(produto);
		return modelAndView;
	}
}
