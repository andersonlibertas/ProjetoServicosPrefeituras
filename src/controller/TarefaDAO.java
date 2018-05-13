package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Tarefa;


public class TarefaDAO {
	private Connection connection;
        
        public TarefaDAO() {
		connection = new Conecta().getConnection();
	}
	
        public void addTarefa(Tarefa tarefa) {
		try {
			PreparedStatement preparedStatement = connection
    .prepareStatement("insert into tarefa(data, validade, secretaria, tarefa, observacao, situacao, setor) values (?, ?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, tarefa.getData());
                        preparedStatement.setString(2, tarefa.getValidade());
                        preparedStatement.setString(3, tarefa.getSecretaria());
                        preparedStatement.setString(4, tarefa.getTarefa());
                        preparedStatement.setString(5, tarefa.getObservacao());
                        preparedStatement.setString(6, tarefa.getSituacao());
                        preparedStatement.setString(7, tarefa.getSetor());
                            
                        
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTarefa(int tarefaId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from tarefa where tarefaid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, tarefaId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateTarefa(Tarefa tarefa) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update tarefa set data=?, validade=?, secretaria=?, tarefa=?, observacao=?, situacao=?, setor=? " +
							"where tarefaid=?");
			// Parameters start with 1
                        preparedStatement.setString(1, tarefa.getData());
	                preparedStatement.setString(2, tarefa.getValidade());
        	        preparedStatement.setString(3, tarefa.getSecretaria());                
	                preparedStatement.setString(4, tarefa.getTarefa());
                        preparedStatement.setString(5, tarefa.getObservacao());
                        preparedStatement.setString(6, tarefa.getSituacao());
                        preparedStatement.setString(7, tarefa.getSetor());
                        preparedStatement.setInt(8, tarefa.getCodigo());
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
public Tarefa getUserById(int tarefaId) {
		Tarefa tarefa = new Tarefa();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from tarefa where tarefaid=?");
			preparedStatement.setInt(1, tarefaId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				tarefa.setCodigo(rs.getInt("tarefaid"));
				tarefa.setData(rs.getString("data"));
				tarefa.setValidade(rs.getString("validade"));
                                tarefa.setObservacao(rs.getString("observacao"));
                                tarefa.setTarefa(rs.getString("tarefa"));
                                tarefa.setSecretaria(rs.getString("secretaria"));
                                tarefa.setSituacao(rs.getString("situacao"));
                                tarefa.setSetor(rs.getString("setor"));
                                
                        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tarefa;
	}
}