package com.zoi4erom.messenger.entity;

public class User {
	private Integer id;
	private String login;
	private String password;
	private String email;

	public User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}
}
