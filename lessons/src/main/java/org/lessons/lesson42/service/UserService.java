package org.lessons.lesson42.service;

import org.springframework.transaction.annotation.Transactional;
import org.lessons.lesson42.entity.Post;
import org.lessons.lesson42.entity.User;
import org.lessons.lesson42.repository.PostRepository;
import org.lessons.lesson42.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public User createUserWithPosts(User user, List<Post> posts) {
        for (Post post : posts) {
            post.setUser(user);
        }
        user.setPosts(posts);
        if ("fail".equalsIgnoreCase(user.getName())) {
            throw new RuntimeException("Testing rollback");
        }
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<User> findByEmailDomain(String domain) {
        return userRepository.findByEmailEndingWith(domain);
    }

    @Transactional(readOnly = true)
    public List<Post> findPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }


}
