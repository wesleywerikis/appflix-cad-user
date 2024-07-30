package br.com.appflix.register.user.controller;

import java.sql.SQLException;

import br.com.appflix.register.user.dao.UserDao;
import br.com.appflix.register.user.entity.User;

public class UserController {

	private UserDao userDao;

	public UserController() {
		this.userDao = new UserDao();
	}

	public int addUser(User user) {
		int userId = userDao.saveUser(user);
		if (userId == -1) {
			System.err.println("Failed to add user.");
		}
		return userId;
	}

	public User getUserById(Long id) {
		User user = userDao.getUserById(id);
		if (user == null) {
			System.err.println("User not found.");
		}
		return user;
	}
	
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	public boolean deleteUser(Long id) {
		return userDao.deleteUser(id);
	}
}
