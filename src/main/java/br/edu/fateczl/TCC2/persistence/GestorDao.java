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

import br.edu.fateczl.TCC2.model.Funcionario;

@Repository
public class GestorDao implements IGestorDao {

	@Autowired
	GenericDao gDao;

	// ----------------------------- [FUNCIONARIO]---------------------------//
	public String manterFuncionario(String op, Funcionario funcionario) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "{CALL sp_manter_funcionario(?,?,?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, op);
		cs.setString(2, funcionario.getCpf());
		cs.setString(3, funcionario.getNome());
		cs.setString(4, funcionario.getEmail());
		cs.setString(5, funcionario.getSenha());
		cs.setInt(6, funcionario.getCargo());
		cs.registerOutParameter(7, Types.VARCHAR);
		cs.execute();

		String saida = cs.getString(7);

		cs.close();
		c.close();

		return saida;

	}

	@Override
	public String cadastraFuncionario(Funcionario f) throws SQLException, ClassNotFoundException {
		String saida = manterFuncionario("I", f);
		return saida;
	}

	@Override
	public String editaFuncionario(Funcionario f) throws SQLException, ClassNotFoundException {
		String saida = manterFuncionario("U", f);
		return saida;
	}

	@Override
	public String excluiFuncionario(Funcionario f) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "{CALL sp_manter_funcionario(?,?,?,?,?,?,?)}";
		CallableStatement cs = c.prepareCall(sql);
		cs.setString(1, "D");
		cs.setString(2, f.getCpf());
		cs.setNull(3, Types.VARCHAR);
		cs.setString(4, f.getEmail());
		cs.setNull(5, Types.VARCHAR);
		cs.setNull(6, Types.VARCHAR);
		cs.registerOutParameter(7, Types.VARCHAR);
		cs.execute();

		String saida = cs.getString(7);

		cs.close();
		c.close();

		return saida;
	}

	@Override
	public Funcionario pesquisaFuncionarioCpf(Funcionario f) throws SQLException, ClassNotFoundException {
		Connection c = gDao.getConnection();
		String sql = "SELECT cpf, nome, email, cargo FROM fn_pesquisarfuncionario(?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, f.getCpf());
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			f.setNome(rs.getString("nome"));
			f.setEmail(rs.getString("email"));
			f.setCargo(rs.getInt("cargo"));
		}
		rs.close();
		ps.close();
		c.close();
		return f;
	}

	@Override
	public List<Funcionario> listaFuncionarios() throws SQLException, ClassNotFoundException {
		List<Funcionario> funcionario = new ArrayList<>();
		Connection c = gDao.getConnection();
		String sql = "SELECT cpf, nome, email, cargo FROM fn_listarfuncionario()";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Funcionario f = new Funcionario();
			f.setCpf(rs.getString("cpf"));
			f.setNome(rs.getString("nome"));
			f.setEmail(rs.getString("email"));
			f.setCargo(rs.getInt("cargo"));

			funcionario.add(f);
		}
		rs.close();
		ps.close();
		c.close();

		return funcionario;
	}

	@Override
	public List<Funcionario> buscaFuncionarios(String nome) throws SQLException, ClassNotFoundException {
		List<Funcionario> funcionarios = new ArrayList<>();
		Connection c = gDao.getConnection();
		String sql = "SELECT cpf, nome, email, cargo FROM funcionario WHERE nome LIKE ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, nome);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Funcionario fu = new Funcionario();
			fu.setCpf(rs.getString("cpf"));
			fu.setNome(rs.getString("nome"));
			fu.setEmail(rs.getString("email"));
			fu.setCargo(rs.getInt("cargo"));

			funcionarios.add(fu);
		}
		rs.close();
		ps.close();
		c.close();

		return funcionarios;
	}
}