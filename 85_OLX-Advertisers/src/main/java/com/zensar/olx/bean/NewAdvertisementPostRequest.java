package com.zensar.olx.bean;

import java.util.Objects;

public class NewAdvertisementPostRequest {
	
	int id;
	String title;
	int categoryId;
	String description;
	double price;
	int statusId;
	
	public NewAdvertisementPostRequest() {
		super();
	}
	
	public NewAdvertisementPostRequest(int id) {
		super();
		this.id = id;
	}
	
	
	public NewAdvertisementPostRequest(String title, int categoryId, String description, double price, int statusId) {
		super();
		this.title = title;
		this.categoryId = categoryId;
		this.description = description;
		this.price = price;
		this.statusId = statusId;
	}
	
	

	public NewAdvertisementPostRequest(int id, String title, int categoryId, String description, double price,
			int statusId) {
		super();
		this.id = id;
		this.title = title;
		this.categoryId = categoryId;
		this.description = description;
		this.price = price;
		this.statusId = statusId;
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof NewAdvertisementPostRequest))
			return false;
		NewAdvertisementPostRequest other = (NewAdvertisementPostRequest) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "NewAdvertisementPostRequest [id=" + id + ", title=" + title + ", categoryId=" + categoryId
				+ ", description=" + description + ", price=" + price + "]";
	}
	
	
	

}
