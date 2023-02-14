package com.saksoft.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER_DETAILS")
public class User {

	@Id
	@SequenceGenerator(name="User_sequence",sequenceName="User_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "User_sequence")
	@Column(name = "USER_ID")
	private Long id;
	
	@NotBlank(message = "First Name is missing")
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@NotBlank(message = "Last Name is missing")
	@Column(name = "LAST_NAME")
	private String lastName;
	@Email
	@Column(name = "email",unique = true)
	private String email;
	@Min(value=18, message="age min 18 is required")
	private Integer age;
}
