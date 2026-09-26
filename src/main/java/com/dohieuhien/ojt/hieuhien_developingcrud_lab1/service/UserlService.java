package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserlService {

    @Autowired
    private UserRepo userRepo;
}
