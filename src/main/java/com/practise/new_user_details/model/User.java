package com.practise.new_user_details.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.List;
import lombok.Generated;

@Entity
@Table(
        name = "user_details"
)
public class User {
    @Id
    private String id;
    private String name;
    private Date birthDate;
    @OneToMany(
            mappedBy = "user"
    )
    @JsonManagedReference
    private List<Car> carowned;
    private transient Job jobdone;

    @Generated
    public User() {
    }

    @Generated
    public User(final String id, final String name, final Date birthDate, final List<Car> carowned, final Job jobdone) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.carowned = carowned;
        this.jobdone = jobdone;
    }

    @Generated
    public String getId() {
        return this.id;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public Date getBirthDate() {
        return this.birthDate;
    }

    @Generated
    public List<Car> getCarowned() {
        return this.carowned;
    }

    @Generated
    public Job getJobdone() {
        return this.jobdone;
    }

    @Generated
    public void setId(final String id) {
        this.id = id;
    }

    @Generated
    public void setName(final String name) {
        this.name = name;
    }

    @Generated
    public void setBirthDate(final Date birthDate) {
        this.birthDate = birthDate;
    }

    @Generated
    public void setCarowned(final List<Car> carowned) {
        this.carowned = carowned;
    }

    @Generated
    public void setJobdone(final Job jobdone) {
        this.jobdone = jobdone;
    }
}
