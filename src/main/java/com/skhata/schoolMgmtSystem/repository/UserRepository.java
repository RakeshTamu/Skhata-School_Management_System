package com.skhata.schoolMgmtSystem.repository;

import com.skhata.schoolMgmtSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Rakesh Gurung on 14,Aug,2019
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    /**
     * Get Username of user by id
     */
    @Query("SELECT username from User where id =:ID")
    String getUsernameById(@Param("ID") Long id);
}
