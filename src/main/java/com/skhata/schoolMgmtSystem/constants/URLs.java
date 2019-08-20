package com.skhata.schoolMgmtSystem.constants;

/**
 * Created by Rakesh Gurung on 15,Aug,2019
 */
public class URLs {

    public static final String ROOT_API_URL = "/api";
    public static final String AUTH_API_URL = "/auth";
    public static final String ALL_AUTH_API_URL = ROOT_API_URL + AUTH_API_URL + "/**";

    public static final String SIGN_IN_URL = AUTH_API_URL + "/sign_in";
    public static final String SIGN_UP_URL = AUTH_API_URL + "/sign_up";

   //User
    public static final String GET_USER_BY_ID_URL =  "/user/{id}";
    public static final String DELETE_USER_BY_ID_URL =  "/delete_user/{id}";
    public static final String GET_ALL_USERS_URL = "/users";

    //Role
    public static final String GET_ROLE_BY_ID_URL =  "/role/{id}";
    public static final String DELETE_ROLE_BY_ID_URL =  "/delete_role/{id}";
    public static final String GET_ALL_ROLES_URL = "/roles";
    public static final String ADD_ROLE_URL = "/add_role";

}
