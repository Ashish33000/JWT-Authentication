package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurity {
     @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests((auth)->auth.requestMatchers("/masai/welcome/p").authenticated()
                .requestMatchers("masai/employee/admin").hasRole("admin")
                .requestMatchers("/masai/welcome","/masai/employee/register").permitAll()
        ).csrf().disable().httpBasic();
        return httpSecurity.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails shopOwner=User.withUsername("admin").password(passwordEncoder().encode("masaiapp123")).roles("ADMIN").build();
//        UserDetails customer= User.withUsername("user").password(passwordEncoder().encode("1234")).roles("NORMAL").build();
//        return new InMemoryUserDetailsManager(shopOwner,customer);
//    }

}
