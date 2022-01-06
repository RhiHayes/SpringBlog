package com.example.springblog.controllers;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="car_owners")
public class Owner {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(nullable= false, length = 50)
        private String firstName;

        @Column(nullable= false, length = 50)
        private String lastName;

        @OneToMany
        private List<Car> vehicle;

//           @ManyToMany
//           @JoinTable(name="vehicles_owners"),
//           @JoinColumns = {@JoinColumn(name="owner_id")},

//           private List<Car> vehicle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
