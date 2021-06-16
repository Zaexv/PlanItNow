package models;

import java.util.Date;
import java.util.List;

public class User {
	
	/* Class Attributes */ 
	
	private String name; 
	private String surname; 
	private String username;
	private String phone_number; 
	private Date birth_date; 
	private String biography;
	
	/* Relations */

	private List<Plan> created_plans; 
	private List<Affinity> affinity_types; 
	private List<Participation> joined_plans;
	
	/* Constructor */ 
	
	public User(String username) {
		this.username = username; 
	}
	
	/* Getters and Setters */ 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public List<Plan> getCreated_plans() {
		return created_plans;
	}
	public void setCreated_plans(List<Plan> created_plans) {
		this.created_plans = created_plans;
	}
	public List<Affinity> getAffinity_types() {
		return affinity_types;
	}
	public void setAffinity_types(List<Affinity> affinity_types) {
		this.affinity_types = affinity_types;
	}
	public List<Participation> getJoined_plans() {
		return joined_plans;
	}
	public void setJoined_plans(List<Participation> joined_plans) {
		this.joined_plans = joined_plans;
	} 
	
	/* Functions */ 
	
	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", biography=" + biography + "]";
	}
	
}
