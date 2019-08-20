package com.skhata.schoolMgmtSystem.service;

import com.skhata.schoolMgmtSystem.model.User;

import java.util.List;

/**
 * Created by Rakesh Gurung on 15,Aug,2019
 */
public interface UserService {

    /**
     * Get User info by User Id
     *
     * @param id of User
     * @return User info
     */
    User getUserById(Long id);

    /**
     * Get List of User Details
     *
     * @return List of User Details
     */
    List<User> getAllUsers();

    /**
     * Add a new User
     */
    void addUser(User user);

    /**
     * Delete User by Id
     *
     * @param id of User Id
     */
    void deleteUserById(Long id);

    /**
     * Check if Username exists or not
     */
    Boolean existsByUsername(String username);

    /**
     * Check if Email address exists or not
     */
    Boolean existsByEmail(String email);

    /**
     * Get Userdetails by Username
     *
     * @return user details of Logged in User
     * @param usernameOrEmail
     */
    public User getUserDetailsByUsername(String usernameOrEmail);

}
