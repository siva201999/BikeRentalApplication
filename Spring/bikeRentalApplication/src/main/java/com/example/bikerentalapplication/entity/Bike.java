package com.example.bikerentalapplication.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bike")
public class Bike {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bikeId;
	private String modelName;
	private String brandName;
	private String pickUpLocation;
	private boolean availability;
	private String bikeNumber;
	private int rentAmount;
	private int renterId;
	private String bikeImageUrl;
	private String description;

	public String getBikeImageUrl() {
		return bikeImageUrl;
	}
	public void setBikeImageUrl(String bikeImageUrl) {
		this.bikeImageUrl = bikeImageUrl;
	}
	
	public int getRenterId() {
		return renterId;
	}
	public void setRenterId(int renterId) {
		this.renterId = renterId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getBikeId() {
		return bikeId;
	}
	public void setBikeId(long bikeId) {
		this.bikeId = bikeId;
	}
	public String getBikeNumber() {
		return bikeNumber;
	}
	public void setBikeNumber(String bikeNumber) {
		this.bikeNumber = bikeNumber;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getPickUpLocation() {
		return pickUpLocation;
	}
	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public int getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(int rentAmount) {
		this.rentAmount = rentAmount;
	}	
	public Bike() {
		super();
	}
	public Bike(long bikeId, String bikeNumber, String modelName, String brandName, String pickUpLocation,
			boolean availability, int rentAmount) {
		super();
		this.bikeId = bikeId;
		this.bikeNumber = bikeNumber;
		this.modelName = modelName;
		this.brandName = brandName;
		this.pickUpLocation = pickUpLocation;
		this.availability = availability;
		this.rentAmount = rentAmount;
	}
	
}
