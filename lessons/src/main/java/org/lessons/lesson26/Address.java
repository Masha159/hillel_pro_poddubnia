package org.lessons.lesson26;

public class Address {
    private String city;
    private String street;
    private String numberOfBuilding;

    public Address(String city, String street, String numberOfBuilding) {
        this.city = city;
        this.street = street;
        this.numberOfBuilding = numberOfBuilding;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getNumberOfBuilding() {
        return numberOfBuilding;
    }

    @Override
    public String toString() {
        return "Address: city: " + city +
                ", street: " + street +
                ", numberOfBuilding: " + numberOfBuilding;
    }
}
