package com.ezyxip.runiwcenter.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class ToolsController {
    @RequestMapping("tools/roles")
    public String showRoles(){
        String res = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<GrantedAuthority> authorityList = (Collection<GrantedAuthority>) authentication.getAuthorities();
        for(GrantedAuthority i : authorityList){
            res += i.getAuthority() + ", ";
        }
        return res;
    }
}
