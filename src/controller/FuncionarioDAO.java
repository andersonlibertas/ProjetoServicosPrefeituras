package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Funcionario;

public class FuncionarioDAO {
	private Connection connection;
        
        public FuncionarioDAO() {
		connection = new Conecta().getConnection();
	}
	
        public void addFuncionario(Funcionario funcionario) {
		try {
			PreparedStatement preparedStatement = connection
    .prepareStatement("insert into funcionario(nome,telefone,cpf,rg,endereco,datanasc, setor) values (?, ?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getTelefone());
			preparedStatement.setString(3, funcionario.getCpf());
			preparedStatement.setString(4, funcionario.getRg());
                        preparedStatement.setString(5, funcionario.getEndereco());
                        preparedStatement.setString(6, funcionario.getDataNasc());
                        preparedStatement.setString(7, funcionario.getSetor());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFuncionario(int funcionarioId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from funcionario where funcionarioid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, funcionarioId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateFuncionario(Funcionario funcionario) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update funcionario set nome=?, telefone=?, cpf=?, rg=?, endereco=?, datanasc=?, setor=?" +
							"where funcionarioid=?");
			// Parameters start with 1
                        preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getTelefone());
			preparedStatement.setString(3, funcionario.getCpf());
			preparedStatement.setString(4, funcionario.getRg());
                        preparedStatement.setString(5, funcionario.getEndereco());
                        preparedStatement.setString(6, funcionario.getDataNasc());
                        preparedStatement.setString(7, funcionario.getSetor());
                        preparedStatement.setInt(8, funcionario.getCodFuncionario());
                        
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public List<Funcionario> getAllFuncionario() {
//		List<Funcionario> users = new ArrayList<Funcionario>();
//		try {
//                    
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("select * from users");
//			while (rs.next()) {
//				Funcionario funcionario = new Funcionario();
//				funcionario.setUserid(rs.getInt("userid"));
//				funcionario.setFirstName(rs.getString("firstname"));
//				funcionario.setLastName(rs.getString("lastname"));
//				funcionario.setDob(rs.getString("dob"));
//				funcionario.setEmail(rs.getString("email"));
//				users.add(funcionario);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return users;
//	}
//	
	public Funcionario getUserById(int funcionarioId) {
		Funcionario funcionario = new Funcionario();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from funcionario where funcionarioid=?");
			preparedStatement.setInt(1, funcionarioId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				funcionario.setCodFuncionario(rs.getInt("funcionarioid"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setRg(rs.getString("rg"));
				funcionario.setTelefone(rs.getString("telefone"));
                                funcionario.setSetor(rs.getString("setor"));
                                funcionario.setDataNasc(rs.getString("datanasc"));
                                funcionario.setEndereco(rs.getString("endereco"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionario;
	}
}