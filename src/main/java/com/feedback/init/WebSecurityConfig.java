package com.feedback.init;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@SpringBootConfiguration
@ComponentScan(basePackages = { "com.feedback" }) // .controller

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/", "/home", "/css/**", "/dataUser/**", "/register", "/registration", "/default/**")

				
				.permitAll().antMatchers("/admin**").hasAnyAuthority("0,1")// admin, moderator

				.anyRequest().fullyAuthenticated().and().formLogin().loginPage("/login").failureUrl("/login?error")
				.usernameParameter("username").permitAll().and().logout().logoutUrl("/logout")
				.deleteCookies("remember-me").logoutSuccessUrl("/").permitAll().and().rememberMe();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
		auth.jdbcAuthentication().dataSource(this.dataSource).passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("select username,password,'true' as enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, authority from users where username=?");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}