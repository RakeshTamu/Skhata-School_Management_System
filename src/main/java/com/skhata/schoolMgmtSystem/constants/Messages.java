package com.skhata.schoolMgmtSystem.constants;

/**
 * Created by Rakesh Gurung on 15,Aug,2019
 */
public class Messages {

    public static final String USER_NOT_FOUND_MSG = "User not found with this username or email : ";
    public static final String USER_ID_NOT_FOUND_MSG = "User not found with id : ";
    public static final String ROLE_ID_NOT_FOUND_MSG = "Role not found with id : ";

    //Error Messages
    public static final String USERNAME_ALREADY_TAKEN_MSG = "Username is already taken!";
    public static final String EMAIL_ALREADY_TAKEN_MSG = "Email Address already in use!";
    public static final String USERNAME_EMAIL_EMPTY_MSG = "Username or Email should not be empty";
    public static final String USERNAME_EMPTY_MSG = "Username should not be empty";
    public static final String USERNAME_LENGTH_INVALID_MSG = "Username should be more than 3 and less than 45 characters";
    public static final String EMAIL_EMPTY_MSG = "Email should not be empty";
    public static final String EMAIL_LENGTH_INVALID_MSG = "Email should be more than 6 and less than 45 characters";
    public static final String EMAIL_INVALID_MSG = "The Email Address is invalid";
    public static final String PASSWORD_EMPTY_MSG = "Password should not be empty";
    public static final String PASSWORD_LENGTH_INVALID_MSG = "Password should be more than 6 and less than 45 characters";
    public static final String ROLE_NAME_EMPTY_MSG = "Password should be more than 6 and less than 45 characters";
    public static final String ROLE_NAME_LENGTH_INVALID_MSG = "Role name should be more than 2 and less than 45 characters";
    public static final String FULL_NAME_EMPTY_MSG = "Full name should not be empty";
    public static final String FULL_NAME_LENGTH_INVALID_MSG = "Full name should be more than 4 and less than 45 characters";
    public static final String SUPER_ADMIN_USER_INVALIDATE_DELETE_MSG = "Super Admin User cannot be Deleted";
    public static final String SUPER_ADMIN_ROLE_INVALIDATE_DELETE_MSG = "Super Admin Role cannot be Deleted";

    //Success Messages
    public static final String USER_REGISTERED_SUCCESSFULLY_MSG = "User registered successfully";
    public static final String USER_DELETED_SUCCESSFULLY_MSG = "User deleted successfully";
    public static final String ROLE_ADDED_SUCCESSFULLY_MSG = "Role added successfully";
    public static final String ROLE_DELETED_SUCCESSFULLY_MSG = "Role deleted successfully";
}
