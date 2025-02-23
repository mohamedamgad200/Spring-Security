package com.example.springsecuritypractical.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @GetMapping
    public String get()
    {
        return"Get:admin";
    }
    @PostMapping
    public String Post()
    {
        return"Post:admin";
    }
    @PutMapping
    public String put()
    {
        return"Put:admin";
    }
    @DeleteMapping
    public String delete()
    {
        return"Delete:admin";
    }
}
