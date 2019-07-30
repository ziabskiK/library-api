package com.app.spring.repository;

import com.app.spring.model.book.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.email=:email")
    User findUserByEmail(@Param("email") String email);
}
