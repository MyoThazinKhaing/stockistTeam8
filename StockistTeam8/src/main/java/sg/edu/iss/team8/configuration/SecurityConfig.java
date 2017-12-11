package sg.edu.iss.team8.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password from User where username=?")
				.authoritiesByUsernameQuery("select username, role from User where username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/product/**").access("hasRole('admin','mechanic')")
				.antMatchers("/user/**").access("hasRole('admin')")
				.and()
			.formLogin()
				.loginProcessingUrl("/login")
				.loginPage("/login")
				.defaultSuccessUrl("/error")
				.failureUrl("/login?error")
				.usernameParameter("j_username")
				.passwordParameter("j_password")
				.permitAll()
				.and()
			.logout()
				.logoutSuccessUrl("/login?logout")
				.and()
			.exceptionHandling()
				.accessDeniedPage("/403")
				.and();
	}
}
