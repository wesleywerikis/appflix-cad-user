package br.com.appflix.register.user.entity;

import lombok.Data;

@Data
public class User {
	
	private Long id;

	private String name;
	private String username;
	private String email;
	private String password;
	
}
