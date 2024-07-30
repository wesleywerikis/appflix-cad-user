package br.com.appflix.register.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.appflix.dal.ModelConnection;
import br.com.appflix.register.user.entity.User;

public class UserDao {

	public static int saveUser(User user) {
		Connection connection = ModelConnection.getConnection();
		if (connection != null) {
			try {
				String sql = "INSERT INTO tb_users (name, username, password, email) VALUES (?, ?, ?, ?)";
				PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, user.getName());
				statement.setString(2, user.getUsername());
				statement.setString(3, user.getPassword());
				statement.setString(4, user.getEmail());
				statement.executeUpdate();

				ResultSet rs = statement.getGeneratedKeys();
				if (rs.next()) {
					int userId = rs.getInt(1);
					return userId;
				} else {
					return -1;
				}
			} catch (SQLException e) {
				System.err.println("Error inserting user into database: " + e.getMessage());
				return -1;
			} finally {
				ModelConnection.closeConnection();
			}
		} else {
			System.err.println("Error connecting to database.");
			return -1;
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

	public static boolean updateUser(User user) {
		Connection connection = ModelConnection.getConnection();
		if (connection != null) {
			try {
				String sql = "UPDATE tb_users SET name=?, username=?, password=?, email=? WHERE id=?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, user.getName());
				statement.setString(2, user.getUsername());
				statement.setString(3, user.getPassword());
				statement.setString(4, user.getEmail());
				statement.setLong(5, user.getId());
				int rowsUpdated = statement.executeUpdate();
				return rowsUpdated > 0;
			} catch (SQLException e) {
				System.err.println("Error updating user in database: " + e.getMessage());
			} finally {
				ModelConnection.closeConnection();
			}
		}
		return false;
	}

	public static boolean deleteUser(Long id) {
		Connection connection = ModelConnection.getConnection();
		if (connection != null) {
			try {
				String sql = "DELETE FROM tb_users WHERE id = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setLong(1, id);
				int rowsDeleted = statement.executeUpdate();
				return rowsDeleted > 0;
			} catch (SQLException e) {
				System.err.println("Error deleting user from database: " + e.getMessage());
			} finally {
				ModelConnection.closeConnection();
			}
		}
		return false;
	}

}
