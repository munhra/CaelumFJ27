package br.com.caelum.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.estoque.dao.ProdutoDAO;


@Controller
@RequestMapping(value="/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoDAO produtoDao;
	
	@RequestMapping("/index")
	public String index(){
		return "produtos/index";
	}
	
	@RequestMapping(value="/listar")
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject(produtoDao.listar());
		return modelAndView;
	}
}
