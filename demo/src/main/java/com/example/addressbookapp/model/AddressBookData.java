package com.example.addressbookapp.model;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
public class AddressBookData {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String phoneNumber;

    public AddressBookData() {}

    public AddressBookData(int id, String name, String city, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
