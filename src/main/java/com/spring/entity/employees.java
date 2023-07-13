package com.spring.entity;

import java.io.Serializable;

import org.hibernate.annotations.CollectionId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@Entity
public class employees implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="First_Name")
	private String firstName;
	@Column(name ="Last_Name")
	private String lastName;
	@Column(name="Email_ID")
	private String emailID;
	private String jobTitle;
	private String phone;
	private String imgageURL;
	private String employeeCode;
	
	
}
