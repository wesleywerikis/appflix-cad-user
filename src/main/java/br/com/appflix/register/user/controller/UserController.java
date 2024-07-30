package br.com.appflix.register.user.controller;

import java.sql.SQLException;

import br.com.appflix.register.user.dao.UserDao;
import br.com.appflix.register.user.entity.User;

public class UserController {

	private UserDao userDao;

	public UserController() {
		this.userDao = new UserDao();
	}

	public void addUser(User user) {
		try {
			userDao.insertUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User getUserById(Long id) {
		try {
			return UserDao.getUserById(id);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
