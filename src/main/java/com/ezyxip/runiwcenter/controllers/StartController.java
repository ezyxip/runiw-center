package com.ezyxip.runiwcenter.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {
    @RequestMapping("/")
    public String home(){
        return "welcome to  RUNIW WMS";
    }

    @RequestMapping("/authtoken")
    public String authTokenManager(){
        return "token in";
    }

}
