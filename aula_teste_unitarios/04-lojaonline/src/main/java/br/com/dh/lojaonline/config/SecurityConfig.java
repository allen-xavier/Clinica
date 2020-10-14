package br.com.dh.lojaonline.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
//		return BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select email, senha, habilitado" + 
					" from cliente" + 
					" where email = ?")
			.authoritiesByUsernameQuery("select email, autoridade" + 
					" from autorizacao" + 
					" where email = ?");//*/
		
		auth.inMemoryAuthentication()
    	.withUser("admin")
    	.password("password")
    	.roles("ADMIN");//*/
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/cliente").hasAnyRole("ADMIN", "USER")
			.antMatchers("/endereco").hasAnyRole("ADMIN", "USER")
			.antMatchers("/telefone").hasAnyRole("ADMIN", "USER")
			.antMatchers("/pedido").hasAnyRole("ADMIN", "USER")
			.and().httpBasic();
			;//*/
		http.csrf().disable()
    	.authorizeRequests()
    	.antMatchers(HttpMethod.POST, "/login").permitAll()
    	.anyRequest().authenticated()
    	.and().addFilterBefore(new JwtLoginFilter("/login", authenticationManager()),
    			UsernamePasswordAuthenticationFilter.class)
    	.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);//*/
	}

}
