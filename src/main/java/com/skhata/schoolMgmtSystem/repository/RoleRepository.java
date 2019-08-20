package com.skhata.schoolMgmtSystem.repository;

import com.skhata.schoolMgmtSystem.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Rakesh Gurung on 14,Aug,2019
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT name from Role where id =:ID")
    String getRoleById(@Param("ID") Long id);
}
