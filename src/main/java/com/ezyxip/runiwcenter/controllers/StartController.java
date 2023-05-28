package com.ezyxip.runiwcenter.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class StartController {

    Logger logger = Logger.getLogger(StartController.class.getName());
    @RequestMapping("/")
    public String home(){
        return "welcome to  RUNIW WMS";
    }

    @RequestMapping("/authtest")
    public String authTokenManager(){
        logger.info("Попытка авторизации");
        return "token in";
    }

}
