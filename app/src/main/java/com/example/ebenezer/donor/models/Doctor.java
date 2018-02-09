package com.example.ebenezer.donor.models;

import com.orm.SugarRecord;

/**
 * Created by EBENEZER on 2/2/2018.
 */

public class Doctor extends SugarRecord {
    private String name;
    private String contact;
    private String description;
    private String location;

    public Doctor() {
    }

    public Doctor(String name, String contact, String description, String location) {
        this.name = name;
        this.contact = contact;
        this.description = description;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
}


