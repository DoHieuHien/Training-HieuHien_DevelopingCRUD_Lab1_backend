package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.impl;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.config.UserPrincipal;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mysql.Users;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.repository.UserRepo;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Users user = userRepo.findByUsername(username).orElseThrow( () -> new UsernameNotFoundException("User not found: "+ username));
        return new UserPrincipal(user);
    }
}
