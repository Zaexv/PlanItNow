package com.tfm.planitnow.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(tableName = "plans")
public class Plan implements Serializable {

	/* Class Attributes */
	@PrimaryKey
	private int id;

	@ColumnInfo(name = "title")
	private String title;

	@ColumnInfo(name = "description")
	private String description;

	@ColumnInfo(name = "location")
	private String location;

	@ColumnInfo(name = "init_hour")
	private Integer init_hour;

	@ColumnInfo(name = "end_hour")
	private Integer end_hour;

	@ColumnInfo(name = "init_date")
	private Date init_date;

	@ColumnInfo(name = "end_date")
	private Date end_date;

	@ColumnInfo(name = "is_public")
	private boolean is_public;

	@ColumnInfo(name = "main_image_uri")
	private String main_image_uri;


	@Ignore
	private Set<PlanType> plan_types;
	
	/* Relations */
	@Ignore
	private User owner;
	@Ignore
	private Set<Participation> joined_users; 


	/* Constructor */ 
	
	public Plan(int id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = "Valencia";
	}

	@Ignore
	public Plan(int id, String title, String description, String location) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
	}

	@Ignore
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


	public void setPlan_types(Set<PlanType> plan_types) { this.plan_types = plan_types; }


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

	public boolean isIs_public() {
		return is_public;
	}

	public void setIs_public(boolean is_public) {
		this.is_public = is_public;
	}

	public String getMain_image_uri() { return main_image_uri; }

	public void setMain_image_uri(String main_image_uri) { this.main_image_uri = main_image_uri; }

	
	/* Functions */ 
	


	public boolean isValid(){
		boolean initHourValid = (init_hour >= 00) && (init_hour <=  24);
		boolean endHourValid = (end_hour >= 00) && (end_hour <= 24);
		boolean hourValid = end_hour > init_hour;
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_MONTH, -1);
		boolean initDateValid = init_date.compareTo(c.getTime()) == 1;
		boolean titleValid = title != null;
		boolean descriptionValid = description != null;
		boolean locationValid = location != null;
		return initHourValid &&
				endHourValid &&
				hourValid &&
				initDateValid &&
				titleValid &&
				descriptionValid &&
				locationValid;
	}

	@NotNull
	@Override
	public String toString() {
		return "Plan [title=" + title + ", description=" + description + ", location=" + location + ", init_hour="
				+ init_hour + ", end_hour=" + end_hour + ", init_date=" + init_date + ", end_date=" + end_date + "]";
	}

	
}
