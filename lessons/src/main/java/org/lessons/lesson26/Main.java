package org.lessons.lesson26;

public class Main {

    public static void main(String[] args) {

        User user = new User("Ann");
        Address address = new Address("Dnipro", "Street", "45");
        user.setAddress(address);
        System.out.println(user.getName() + "\n" + user.getAddress());
    }
}
