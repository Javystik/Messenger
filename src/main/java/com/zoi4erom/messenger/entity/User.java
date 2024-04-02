package com.zoi4erom.messenger.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Table(name = "users")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class User implements BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.PRIVATE)
	private Integer id;

	@Column(name = "login")
	private String login;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@ManyToMany(mappedBy = "users")
	private Set<Chat> chats = new HashSet<>();

	@OneToMany(mappedBy = "author")
	private List<Message> messageList = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private Set<Friend> friendships;

	public User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
		    "id=" + id +
		    ", login='" + login + '\'' +
		    ", password='" + password + '\'' +
		    ", email='" + email + '\'' +
		    '}';
	}
}
