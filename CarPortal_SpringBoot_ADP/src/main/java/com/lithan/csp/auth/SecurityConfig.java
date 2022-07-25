package com.lithan.csp.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	System.out.println("*****Inside configure Authentication*****");
    	auth.userDetailsService(userDetailsService())
    		.passwordEncoder(passwordEncoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	System.out.println("*****Inside configure HttpSecurity*****");
    	http
    		.formLogin()
	    		.loginPage("/login")
	    		.loginProcessingUrl("/login")
	    		.failureUrl("/login_error")
	    		//.permitAll()
	    		.defaultSuccessUrl("/cars", true)
    		.and()
    		.csrf()
    		.and()
    		.authorizeRequests()
    			//.antMatchers("/").permitAll()
    			.antMatchers("/img/**").permitAll()
    			.antMatchers("/style/**").permitAll()
    			.antMatchers("/script/**").permitAll()
    			.antMatchers(HttpMethod.GET, "/favicon.*").permitAll()
    			.antMatchers(HttpMethod.GET, "/login").permitAll()
    			//register controller
    			.antMatchers(HttpMethod.GET, "/register").permitAll()
    			.antMatchers(HttpMethod.POST, "/register").permitAll()
    			//profile controller
    			.antMatchers(HttpMethod.GET, "/profile").hasAnyRole("Users", "Admin")
    			.antMatchers(HttpMethod.GET, "/update_profile").hasAnyRole("Users", "Admin")
    			.antMatchers(HttpMethod.POST, "/update_profile").hasAnyRole("Users", "Admin")
    			//user controller
    			.antMatchers(HttpMethod.GET, "/users").hasRole("Admin")
    			.antMatchers(HttpMethod.GET, "/edit_user").hasRole("Admin")
    			.antMatchers(HttpMethod.POST, "/edit_user").hasRole("Admin")
    			.antMatchers(HttpMethod.GET, "/delete_user").hasRole("Admin")
    			.antMatchers(HttpMethod.GET, "/promote_user").hasRole("Admin")
    			//car controller
    			.antMatchers(HttpMethod.GET, "/cars").hasAnyRole("Users", "Admin")
    			.antMatchers(HttpMethod.GET, "new_car").hasAnyRole("Users", "Admin")
    			.antMatchers(HttpMethod.GET, "edit_car").hasAnyRole("Users", "Admin")
    			.antMatchers(HttpMethod.POST, "save_car").hasAnyRole("Users", "Admin")
    			.antMatchers(HttpMethod.GET, "car_detail").hasAnyRole("Users", "Admin")
    			.antMatchers(HttpMethod.GET, "delete_car").hasAnyRole("Users", "Admin")
    			.antMatchers(HttpMethod.POST, "car_detail").hasAnyRole("Users", "Admin")
    			.antMatchers(HttpMethod.GET, "search_param").hasAnyRole("Users", "Admin")
    			.antMatchers(HttpMethod.GET, "search_price").hasAnyRole("Users", "Admin")
    		.and()
    		.logout()
	    		.logoutSuccessUrl("/login")
	    		.invalidateHttpSession(true)
	    		.deleteCookies("JSESSIONID");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
