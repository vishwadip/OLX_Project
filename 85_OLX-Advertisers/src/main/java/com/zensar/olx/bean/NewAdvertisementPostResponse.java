package com.zensar.olx.bean;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class NewAdvertisementPostResponse {
	
	
	int id;
	String title;
	double price;
	String Category;
	String description;
	String userName;
	LocalDate createdDate;
	LocalDate modifiedDate;
	String status;
	
	public NewAdvertisementPostResponse() {
		super();
	}
	public NewAdvertisementPostResponse(int id) {
		super();
		this.id = id;
	}
	public NewAdvertisementPostResponse(String title, double price, String category, String description,
			String userName, LocalDate createdDate, LocalDate modifiedDate, String status) {
		super();
		this.title = title;
		this.price = price;
		Category = category;
		this.description = description;
		this.userName = userName;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}
	public NewAdvertisementPostResponse(int id, String title, double price, String category, String description,
			String userName, LocalDate createdDate, LocalDate modifiedDate, String status) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		Category = category;
		this.description = description;
		this.userName = userName;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "NewAdvertisementPostResponse [id=" + id + ", title=" + title + ", price=" + price + ", Category="
				+ Category + ", description=" + description + ", userName=" + userName + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", status=" + status + "]";
	}
	
	

}
