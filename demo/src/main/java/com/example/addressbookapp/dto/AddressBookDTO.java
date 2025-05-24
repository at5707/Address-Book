package com.example.addressbookapp.dto;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
@Data
public class AddressBookDTO {
	@NotEmpty(message = "Name cannot be null or empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\s]{2,}$", message = "Name is invalid")
    private String name;
    private String city;
    private String phoneNumber;

    public AddressBookDTO() {}

    public AddressBookDTO(String name, String city, String phoneNumber) {
        this.name = name;
        this.city = city;
        this.phoneNumber = phoneNumber;
    }

    // Getters
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
