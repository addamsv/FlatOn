package com.example.demo.user;

import jakarta.persistence.*;

@Entity
@Table(name = "`user`")
public class User {
	@Id
	@SequenceGenerator(
			name = "user_sequence",
			sequenceName = "user_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_sequence"
	)
	private Long id;
	
	private String name;
	
	private String email;

	@Transient
	private String field;

	public User() {}
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public User(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getField() { return field; }

	public void setField(String field) { this.field = field; }
}
