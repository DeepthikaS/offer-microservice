package com.spring.mfpe.offer.entities;

import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Offer")
@Getter
@Setter

public class Offer{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//name of the offer
	@NotNull(message= "name should not be null")
	@NotBlank(message="name is mandaratory")
	@Size(min=5,max=15)
	private String name;
	
	//description of the offer
	@NotNull(message= "description should not be null")
	@NotBlank(message="descrption is mandaratory")
	@Size(min=5,max=50)
	private String description;
	
	//category of the offer
	@NotNull(message= "category should not be null")
	@NotBlank(message="category is mandaratory")
	@Size(min=5)
	private String category;

	// opening/creation date of the offer
	@NotNull(message= "opendate should not be null")
	@Column(name="open_date")
	private Date openDate;
	
	// engaged date ( when a buyer shows interest)
	@Column(name="engaged_date")
	private Date engagedDate;
	
	//closing date(when the buyer buys)
	@Column(name="closed_date")
	private Date closedDate;
	
	//employee who created the Offer
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="emp_id")
	private Employee emp;
	
	//employee which showed interest in the offer
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="engaged_emp_id")
	private Employee engagedEmp;
	
	//many employees can like many offers
	@JsonIgnore
	@ManyToMany(mappedBy = "likedOffers", fetch = FetchType.LAZY)
	private Set<Employee> likedByEmployees = new HashSet<>();
	
	//no of likes on an offer
	private int likes;
	
	//customized toString method
	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", openDate=" + openDate + ", engagedDate=" + engagedDate + ", closedDate=" + closedDate + ", likes="
				+ likes + "]";
	}
	
	
}
