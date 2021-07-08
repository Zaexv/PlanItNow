package com.tfm.planitnow.models;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Plan implements Serializable {

	/* Class Attributes */
	private int id;
	private String title, description, location; 
	private Integer init_hour, end_hour; 
	private Date init_date, end_date; 
	private Set<PlanType> plan_types; 
	
	/* Relations */
	
	private User owner;
	private Set<Participation> joined_users; 


	/* Constructor */ 
	
	public Plan(int id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = "Valencia";
	}

	public Plan(int id, String title, String description, String location) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
	}

	public Plan(String title, String description, String location,
			Date init_date, Date end_date,
			Integer init_hour, Integer end_hour,
			Set<PlanType> plan_types, User owner) {
		
		this.title = title; 
		this.description = description; 
		this.location = location;
		
		this.init_date = init_date;
		this.end_date = end_date;
		
		this.init_hour = init_hour; 
		this.end_hour = end_hour; 
		
		this.plan_types = plan_types;
		
		this.owner = owner; 
	
	}

	
	/* Getters and Setters */

	public int getId() { return id; }

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Integer getInit_hour() {
		return init_hour;
	}


	public void setInit_hour(Integer init_hour) {
		this.init_hour = init_hour;
	}


	public Integer getEnd_hour() {
		return end_hour;
	}


	public void setEnd_hour(Integer end_hour) {
		this.end_hour = end_hour;
	}


	public Date getInit_date() {
		return init_date;
	}


	public void setInit_date(Date init_date) {
		this.init_date = init_date;
	}


	public Date getEnd_date() {
		return end_date;
	}


	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}


	public Set<PlanType> getPlan_types() {
		return plan_types;
	}


	public void setPlan_types(Set<PlanType> plan_types) {
		this.plan_types = plan_types;
	}


	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}


	public Set<Participation> getJoined_users() {
		return joined_users;
	}


	public void setJoined_users(Set<Participation> joined_users) {
		this.joined_users = joined_users;
	}

	
	/* Functions */ 
	

	@NotNull
	@Override
	public String toString() {
		return "Plan [title=" + title + ", description=" + description + ", location=" + location + ", init_hour="
				+ init_hour + ", end_hour=" + end_hour + ", init_date=" + init_date + ", end_date=" + end_date + "]";
	}

	
}
