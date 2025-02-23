package com.example.springsecuritypractical;

import com.example.springsecuritypractical.dto.AuthenticationRequest;
import com.example.springsecuritypractical.entity.User;
import com.example.springsecuritypractical.entity.role.Role;
import com.example.springsecuritypractical.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.springsecuritypractical.entity.role.Role.ADMIN;
import static com.example.springsecuritypractical.entity.role.Role.MANAGER;

@SpringBootApplication
public class SpringsecuritypracticalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsecuritypracticalApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner( AuthenticationService authenticationService) {
//        return args -> {
//            AuthenticationRequest Admin = AuthenticationRequest
//                    .builder()
//                    .firstName("admin")
//                    .lastName("amgad")
//                    .email("admin@admin.com")
//                    .password("admin")
//                    .role(ADMIN)
//                    .build();
//            System.out.println("Admin Acess Token is " + authenticationService.register(Admin).getToken());
//            AuthenticationRequest Manager = AuthenticationRequest
//                    .builder()
//                    .firstName("manager")
//                    .lastName("managaer")
//                    .email("manager@admin.com")
//                    .password("manager")
//                    .role(MANAGER)
//                    .build();
//            System.out.println("Manager Acess Token is " + authenticationService.register(Manager).getToken());
//        };
//
//    }
}
