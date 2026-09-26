package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;
}
