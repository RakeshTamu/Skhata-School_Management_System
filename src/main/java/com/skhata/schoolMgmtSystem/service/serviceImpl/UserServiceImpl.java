package com.skhata.schoolMgmtSystem.service.serviceImpl;

import com.skhata.schoolMgmtSystem.exception.AppException;
import com.skhata.schoolMgmtSystem.exception.ResourceNotFoundException;
import com.skhata.schoolMgmtSystem.model.Role;
import com.skhata.schoolMgmtSystem.model.User;
import com.skhata.schoolMgmtSystem.repository.RoleRepository;
import com.skhata.schoolMgmtSystem.repository.UserRepository;
import com.skhata.schoolMgmtSystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.skhata.schoolMgmtSystem.constants.Constants.SUPER_ADMIN_USERNAME;
import static com.skhata.schoolMgmtSystem.constants.Messages.*;

/**
 * Created by Rakesh Gurung on 15,Aug,2019
 */

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long id) {
        LOG.info("Getting User info By Id : " + id);

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(USER_ID_NOT_FOUND_MSG + id));
    }

    @Override
    public List<User> getAllUsers() {
        LOG.info("Getting all Users");
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        LOG.info("Adding new User");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Role> roles = user.getRoles();
        List<Role> persistentRoles = new ArrayList<>();
        if (null != roles && !roles.isEmpty()) {
            for (Role role : roles) {
                if (role.getId() != 0) {
                    Role persistentRole = this.getRoleById(role.getId());
                    if (null != persistentRole) {
                        persistentRoles.add(persistentRole);
                    }
                }

            }

        }
        if (persistentRoles.size() > 0) {
            user.setRoles(persistentRoles);
        }
        userRepository.save(user);
    }

    private Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(ROLE_ID_NOT_FOUND_MSG + id));
    }

    /**
     * Checks if user is super admin; user cannot be deleted
     * otherwise delete the user
     *
     * @param id of User Id
     */
    @Override
    public void deleteUserById(Long id) {
        LOG.info("Deleting User by id : " + id);
        if (!userRepository.getUsernameById(id).equals(SUPER_ADMIN_USERNAME)) {
            userRepository.deleteById(id);
        } else {
            LOG.error(SUPER_ADMIN_USER_INVALIDATE_DELETE_MSG);
            throw new AppException(SUPER_ADMIN_USER_INVALIDATE_DELETE_MSG);
        }
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User getUserDetailsByUsername(String usernameOrEmail) {
        Optional<User> usersOptional = userRepository.findByUsername(usernameOrEmail);
        return usersOptional.get();
    }
}
