package com.ezyxip.runiwcenter.configurers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfigure {

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth ->{
            auth.requestMatchers("/").permitAll().anyRequest().authenticated();
        })
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        UserDetails startModule = User.builder()
                .username("startModule")
                .password("{noop}startMPassword")
                .roles("AUTHSERVICE")
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        //users.createUser(startModule);
        return users;
    }
}
