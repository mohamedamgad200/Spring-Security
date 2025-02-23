package com.example.springsecuritypractical.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/management")
public class ManagerController {
    @GetMapping
    public String get()
    {
        return"Get:manager";
    }
    @PostMapping
    public String Post()
    {
        return"Post:manager";
    }
    @PutMapping
    public String put()
    {
        return"Put:manager";
    }
    @DeleteMapping
    public String delete()
    {
        return"Delete:manager";
    }
}
