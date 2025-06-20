package org.lessons.lesson42.repository;

import org.lessons.lesson42.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

}
