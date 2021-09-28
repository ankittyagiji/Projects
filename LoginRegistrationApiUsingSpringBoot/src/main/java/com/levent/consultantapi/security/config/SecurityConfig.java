
package com.levent.consultantapi.security.config;

 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

 

@SuppressWarnings({ "deprecation", "unused" })

@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

 

                @Autowired

                PasswordEncoder passwordEncoder;

 

                @Bean

                public PasswordEncoder passwordEncoder() {

                                return new BCryptPasswordEncoder();

                }

               

                @Bean

                public WebMvcConfigurerAdapter corsConfigurer() {

                                return new WebMvcConfigurerAdapter() {

                                                public void addCorsMappings(CorsRegistry registry) {

                                                                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")

                                                                                .allowedHeaders("*");

                                                }

                                };

                }

 

/*           @Override

                protected void configure(HttpSecurity http) throws Exception {

                                http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();

                }*/

 

                @Override

                protected void configure(AuthenticationManagerBuilder auth) throws Exception {

                                auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("user")

                                                                .password(passwordEncoder.encode("123456")).roles("USER").and().withUser("admin")

                                                                .password(passwordEncoder.encode("123456")).roles("USER", "ADMIN");

                }

 

               

                  @Override protected void configure(HttpSecurity http) throws Exception {

                  http.authorizeRequests() .antMatchers("/") .permitAll() .antMatchers("/**")

                  .hasAnyRole("ADMIN", "USER") .and() .formLogin() .loginPage("/login").permitAll()

                  .defaultSuccessUrl("/home") .failureUrl("/login?error=true") .permitAll()

                  .and() .logout() .logoutSuccessUrl("/login?logout=true")

                  .invalidateHttpSession(true) .permitAll() .and() .csrf() .disable(); }

               

}