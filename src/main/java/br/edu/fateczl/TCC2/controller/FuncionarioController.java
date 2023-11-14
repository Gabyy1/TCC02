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

import br.edu.fateczl.TCC2.model.Funcionario;
import br.edu.fateczl.TCC2.persistence.FuncionarioDao;

@Controller
public class FuncionarioController {
	
	@Autowired
	FuncionarioDao fDao;
	
	@RequestMapping(name = "funcionario", value = "/produto", method = RequestMethod.GET)
	public ModelAndView init(ModelMap model) {
		return new ModelAndView("funcionario");
	}
	
	@RequestMapping(name = "funcionario", value = "/produto", method = RequestMethod.POST)
	public ModelAndView findfuncionarios(@RequestParam Map<String, String> params, ModelMap model) {
		String cmd = params.get("button");
		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		Funcionario f = validaCampos(params, cmd);
		String saida = "";
		String erro = "";

		try {
			if (cmd.contains("Cadastrar")) {
				if (f != null) {
					saida = fDao.cadastraFuncionario(f);
					f = new Funcionario();
				}
			}
			if (cmd.contains("Atualizar")) {
				if (f != null) {
					saida = fDao.editaFuncionario(f);
					f = new Funcionario();
				}
			}
			if (cmd.contains("Excluir")) {
				if (f != null) {
					saida = fDao.excluiFuncionario(f);
					f = new Funcionario();
				}
			}
			if (cmd.contains("Consultar")) {
				if (f != null) {
					f = fDao.pesquisaFuncionario(f);
				}
			}
			if (cmd.contains("Listar")) {
				listaFuncionarios = fDao.listaFuncionarios();
			}
		} catch (SQLException | ClassNotFoundException e) {
			erro = e.getMessage();
		} finally {
			model.addAttribute("saida", saida);
			model.addAttribute("erro", erro);
			model.addAttribute("funcionario", f);
			model.addAttribute("listaFuncionarios", listaFuncionarios);
		}
		return new ModelAndView("funcionario");
	}
	
	private Funcionario validaCampos(Map<String, String> params, String cmd) {
	Funcionario f = new Funcionario();
	if (cmd.contains("Cadastrar") || cmd.contains("Atualizar")) {
		if (!params.get("cpf").trim().isEmpty() && !params.get("nome").trim().isEmpty()
				&& !params.get("email").trim().isEmpty() && !params.get("email").trim().isEmpty() && !params.get("cargo").trim().isEmpty()) {
			f.setCpf(params.get("codigo").trim());
			f.setNome(params.get("nome").trim());
			f.setEmail(params.get("email").trim());
			f.setSenha(params.get("senha").trim());
			f.setCargo(Integer.parseInt(params.get("cargo").trim()));
		}
	}
	if (cmd.contains("Excluir") || cmd.contains("Consultar")) {
		if (!params.get("cpf").trim().isEmpty()) {
			f.setCpf(params.get("cpf").trim());
		}
	}
	return f;
}
}

