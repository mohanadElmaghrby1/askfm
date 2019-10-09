package com.mohannad.askfm.services;

import com.mohannad.askfm.model.Role;
import com.mohannad.askfm.repositories.RoleRepository;
import org.springframework.stereotype.Service;

/**
 * create by mohannad on 10/9/2019
 */
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
