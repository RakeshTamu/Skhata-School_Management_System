package com.skhata.schoolMgmtSystem.security;

import com.skhata.schoolMgmtSystem.model.User;
import com.skhata.schoolMgmtSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.skhata.schoolMgmtSystem.constants.Messages.USER_ID_NOT_FOUND_MSG;
import static com.skhata.schoolMgmtSystem.constants.Messages.USER_NOT_FOUND_MSG;

/**
 * Created by Rakesh Gurung on 14,Aug,2019
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException(USER_NOT_FOUND_MSG + usernameOrEmail)
                );

        return UserPrincipal.create(user);
    }

    /**
     * This method is used by JWTAuthenticationFilter
     */
    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException(USER_ID_NOT_FOUND_MSG + id)
        );

        return UserPrincipal.create(user);
    }
}