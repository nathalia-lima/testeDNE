package br.edu.dne.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.dne.util.ConnectionFactory;
import br.edu.dne.model.Estudantes;

public class EstudanteDAO {
	
	private Connection conn;   
	private PreparedStatement ps;  
	private ResultSet rs; 
	
	private Estudantes estudantes;

	public EstudanteDAO() throws Exception {
		try {
			this.conn = ConnectionFactory.getConnection();
		} catch (Exception e) {
			throw new Exception("erro: \n" + e.getMessage());
		}
	}

	public void salvar(Estudantes estudantes) throws Exception {
		if (estudantes == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "INSERT INTO estudantes (email, nome, dataNascimento, cpf, cep, numero, genero, celular, escolaridade, nomeCurso) values "
					+ "											(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, estudantes.getEmail());
			ps.setString(2, estudantes.getNome());
			ps.setString(3, estudantes.getDataNascimento());
			ps.setString(4, estudantes.getCpf());
			ps.setString(5, estudantes.getCep());
			ps.setString(6, estudantes.getNumero());
			ps.setString(7, estudantes.getGenero());
			ps.setString(8, estudantes.getCelular());
			ps.setString(9, estudantes.getEscolaridade());
			ps.setString(10, estudantes.getNomeCurso());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public void atualizar(Estudantes estudantes) throws Exception {
		if (estudantes == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "UPDATE estudantes set suspender=? WHERE cpf=?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, estudantes.getSuspender());
			ps.setString(2, estudantes.getCpf());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}

	public void excluir(Estudantes estudantes) throws Exception {
		if (estudantes == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			String SQL = "DELETE FROM estudantes WHERE cpf = ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, estudantes.getCpf());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	public Estudantes procurarEstudante(String cpfEstudante) throws Exception {
		try {
			String SQL = "SELECT  * FROM estudantes WHERE cpf=?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, cpfEstudante);			
			rs = ps.executeQuery();
			if (rs.next()) {
				String email = rs.getString("email");
				String nome = rs.getString("nome");
				String dataNascimento = rs.getString("dataNascimento");
				String cpf = rs.getString("cpf");
				String cep = rs.getString("cep");
				String numero = rs.getString("numero");
				String genero = rs.getString("genero");
				String celular = rs.getString("celular");
				String escolaridade = rs.getString("escolaridade");
				String nomeCurso = rs.getString("nomeCurso");
				float saldo = rs.getFloat("saldo");
				String suspender = rs.getString("suspender");
				estudantes = new Estudantes(email, nome, dataNascimento, cpf, cep, numero, genero, celular, escolaridade, nomeCurso, saldo, suspender);
			}
			return estudantes;
		} catch (SQLException sqle) {
			throw new Exception(sqle);
		} finally {
			ConnectionFactory.closeConnection(conn, ps, rs);
		}
	}
}