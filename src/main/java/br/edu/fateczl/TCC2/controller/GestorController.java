package br.edu.fateczl.TCC2.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fateczl.TCC2.model.Funcionario;
import br.edu.fateczl.TCC2.persistence.GestorDao;

@Controller
public class GestorController {
	
	@Autowired
	GestorDao gDao;
	
	@RequestMapping(name = "gestor", value = "/gestor", method = RequestMethod.GET)
    public ModelAndView init(ModelMap model){
		List<Funcionario> funcionarios = new ArrayList<>();
        
        try {
        	funcionarios = gDao.listaFuncionarios();
		}catch (SQLException | ClassNotFoundException e){
			e.getMessage();
		}finally {
			model.addAttribute("funcionario", funcionarios);
		}
        return new ModelAndView("gestor");
    }
	
	@RequestMapping(value = "/deleteFuncionario/{cpf}/{email}", method = RequestMethod.GET)
    public String deleteFuncionario(@PathVariable("cpf") String cpf, @PathVariable("email") String email) throws ClassNotFoundException, SQLException {
		Funcionario f = new Funcionario();
		f.setCpf(cpf);
		f.setEmail(email);
        gDao.excluiFuncionario(f);
        return "redirect:/gestor";
    }
	
	 @RequestMapping(value = "/editFuncionario/{cpf}", method = RequestMethod.GET)
	 public String showEditFuncionario(@PathVariable("cpf") String cpf, ModelMap model) throws ClassNotFoundException, SQLException {
		 Funcionario f = new Funcionario();
		 f.setCpf(cpf);
		 
		 Funcionario funcionario = gDao.pesquisaFuncionarioCpf(f);
	     model.addAttribute("f", funcionario);
	     return "editFuncionario";
	 }
	 
	 @RequestMapping(value = "/editFuncionario", method = RequestMethod.POST)
	 public String updateFuncionario(ModelMap model, @RequestParam Map<String, String> params) throws ClassNotFoundException, SQLException {
		 String cpf = params.get("cpf");
		 String nome = params.get("nome");
		 String email = params.get("email");
		 String senha = params.get("senha");
		 int cargo = Integer.parseInt(params.get("cargo"));
		 String botao = params.get("botao");
		 
		 if (botao.equalsIgnoreCase("atualizar funcionario")) {
			 Funcionario f = new Funcionario();
			 f.setCpf(cpf);
			 f.setNome(nome);
			 f.setEmail(email);
			 f.setSenha(senha);
			 f.setCargo(cargo);
			 
			 gDao.editaFuncionario(f);
		 }

		 return "redirect:/gestor";
	 }
}