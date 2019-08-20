package com.skhata.schoolMgmtSystem.controller;

import com.skhata.schoolMgmtSystem.model.Role;
import com.skhata.schoolMgmtSystem.payload.ApiResponse;
import com.skhata.schoolMgmtSystem.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.skhata.schoolMgmtSystem.constants.Messages.ROLE_ADDED_SUCCESSFULLY_MSG;
import static com.skhata.schoolMgmtSystem.constants.Messages.ROLE_DELETED_SUCCESSFULLY_MSG;
import static com.skhata.schoolMgmtSystem.constants.URLs.*;

/**
 * Created by Rakesh Gurung on 19,Aug,2019
 */
@RestController
@RequestMapping(ROOT_API_URL)
public class RoleController {
    private static final Logger LOG = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * @return all Role Informations
     */
    @GetMapping(GET_ALL_ROLES_URL)
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    /**
     * @param id role id
     * @return role information by id
     */
    @GetMapping(GET_ROLE_BY_ID_URL)
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    /**
     * Add a new Role
     */
    @PostMapping(ADD_ROLE_URL)
    public ResponseEntity<?> addRole(@Valid @RequestBody Role role) {
        roleService.addRole(role);
        return ResponseEntity.ok(new ApiResponse(true, ROLE_ADDED_SUCCESSFULLY_MSG));
    }

    /**
     * Delete Role by id
     *
     * @param id role id
     */
    @DeleteMapping(DELETE_ROLE_BY_ID_URL)
    public ResponseEntity<?> deleteRoleById(@PathVariable Long id) {
        roleService.deleteRoleById(id);
        return ResponseEntity.ok(new ApiResponse(true, ROLE_DELETED_SUCCESSFULLY_MSG));
    }
}
