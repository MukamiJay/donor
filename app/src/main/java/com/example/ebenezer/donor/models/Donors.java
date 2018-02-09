package com.example.ebenezer.donor.models;

import com.orm.SugarRecord;

import org.w3c.dom.ProcessingInstruction;

/**
 * Created by EBENEZER on 2/2/2018.
 */

public class Donors extends SugarRecord {
    private String name;
    private String bloodgroup;
    private String contact;
    private  String location;


    public Donors() {
    }

    public Donors(String name, String bloodgroup, String contact, String location) {
        this.name = name;
        this.bloodgroup = bloodgroup;
        this.contact = contact;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

