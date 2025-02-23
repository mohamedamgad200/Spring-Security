package com.example.springsecuritypractical.entity.role;

import com.example.springsecuritypractical.entity.permissions.Permission;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.springsecuritypractical.entity.permissions.Permission.*;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(Set.of(
            ADMIN_CREATE,
            ADMIN_DELETE,
            ADMIN_UPDATE,
            ADMIN_READ,
            MANAGER_CREATE,
            MANAGER_DELETE,
            MANAGER_READ,
            MANAGER_UPDATE
    )),
    MANAGER(Set.of(
            MANAGER_CREATE,
            MANAGER_DELETE,
            MANAGER_READ,
            MANAGER_UPDATE));

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities =
                new ArrayList<>(getPermissions()
                        .stream()
                        .map(permission ->
                                new SimpleGrantedAuthority(permission.getPermission()))
                        .toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }
}
