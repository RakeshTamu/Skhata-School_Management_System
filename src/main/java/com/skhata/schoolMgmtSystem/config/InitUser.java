package com.skhata.schoolMgmtSystem.config;

import com.skhata.schoolMgmtSystem.model.Role;
import com.skhata.schoolMgmtSystem.model.User;
import com.skhata.schoolMgmtSystem.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.skhata.schoolMgmtSystem.Enum.UserStatus.ACTIVE;
import static com.skhata.schoolMgmtSystem.constants.Constants.*;

/**
 * Created by Rakesh Gurung on 18,Aug,2019
 */
@Component
public class InitUser {
    private static final Logger LOG = LoggerFactory.getLogger(InitUser.class);

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    /**
     * Create a User if User table is empty in database
     */
    @PostConstruct
    public void userCreator() {
        LOG.info("Checking User repository is empty or not");
        if (userRepository.count() == 0) {
            createUser();
        }

    }

    /**
     * Create User
     */
    private void createUser() {
        LOG.info("Creating SUPER ADMIN User");
        Role role = new Role(SUPER_ADMIN_ROLE_NAME);
        List<Role> roles = new ArrayList<>();
        roles.add(role);

        User user = new User(SUPER_ADMIN_FULL_NAME, SUPER_ADMIN_USERNAME, SUPER_ADMIN_EMAIL, passwordEncoder.encode(SUPER_ADMIN_PASSWORD), ACTIVE, roles);
        userRepository.save(user);
    }

}
