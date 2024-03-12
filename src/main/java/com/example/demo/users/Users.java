package com.example.demo.users;

import com.example.demo.address.Address;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(
		name = "users"
)
public class Users {
	@Id
	@SequenceGenerator(
			name = "users_sequence",
			sequenceName = "users_sequence",
			allocationSize = 1
	)
	@GeneratedValue
	(
			strategy = GenerationType.SEQUENCE,
			generator = "users_sequence"
	)
	@Schema(example = "1", description = "User ID")
	@Column(name = "id")
	private Long id;

	@Schema(example = "pass-1-asa", description = "User Password")
	@Column(name="password", nullable = false)
	private String password;

	@Schema(example = "a@a.a", description = "Users email")
	@Column(name="email", nullable = false)
	private String email;






/*	 !two directional relationship! */
	@OneToOne
	@JoinColumn(name="addrress_id")
	private Address address;

//	https://www.youtube.com/watch?v=CvDS6DltIno&list=PL41m5U3u3wwkJXP69jYLzBnFoldbDr5FR&index=9
/*	 !one directional relationship! */
//    Many User can be in one department
//     @ManyToOne
//     @JoinColumn(name="department_id")
//     private Department department;

	/*
	* Department class:
	* !one department to many users on-to-many!
	*  @ManyToOne
	*  private Department departmentM
	*
	*/
//	@OneToMany(mappedBy = "departmentM")
//	private List<Users> users;



	@Schema(example = "a@a.a - pass-1-asa", description = "Processing")
	@Transient
	private String field;

	public Users() {}

	public Users(String password, String email) {
		this.password = password;
		this.email = email;
	}

	public Users(Long id, String password, String email) {
		this.id = id;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users{id=" + id + ", password=" + password + ", email=" + email + "}";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) { this.id = id; }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getField() { return "field of " + this.password + this.field; }

	public void setField(String field) { this.field = field; }
}
