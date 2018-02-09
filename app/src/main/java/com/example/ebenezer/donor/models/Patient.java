package com.example.ebenezer.donor.models;

import com.orm.SugarRecord;

/**
 * Created by EBENEZER on 2/2/2018.
 */

public class Patient extends SugarRecord{
    private String patient_name;
    private String blood_group;
    private String location;
    private String contact;

    public Patient() {
    }

    public Patient(String patient_name, String blood_group, String location, String contact) {
        this.patient_name = patient_name;
        this.blood_group = blood_group;
        this.location = location;
        this.contact = contact;
    }


    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
