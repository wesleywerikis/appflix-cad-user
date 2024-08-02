package br.com.appflix.register.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.appflix.dal.ModelConnection;
import br.com.appflix.register.user.entity.User;

public class UserDao {

	public boolean addUser(User user) {
		String query = "INSERT INTO tb_users (name, username, password, email) VALUES (?, ?, ?, ?)";
		try (Connection connection = ModelConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			
			statement.setString(1, user.getName());
			statement.setString(2, user.getUsername());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getEmail());
			
			int rowsInserted = statement.executeUpdate();
			return rowsInserted > 0;
		} catch (Exception e) {
			System.err.println("Error inserting user: " + e.getMessage());
            return false;
		}
	}

}
