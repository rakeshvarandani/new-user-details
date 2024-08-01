package com.practise.new_user_details.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.Generated;

@Entity
@Table(
        name = "car_details"
)
public class Car {
    @Id
    private String carId;
    private String carName;
    private String carCompany;
    private Date purchaseDate;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    @JsonBackReference
    private User user;

    @Generated
    public String getCarId() {
        return this.carId;
    }

    @Generated
    public String getCarName() {
        return this.carName;
    }

    @Generated
    public String getCarCompany() {
        return this.carCompany;
    }

    @Generated
    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    @Generated
    public User getUser() {
        return this.user;
    }

    @Generated
    public void setCarId(final String carId) {
        this.carId = carId;
    }

    @Generated
    public void setCarName(final String carName) {
        this.carName = carName;
    }

    @Generated
    public void setCarCompany(final String carCompany) {
        this.carCompany = carCompany;
    }

    @Generated
    public void setPurchaseDate(final Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Generated
    public void setUser(final User user) {
        this.user = user;
    }

    @Generated
    public Car() {
    }

    @Generated
    public Car(final String carId, final String carName, final String carCompany, final Date purchaseDate, final User user) {
        this.carId = carId;
        this.carName = carName;
        this.carCompany = carCompany;
        this.purchaseDate = purchaseDate;
        this.user = user;
    }
}