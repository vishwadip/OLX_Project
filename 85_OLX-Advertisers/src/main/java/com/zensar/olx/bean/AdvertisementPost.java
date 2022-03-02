package com.zensar.olx.bean;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@Entity
public class AdvertisementPost {
	@Column(name="adPost_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column
	private String title;
	
	@Column
	private double price;

	@Column
	private String description;
	
	@Embedded
	private Category category;
	
	@Embedded
	private OLXUser olxUser;
	
	@Embedded
	private AdvertisementStatus status;
	
	@Column
	private LocalDate createdDate;
	@Column
	private LocalDate modifiedDate;

	@Lob
	private byte[] photo;
	
	public AdvertisementPost() {
		super();
		this.createdDate=LocalDate.now();
		this.modifiedDate=LocalDate.now();
	}

	public AdvertisementPost(int id) {
		super();
		this.id = id;
	}
	
	
	public AdvertisementPost(String title, double price, String description, Category category, OLXUser olxUser,
			AdvertisementStatus status, LocalDate createdDate, LocalDate modifiedDate, byte[] photo) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
		this.category = category;
		this.olxUser = olxUser;
		this.status = status;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.photo = photo;
	}

	
	
	public AdvertisementPost(int id, String title, double price, String description, Category category, OLXUser olxUser,
			AdvertisementStatus status, LocalDate createdDate, LocalDate modifiedDate, byte[] photo) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.category = category;
		this.olxUser = olxUser;
		this.status = status;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.photo = photo;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public OLXUser getOlxUser() {
		return olxUser;
	}

	public void setOlxUser(OLXUser olxUser) {
		this.olxUser = olxUser;
	}

	public AdvertisementStatus getStatus() {
		return status;
	}

	public void setStatus(AdvertisementStatus status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "AdvertisementPost [id=" + id + ", title=" + title + ", description=" + description + ", category="
				+ category + ", olxUser=" + olxUser + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AdvertisementPost))
			return false;
		AdvertisementPost other = (AdvertisementPost) obj;
		return id == other.id;
	}
	
	
}
