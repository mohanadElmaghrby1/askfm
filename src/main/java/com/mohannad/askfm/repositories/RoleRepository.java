package com.mohannad.askfm.repositories;

import com.mohannad.askfm.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role , Long> {
    Role findByRole(String role);

}
