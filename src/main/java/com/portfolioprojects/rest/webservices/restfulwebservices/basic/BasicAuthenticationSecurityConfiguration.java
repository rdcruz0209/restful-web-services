package com.portfolioprojects.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {
// make a filter chain
// disabling csrf

    //by default authenticate all request
    //basic authentication
    //disabling csrf
    //stateless rest api
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (auth) -> auth
                        .requestMatchers(HttpMethod.OPTIONS)
                        .permitAll().anyRequest()
                        .authenticated()// this authenticates all request
        );
        http.httpBasic(Customizer.withDefaults()); //provides a pop-up authentication in the client
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.csrf().disable();
        return http.build();
    }


}
