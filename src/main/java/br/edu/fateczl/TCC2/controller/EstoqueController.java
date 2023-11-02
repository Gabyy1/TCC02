package br.edu.fateczl.TCC2.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fateczl.TCC2.model.Produto;
import br.edu.fateczl.TCC2.persistence.ProdutoDao;

@Controller
public class EstoqueController {

	@Autowired
	ProdutoDao pDao;

	@RequestMapping(name = "estoque", value = "/estoque", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView("estoque");
	}

	@RequestMapping(name = "estoque", value = "/estoque", method = RequestMethod.POST)
	public ModelAndView findProduto(@RequestParam Map<String, String> params, ModelMap model) {
		String cmd = params.get("button");
		List<Produto> listaEstoque = new ArrayList<Produto>();
		String saida = "";
		String erro = "";

		try {
			if (cmd.contains("Listar")) {
				listaEstoque = pDao.listaEstoque();
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("listaEstoque", listaEstoque);
		}
		return new ModelAndView("estoque");
	}
}