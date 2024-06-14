package com.vishav.usercrud.user.repository;
import com.vishav.usercrud.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods can be defined here if needed
    User findByEmail(String email);
}


