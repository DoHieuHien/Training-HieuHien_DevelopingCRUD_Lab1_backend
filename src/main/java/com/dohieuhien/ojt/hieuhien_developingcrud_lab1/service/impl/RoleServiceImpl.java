package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.impl;


import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mysql.Role;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.repository.RoleRepo;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role findByRoleName(String rolename) {
        return roleRepo.findByRoleName(rolename).orElseThrow(() -> new EntityNotFoundException("Role not found: " +rolename));
    }
}
