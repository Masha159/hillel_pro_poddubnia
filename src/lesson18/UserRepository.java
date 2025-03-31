package lesson18;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserRepository {
    List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public Optional<User> findUserById(int id){
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

    public Optional<User> findUserByEmail(String email){
        return users.stream().filter(user -> Objects.equals(user.getEmail(), email)).findFirst();
    }

    public Optional<List<User>> findAllUsers(){
        return users.isEmpty() ? Optional.empty() : Optional.of(users);
    }
}
