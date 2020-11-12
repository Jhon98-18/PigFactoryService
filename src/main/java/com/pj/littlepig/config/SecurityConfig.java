package com.pj.littlepig.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pj.littlepig.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.PrintWriter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityService securityService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService);
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring().antMatchers("/css/**", "/image/**", "/js/**");
        web.ignoring().anyRequest();
    }

    @Override//TODO：登录
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().permitAll().loginPage("/login.html")
                .loginProcessingUrl("/dologin")
                .successHandler((req, resp, auth) -> {
                    Object principal = auth.getPrincipal();
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(principal));
                    out.flush();
                    out.close();
                })
                .failureHandler((req, resp, e) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter();
                    out.write(e.getMessage());
                    out.flush();
                    out.close();
                })
                .and()
                .authorizeRequests()
                .antMatchers("/login.html", "/register", "register-save", "/error").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable().cors();
    }
}
