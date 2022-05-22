package com.example.configs.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true, updatable = false)
	private long id;
	@Column(nullable = false, updatable = false)
	private String name;
	@Column(unique = true, insertable = false, updatable = false)
	private String phone;

	public User(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
}
