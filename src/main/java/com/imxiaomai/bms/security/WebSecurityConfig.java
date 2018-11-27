package com.imxiaomai.bms.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by hyy on 2018/1/5.
 */
@Slf4j
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("------webSecurity(configure)-----------");
        http.authorizeRequests()
                //多个匹配逗号分隔
                //.antMatchers("/css/**","/js/**","/images/**","/webjars/**","/error","/**/favicon.ico").permitAll()
                .antMatchers("/css/**", "/js/**", "/images/**", "/assets/**").permitAll()
                .antMatchers("/rest/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout").permitAll();

        //http.authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
    }

}
