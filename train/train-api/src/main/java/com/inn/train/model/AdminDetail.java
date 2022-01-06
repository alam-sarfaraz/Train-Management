package com.inn.train.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADMIN_DETAIL")
public class AdminDetail {

	public enum role {
		ADMIN, USER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@NotBlank(message="First Name is mandatory")
	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="MIDDLE_NAME")
	private String middleName;

	@NotBlank(message="Last Name is mandatory")
	@Column(name="LAST_NAME")
	private String lastName;

	@Email(message="Invalid email address")
	@NotBlank(message="Email Id is mandatory")
	@Column(name="EMAIL_ID")
	private String emailId;

	@NotBlank(message="Mobile Number is mandatory")
	@Size(max=10,message="Mobile number must be 10 digit")
	@Column(name="MOBILE_NUMBER")
	private String mobileNumber;

	@Size(min=8 ,max=50,message="Password must be in between 8 to 50 character")
	@NotBlank(message="Password is mandatory")
	@Column(name="PASSWORD")
	private String password;

	@Size(min=8 ,max=50,message="Confirm Password must be in between 8 to 50 character")
	@NotBlank(message="Confirm Password is mandatory")
	@Column(name="CONFIRM_PASSWORD")
	private String confirmPassword;

	@NotBlank(message = "Role is mandatory")
	@Column(name = "ROLE")
	private String role;

	@Column(name="ADDRESS")
	private String address;

}
