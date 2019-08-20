package com.skhata.schoolMgmtSystem.controller;

import com.skhata.schoolMgmtSystem.constants.Messages;
import com.skhata.schoolMgmtSystem.model.User;
import com.skhata.schoolMgmtSystem.payload.ApiResponse;
import com.skhata.schoolMgmtSystem.payload.JwtAuthenticationResponse;
import com.skhata.schoolMgmtSystem.payload.LoginRequest;
import com.skhata.schoolMgmtSystem.payload.SignUpRequest;
import com.skhata.schoolMgmtSystem.security.JwtTokenProvider;
import com.skhata.schoolMgmtSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.skhata.schoolMgmtSystem.Enum.UserStatus.INACTIVE;
import static com.skhata.schoolMgmtSystem.constants.Messages.EMAIL_ALREADY_TAKEN_MSG;
import static com.skhata.schoolMgmtSystem.constants.Messages.USERNAME_ALREADY_TAKEN_MSG;
import static com.skhata.schoolMgmtSystem.constants.URLs.*;

/**
 * Created by Rakesh Gurung on 14,Aug,2019
 */
@RestController
@RequestMapping(ROOT_API_URL)
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    /**
     * Sign In User
     *
     * @param loginRequest is payload for Login
     * @return Response as OK and Sends JWT
     */
    @PostMapping(SIGN_IN_URL)
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        User user = userService.getUserDetailsByUsername(loginRequest.getUsernameOrEmail());
        if (user.getStatus() == INACTIVE) {
            return new ResponseEntity<>(new ApiResponse(false, user.getUsername() + " have no permission to Log in"),
                    HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(true, jwt));
    }

    /**
     * Sign Up User
     *
     * @param signUpRequest model class
     * @return OK Response if response is success
     */
    @PostMapping(SIGN_UP_URL)
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userService.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new ApiResponse(false, USERNAME_ALREADY_TAKEN_MSG),
                    HttpStatus.BAD_REQUEST);
        }

        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ApiResponse(false, EMAIL_ALREADY_TAKEN_MSG),
                    HttpStatus.BAD_REQUEST);
        }
        User user = new User(signUpRequest.getFullName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword(), signUpRequest.getStatus(), signUpRequest.getRoles());
        userService.addUser(user);
        return ResponseEntity.ok(new ApiResponse(true, Messages.USER_REGISTERED_SUCCESSFULLY_MSG));
    }
}
