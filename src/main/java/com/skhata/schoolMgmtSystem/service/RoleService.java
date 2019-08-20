package com.skhata.schoolMgmtSystem.service;

import com.skhata.schoolMgmtSystem.model.Role;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * Created by Rakesh Gurung on 19,Aug,2019
 */
public interface RoleService {

    /**
     * @return all Role Informations
     */
    public List<Role> getAllRoles();

    /**
     * @param id role id
     * @return role information by id
     */
    public Role getRoleById(Long id);

    /**
     * Add a new Role
     */
    public void addRole(Role role);

    /**
     * Delete Role by id
     *
     * @param id role id
     */
    public void deleteRoleById(Long id);
}
