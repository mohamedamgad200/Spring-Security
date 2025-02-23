package com.example.springsecuritypractical.cofig;

import com.example.springsecuritypractical.entity.permissions.Permission;
import com.example.springsecuritypractical.entity.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.springsecuritypractical.entity.role.Role.ADMIN;
import static com.example.springsecuritypractical.entity.role.Role.MANAGER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SpringSecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/**", "/error").permitAll()
                        .requestMatchers("/api/v1/management/**").hasAnyRole(ADMIN.name(),MANAGER.name())
                        .requestMatchers(HttpMethod.GET,"/api/v1/management/**").hasAnyAuthority(
                                Permission.ADMIN_READ.name(),
                                Permission.MANAGER_READ.name()
                                )
                        .requestMatchers(HttpMethod.POST,"/api/v1/management/**").hasAnyAuthority(
                                Permission.ADMIN_CREATE.name(),
                                Permission.MANAGER_CREATE.name()
                        )
                        .requestMatchers(HttpMethod.PUT,"/api/v1/management/**").hasAnyAuthority(
                                Permission.ADMIN_UPDATE.name(),
                                Permission.MANAGER_UPDATE.name()
                        )
                        .requestMatchers(HttpMethod.DELETE,"/api/v1/management/**").hasAnyAuthority(
                                Permission.ADMIN_DELETE.name(),
                                Permission.MANAGER_DELETE.name()
                        )
//                        .requestMatchers("/api/v1/admin/**").hasAnyRole(ADMIN.name())
//                        .requestMatchers(HttpMethod.GET,"/api/v1/admin/**").hasAnyAuthority(
//                                Permission.ADMIN_READ.name()
//                        )
//                        .requestMatchers(HttpMethod.POST,"/api/v1/admin/**").hasAnyAuthority(
//                                Permission.ADMIN_CREATE.name()
//                        )
//                        .requestMatchers(HttpMethod.PUT,"/api/v1/admin/**").hasAnyAuthority(
//                                Permission.ADMIN_UPDATE.name()
//                        )
//                        .requestMatchers(HttpMethod.DELETE,"/api/v1/admin/**").hasAnyAuthority(
//                                Permission.ADMIN_DELETE.name()
//                        )
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(
                                org.springframework.security.config.
                                        http.SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
