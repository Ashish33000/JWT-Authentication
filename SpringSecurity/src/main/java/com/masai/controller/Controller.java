package com.masai.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/masai")
public class Controller {

    @GetMapping("/welcome")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public String geturl(){
        return "This api is without Spring  Security";
    }
    @GetMapping("/welcome/p")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public String security(){
        return "This api is with Spring  Security";
    }
}
