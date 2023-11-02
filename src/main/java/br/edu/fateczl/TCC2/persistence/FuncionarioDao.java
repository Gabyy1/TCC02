package br.edu.fateczl.TCC2.persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.TCC2.model.Fornecedor;
import br.edu.fateczl.TCC2.model.Produto;

@Repository
public class FuncionarioDao implements IFuncionarioDao{

	@Autowired
	GenericDao gDao;

	// ----------------------------- [FORNECEDOR]---------------------------//
	private String manterFornecedor(String op, Fornecedor fornecedor) throws ClassNotFoundException, SQLException {
		Connection c = gDao.getConnection();
		String sql = "{CALL sp_manter_fornecedor(?,?,?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, op);
		cs.setString(2, fornecedor.getCnpj());
		cs.setString(3, fornecedor.getNome());
		cs.setString(4, fornecedor.getTelefone());
		cs.setString(5, fornecedor.getEmail());
		cs.setString(6, fornecedor.getCep());
		cs.setString(7, fornecedor.getLogradouro());
		cs.setInt(8, fornecedor.getNumero());
		cs.setString(9, fornecedor.getBairro());
		cs.setString(10, fornecedor.getCidade());
		cs.setString(11, fornecedor.getEstado());
		cs.registerOutParameter(13, Types.VARCHAR);
		cs.execute();

		String saida = cs.getString(13);

		cs.close();
		c.close();

		return saida;
	}

	@Override
	public String cadastraFornecedor(Fornecedor fo) throws SQLException, ClassNotFoundException {
		String saida = manterFornecedor("I", fo);
		return saida;
	}

	@Override
	public String editaFornecedor(Fornecedor fo) throws SQLException, ClassNotFoundException {
		String saida = manterFornecedor("U", fo);
		return saida;
	}

	@Override
	public String excluiFornecedor(Fornecedor fo) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "{CALL sp_manter_fornecedor(?,?,?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, "D");
		cs.setString(2, fo.getCnpj());
		cs.setNull(3, Types.VARCHAR);
		cs.setNull(4, Types.VARCHAR);
		cs.setNull(5, Types.VARCHAR);
		cs.setNull(6, Types.VARCHAR);
		cs.setNull(7, Types.VARCHAR);
		cs.setNull(8, Types.INTEGER);
		cs.setNull(9, Types.VARCHAR);
		cs.setNull(10, Types.VARCHAR);
		cs.setNull(11, Types.VARCHAR);
		cs.setNull(12, Types.VARCHAR);
		cs.registerOutParameter(13, Types.VARCHAR);
		cs.execute();

		String saida = cs.getString(13);

		cs.close();
		c.close();

		return saida;
	}

	@Override
	public Fornecedor pesquisaFornecedor(Fornecedor fo) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT cnpj, nome, telefone, email, cep, logradouro, numero, bairro, cidade, estado FROM fn_pesquisarfornecedor(?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, fo.getCnpj());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			fo.setNome(rs.getString("nome"));
			fo.setTelefone(rs.getString("telefone"));
			fo.setEmail(rs.getString("email"));
			fo.setCep(rs.getString("cep"));
			fo.setLogradouro(rs.getString("logradouro"));
			fo.setNumero(rs.getInt("numero"));
			fo.setBairro(rs.getString("bairro"));
			fo.setCidade(rs.getString("cidade"));
			fo.setEstado(rs.getString("estado"));
		}
		rs.close();
		ps.close();
		c.close();
		return fo;
	}

	@Override
	public List<Fornecedor> listaFornecedores() throws SQLException, ClassNotFoundException {
		List<Fornecedor> fornecedor = new ArrayList<>();
		Connection c = gDao.getConnection();
		String sql = "SELECT cnpj, nome, telefone, email, cep, logradouro, numero, bairro, cidade, estado FROM fn_listarfornecedor()";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Fornecedor fo = new Fornecedor();
			fo.setCnpj(rs.getString("cnpj"));
			fo.setNome(rs.getString("nome"));
			fo.setTelefone(rs.getString("telefone"));
			fo.setEmail(rs.getString("email"));
			fo.setCep(rs.getString("cep"));
			fo.setLogradouro(rs.getString("logradouro"));
			fo.setNumero(rs.getInt("numero"));
			fo.setBairro(rs.getString("bairro"));
			fo.setCidade(rs.getString("cidade"));
			fo.setEstado(rs.getString("estado"));

			fornecedor.add(fo);
		}
		rs.close();
		ps.close();
		c.close();

		return fornecedor;
	}

	@Override
	public List<Fornecedor> buscaFornecedores(String nome) throws SQLException, ClassNotFoundException {
		List<Fornecedor> fornecedor = new ArrayList<>();
		Connection c = gDao.getConnection();
		String sql = "SELECT cnpj, nome, telefone, email, cep, logradouro, numero, bairro, cidade, estado FROM fornecedor WHERE nome LIKE '%' + ? + '%'";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, nome);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Fornecedor fo = new Fornecedor();
			fo.setCnpj(rs.getString("cnpj"));
			fo.setNome(rs.getString("nome"));
			fo.setTelefone(rs.getString("telefone"));
			fo.setEmail(rs.getString("email"));
			fo.setCep(rs.getString("cep"));
			fo.setLogradouro(rs.getString("logradouro"));
			fo.setNumero(rs.getInt("numero"));
			fo.setBairro(rs.getString("bairro"));
			fo.setCidade(rs.getString("cidade"));
			fo.setEstado(rs.getString("estado"));

			fornecedor.add(fo);
		}
		rs.close();
		ps.close();
		c.close();

		return fornecedor;
	}

	// ----------------------------- [PRODUTO] ---------------------------------//
	
	
	@Override
	public List<Produto> buscaProdutos(String nome) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> listaProduto() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String cadastraProduto(Produto p) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editaProduto(Produto p) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluiProduto(Produto p) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto pesquisaProduto(Produto p) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}