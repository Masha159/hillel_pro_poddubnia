package org.lessons.lesson26;


public class User {
    private String name;
    private Address address;

    public User(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return "name: " + name;
    }
}
