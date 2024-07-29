package br.com.appflix.register.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
