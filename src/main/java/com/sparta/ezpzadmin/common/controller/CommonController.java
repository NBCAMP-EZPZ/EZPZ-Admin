package com.sparta.ezpzadmin.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
