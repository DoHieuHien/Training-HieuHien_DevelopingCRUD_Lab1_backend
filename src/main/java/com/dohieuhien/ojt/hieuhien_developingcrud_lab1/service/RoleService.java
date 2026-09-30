package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mysql.Role;

public interface RoleService {
    Role findByRoleName(String rolename);
}
