package org.lessons.lesson42.controller;

import org.lessons.lesson42.entity.Post;
import org.lessons.lesson42.entity.User;
import org.lessons.lesson42.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUserWithPosts(user, user.getPosts()));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<User>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(userService.findByName(name));
    }

    @GetMapping("/{domain}")
    public ResponseEntity<List<User>> getByDomain(@RequestParam String domain) {
        return ResponseEntity.ok(userService.findByEmailDomain(domain));
    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findPostsByUserId(userId));
    }
}
