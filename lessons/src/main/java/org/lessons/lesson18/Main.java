package org.lessons.lesson18;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        User user1 = new User(1, "Ann", "ann.ann@gmail.com");
        User user2 = new User(2, "Zoe", "zoe.zoe@gmail.com");

        userRepository.addUser(user1);
        userRepository.addUser(user2);

        int id = 3;
        if (userRepository.findUserById(id).isEmpty()) {
            System.out.println("Користувача з id: " + id + " немає");
        } else {
            System.out.println(userRepository.findUserById(id).get());
        }

        String email = "zoe.zoe@gmail.com";
        if (userRepository.findUserByEmail(email).isEmpty()) {
            System.out.println("Користувача з email: " + email + " немає");
        } else {
            System.out.println(userRepository.findUserByEmail(email).get());
        }

        if (userRepository.findAllUsers().isEmpty()) {
            System.out.println("Repository пустий");
        }
        else {
            System.out.println(userRepository.findAllUsers().get());
        }
    }
}
