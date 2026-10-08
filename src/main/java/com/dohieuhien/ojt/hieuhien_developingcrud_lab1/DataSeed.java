package com.dohieuhien.ojt.hieuhien_developingcrud_lab1;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mysql.Role;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities.mysql.Users;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.repository.RoleRepo;
import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataSeed {
    @Bean
    CommandLineRunner seed(RoleRepo roleRepo, UserRepo userRepo, PasswordEncoder encoder) {
        return args -> {
            if(roleRepo.count() == 0){
                roleRepo.saveAll(List.of(
                        Role.builder().roleName("ADMIN").build(),
                        Role.builder().roleName("MANAGER").build(),
                        Role.builder().roleName("OPERATION").build(),
                        Role.builder().roleName("USER").build()
                ));
            }
            if (userRepo.count() == 0) {
                Role admin = roleRepo.findByRoleName("ADMIN").orElseThrow();
                userRepo.save(Users.builder()
                        .userid("U001").username("admin").email("admin@gmail.com")
                        .password(encoder.encode("123456")).role(admin).build());

                Role manager = roleRepo.findByRoleName("MANAGER").orElseThrow();
                userRepo.save(Users.builder()
                        .userid("U002").username("manager").email("manager@gmail.com")
                        .password(encoder.encode("123456")).role(manager).build());

                Role operation = roleRepo.findByRoleName("OPERATION").orElseThrow();
                userRepo.save(Users.builder()
                        .userid("U003").username("operation").email("operation@gmail.com")
                        .password(encoder.encode("123456")).role(operation).build());

                Role user = roleRepo.findByRoleName("USER").orElseThrow();
                userRepo.save(Users.builder()
                        .userid("U004").username("user").email("user@gmail.com")
                        .password(encoder.encode("123456")).role(user).build());
            }
        };
    }
}
