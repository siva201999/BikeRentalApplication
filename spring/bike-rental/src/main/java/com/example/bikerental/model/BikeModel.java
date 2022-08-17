package com.example.bikerental.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Bikes")
public class BikeModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="brandName")
    private String brandName;
    @Column(name="modelName")
    private String modelName;
    @Column(name="bikeNumber")
    private String bikeNumber;
    @Column(name="bikeImage" ,columnDefinition="TEXT")
    private String bikeImage;
    @Column(name="description")
    private String description;
    @Column(name="rentAmount")
    private String rentAmount;
    @Column(name="pickUpLocation")
    private String pickUpLocation;
    @Column(name="availability")
    private String availability;
    

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getBrandName() {
        return brandName;
    }


    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }


    public String getModelName() {
        return modelName;
    }


    public void setModelName(String modelName) {
        this.modelName = modelName;
    }


    public String getBikeNumber() {
        return bikeNumber;
    }


    public void setBikeNumber(String bikeNumber) {
        this.bikeNumber = bikeNumber;
    }


    public String getBikeImage() {
        return bikeImage;
    }


    public void setBikeImage(String bikeImage) {
        this.bikeImage = bikeImage;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getRentAmount() {
        return rentAmount;
    }


    public void setRentAmount(String rentAmount) {
        this.rentAmount = rentAmount;
    }


    public String getPickUpLocation() {
        return pickUpLocation;
    }


    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }


    public String getAvailability() {
        return availability;
    }


    public void setAvailability(String availability) {
        this.availability = availability;
    }

    // public RenterModel getRenter() {
    //     return renter;
    // }


    // public void setRenter(RenterModel renter) {
    //     this.renter = renter;
    // }

    public BikeModel(Long id, String brandName, String modelName, String bikeNumber, String bikeImage,
            String description, String rentAmount, String pickUpLocation, String availability) {
        this.id = id;
        this.brandName = brandName;
        this.modelName = modelName;
        this.bikeNumber = bikeNumber;
        this.bikeImage = bikeImage;
        this.description = description;
        this.rentAmount = rentAmount;
        this.pickUpLocation = pickUpLocation;
        this.availability = availability;
        // this.renter = renter;
    }


    public BikeModel() {
    }


    @Override
    public String toString() {
        return "BikeModel [availability=" + availability + ", bikeImage=" + bikeImage + ", bikeNumber=" + bikeNumber
                + ", brandName=" + brandName + ", description=" + description + ", id=" + id + ", modelName="
                + modelName + ", pickUpLocation=" + pickUpLocation + ", rentAmount=" + rentAmount + "]";
    }


    

    

    

}
