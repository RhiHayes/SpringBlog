package com.example.springblog.controllers;

import javax.persistence.*;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable= false, length = 50)
    private String make;

    @Column(nullable= false, length = 50)
    private String model;

    @ManyToOne
    private Owner carOwner;


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }


}
