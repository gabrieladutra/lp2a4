package lp2a4.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlunoJDBCDAO implements AlunoDAO{
	
	public static Connection conectaMySQL() {		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/databasename"
					, "username"
					, "password");
			return conn;
		} catch (SQLException e) {
			System.out.println("Erro! Não foi possível conectar com o banco de dados: " + e);
			return null;
		}
		
	}
	
	@Override
	public boolean create(AlunoPOJO aluno) {
		String instrucaoSQL = "INSERT INTO Aluno (matricula, nome, endereco, data_inicio, data_termino) VALUES (?,?,?,?,?)";
			
		PreparedStatement statement;
		
		try {
			statement = AlunoJDBCDAO.conectaMySQL().prepareStatement(instrucaoSQL);
			statement.setString(1, aluno.getMatricula());
			statement.setString(2, aluno.getNome());
			statement.setString(3, aluno.getEndereco());
			statement.setString(4, aluno.getDataIngresso().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			statement.setString(5, aluno.getDataConclusao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			
			statement.execute();
			
			statement.close();
			AlunoJDBCDAO.conectaMySQL().close();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro! Não foi possível inserir o Aluno: " + e);
			return false;
		}
	}

	@Override
	public AlunoPOJO retrieve(String matricula) {
		try {
			AlunoPOJO aluno = new AlunoPOJO();
			PreparedStatement statement = conectaMySQL().prepareStatement("SELECT matricula,nome,endereco,data_inicio,data_termino FROM Aluno WHERE matricula = ?;");
			statement.setString(1, matricula);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				String nome = result.getString("nome");
				String endereco = result.getString("endereco");
				String dtIngresso = result.getString("data_inicio");
				String dtConclusao = result.getString("data_termino");
				aluno.setMatricula(matricula);
				aluno.setNome(nome);
				aluno.setEndereco(endereco);
				aluno.setDataIngresso(LocalDate.parse(dtIngresso, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				aluno.setDataConclusao(LocalDate.parse(dtConclusao, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			}
			statement.close();
			AlunoJDBCDAO.conectaMySQL().close();
			return aluno;
		} catch(Exception e) {
			System.out.println("Erro! Não foi possível consultar os dados." + e);
			return null;
		}
		
	}

	@Override
	public boolean update(AlunoPOJO aluno) {
		String instrucaoSQL = "UPDATE Aluno SET matricula = ?, nome = ?, endereco = ?, data_inicio = ?, data_termino = ? WHERE matricula = ?;";
		
		PreparedStatement statement;
		
		try {
			statement = AlunoJDBCDAO.conectaMySQL().prepareStatement(instrucaoSQL);
			statement.setString(1, aluno.getMatricula());
			statement.setString(2, aluno.getNome());
			statement.setString(3, aluno.getEndereco());
			statement.setString(4, aluno.getDataIngresso().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			statement.setString(5, aluno.getDataConclusao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
			statement.setString(6, aluno.getMatricula());
			statement.execute();
			statement.close();
			AlunoJDBCDAO.conectaMySQL().close();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro! Não foi possível atualizar: " + e);
			return false;
		}
	}

	@Override
	public boolean delete(String matricula) {
		try {
			PreparedStatement statement = AlunoJDBCDAO.conectaMySQL().prepareStatement("DELETE FROM Aluno WHERE matricula = ?;");
			statement.setString(1, matricula);
			statement.execute();
			statement.close();
			AlunoJDBCDAO.conectaMySQL().close();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro! Não foi possível realizar a deleção: " + e);
			return false;
		}
		
	}
}