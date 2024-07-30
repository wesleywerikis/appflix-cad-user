package br.com.appflix.register.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.appflix.dal.ModelConnection;
import br.com.appflix.register.user.entity.User;

public class UserDao {

	public void insertUser(User user) throws SQLException {
		String sql = "INSERT INTO tb_users (name, username, email, password) VALUES (?, ?, ?, ?)";
		try (Connection connection = ModelConnection.getConnection();
				PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getUsername());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPassword());
			stmt.executeUpdate();
		}
	}
	
	public static User getUserById(Long id) {
		Connection connection = ModelConnection.getConnection();
		if (connection != null) {
			try {
				String sql = "SELECT * FROM tb_users WHERE id = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setLong(1, id);
				ResultSet resultSet = statement.executeQuery();
				if (resultSet.next()) {
					User user = new User();
					user.setId(resultSet.getLong("id"));
					user.setName(resultSet.getString("name"));
					user.setUsername(resultSet.getString("username"));
					user.setPassword(resultSet.getString("password"));
					user.setEmail(resultSet.getString("email"));
					return user;
				}
			} catch (SQLException e) {
				System.err.println("Error getting user by ID from database: " + e.getMessage());
			} finally {
				ModelConnection.closeConnection();
			}
		}
		return null;
	}

}
