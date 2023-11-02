package br.edu.fateczl.TCC2.persistence;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.TCC2.model.Produto;

public interface IProdutoDao {
	public String cadastraProduto(Produto p) throws SQLException, ClassNotFoundException;
	public String editaProduto(Produto p) throws SQLException, ClassNotFoundException;
	public String excluiProduto(Produto p) throws SQLException, ClassNotFoundException;
	public Produto pesquisaProduto(Produto p) throws SQLException, ClassNotFoundException;
	public List<Produto> buscaProdutos(String nome) throws SQLException, ClassNotFoundException;
	public List<Produto> listaProduto() throws SQLException, ClassNotFoundException;
	public List<Produto> listaEstoque() throws SQLException, ClassNotFoundException;
}