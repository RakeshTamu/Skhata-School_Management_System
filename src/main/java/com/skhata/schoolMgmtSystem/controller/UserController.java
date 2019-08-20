package com.skhata.schoolMgmtSystem.controller;

import com.skhata.schoolMgmtSystem.model.User;
import com.skhata.schoolMgmtSystem.payload.ApiResponse;
import com.skhata.schoolMgmtSystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.skhata.schoolMgmtSystem.constants.Messages.USER_DELETED_SUCCESSFULLY_MSG;
import static com.skhata.schoolMgmtSystem.constants.URLs.*;

/**
 * Created by Rakesh Gurung on 19,Aug,2019
 */
@RestController
@RequestMapping(ROOT_API_URL)
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * Get User info by id
     *
     * @param id user id
     * @return information of user
     */
    @GetMapping(GET_USER_BY_ID_URL)
    public User getUserById(@PathVariable Long id) {
        LOG.info("Getting information of User of id : " + id);
        return userService.getUserById(id);
    }

    /**
     * @return all information of Users
     */
    @GetMapping(GET_ALL_USERS_URL)
    public List<User> getAllUsers() {
        LOG.info("Getting all information of Users");
        return userService.getAllUsers();
    }

    /**
     * Delete User by user Id
     *
     * @param id user id
     */
    @DeleteMapping(DELETE_USER_BY_ID_URL)
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        LOG.info("Deleting User by id : " + id);
        userService.deleteUserById(id);
        return ResponseEntity.ok(new ApiResponse(true, USER_DELETED_SUCCESSFULLY_MSG));
    }
}
