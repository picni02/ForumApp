package com.example.web_250;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.web_250.services.UserDetailService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Autowired
    private UserDetailService _UserDetailService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf()
        .disable()
        .authorizeHttpRequests()
        .antMatchers("/registration", "/").permitAll()
        .antMatchers("/registration/**").permitAll()
        .antMatchers("/event").permitAll()
        .antMatchers("/event/{id}").permitAll()
        .antMatchers("/addcategory").hasAuthority("ADMIN")
        .antMatchers("/adminpanel").hasAuthority("ADMIN")
        .antMatchers("/getlocations").hasAuthority("ADMIN")
        .antMatchers("/getcategories").hasAuthority("ADMIN")
        .antMatchers("/addcomment").hasAuthority("ADMIN")
        .antMatchers("/banuser/{useremail}").hasAuthority("ADMIN")
        .antMatchers("/addcomment").hasAuthority("USER")
        .antMatchers("/css/**").permitAll()
        .antMatchers("/bootstrap/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin(form -> form
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .failureUrl("/login?error")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/", true)
            .permitAll())
        .logout(
            logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .clearAuthentication(true)
                .permitAll())
        .rememberMe()
        .key("security-remember-secret")
        .tokenValiditySeconds(86400)
        .and()
        .userDetailsService(_UserDetailService)
        .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

