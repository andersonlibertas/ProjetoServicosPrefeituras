package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Funcionario;
import model.Setor;


public class SetorDAO {
	private Connection connection;
        
        public SetorDAO() {
		connection = new Conecta().getConnection();
	}
	
        public void addSetor(Setor setor) {
		try {
			PreparedStatement preparedStatement = connection
    .prepareStatement("insert into setor(nome) values (?)");
			// Parameters start with 1
			preparedStatement.setString(1, setor.getNome());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteSetor(int funcionarioId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from setor where setorid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, funcionarioId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateSetor(Setor setor) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update setor set nome=? " +
							"where setorid=?");
			// Parameters start with 1
                        preparedStatement.setString(1, setor.getNome());
	                preparedStatement.setInt(2, setor.getCodigo());

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
public Setor getUserById(int setorId) {
		Setor setor = new Setor();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from setor where setorid=?");
			preparedStatement.setInt(1, setorId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				setor.setCodigo(rs.getInt("setorid"));
				setor.setNome(rs.getString("nome"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return setor;
	}
}