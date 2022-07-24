package com.spring.mfpe.offer.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Employee")
@Getter
@Setter
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// name of the employee

	@NotNull(message= "name shouuld not be null")
	@NotBlank(message="name is mandatory")
	@Size(min=4,max=15)
	private String name;

	// department of the employee
	@NotNull(message="department should not be null")
	@NotBlank(message="department is mandatory")
	@Size(min=2,max=15)
	private String department;

	// gender
	@NotNull(message="gender should not be null")
	@NotBlank(message="gender is mandatory")
	private String gender;

	// age
    @NotNull(message="age should not be null")
	private int age;

	// contact info
    @NotNull(message="contact_number should not be null")
	@Column(name="contact_number")
	private Long contactNumber;

	// email id
    @NotNull(message="email should not be null")
    @NotBlank(message="email is mandatory")
    @Size(min=7)
	private String email;

    @NotNull(message="password should not be null")
    @NotBlank(message="password is mandatory")
    @Size(min=5)
	private String password;
    
	// points gained by the employee
	@Column(name="points_gained")
	private int pointsGained;

	// one employee can have many offers
	@OneToMany(mappedBy = "emp", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Offer> offers;

	// one employee can be engaged in many offers
	@OneToMany(mappedBy = "engagedEmp", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Offer> engagedInOffers;

	// many employees can like many offers
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinTable(name="liked_by", 
		joinColumns = {
				@JoinColumn(name="emp_id",referencedColumnName="id")
		},
		inverseJoinColumns = {
				@JoinColumn(name="offer_id",referencedColumnName="id")
		})
	private Set<Offer> likedOffers = new HashSet<>();

	//customized toString
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", gender=" + gender + ", age="
				+ age + ", contactNumber=" + contactNumber + ", email=" + email + ", pointsGained=" + pointsGained+"]";
	}

}
