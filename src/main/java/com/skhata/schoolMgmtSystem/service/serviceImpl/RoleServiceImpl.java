package com.skhata.schoolMgmtSystem.service.serviceImpl;

import com.skhata.schoolMgmtSystem.exception.AppException;
import com.skhata.schoolMgmtSystem.exception.ResourceNotFoundException;
import com.skhata.schoolMgmtSystem.model.Role;
import com.skhata.schoolMgmtSystem.repository.RoleRepository;
import com.skhata.schoolMgmtSystem.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.skhata.schoolMgmtSystem.constants.Constants.SUPER_ADMIN_ROLE_NAME;
import static com.skhata.schoolMgmtSystem.constants.Messages.ROLE_ID_NOT_FOUND_MSG;
import static com.skhata.schoolMgmtSystem.constants.Messages.SUPER_ADMIN_ROLE_INVALIDATE_DELETE_MSG;

/**
 * Created by Rakesh Gurung on 19,Aug,2019
 */

@Service
public class RoleServiceImpl implements RoleService {
    private static final Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        LOG.info("Getting all Roles");
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        LOG.info("Getting Role info by id : " + id);

        return roleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(ROLE_ID_NOT_FOUND_MSG + id));
    }

    @Override
    public void addRole(Role role) {
        LOG.info("Adding new Role");
        roleRepository.save(role);
    }

    /**
     * Checks if role is super admin; user cannot be deleted
     * otherwise delete the role
     *
     * @param id role id
     */
    @Override
    public void deleteRoleById(Long id) {
        LOG.info("Deleting Role by id : " + id);
        if (!roleRepository.getRoleById(id).equals(SUPER_ADMIN_ROLE_NAME)) {
            roleRepository.deleteById(id);
        } else {
            LOG.error(SUPER_ADMIN_ROLE_INVALIDATE_DELETE_MSG);
            throw new AppException(SUPER_ADMIN_ROLE_INVALIDATE_DELETE_MSG);
        }
    }
}
