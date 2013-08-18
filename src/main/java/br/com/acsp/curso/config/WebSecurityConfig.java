package br.com.acsp.curso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * User: Christian Reichel Date: 8/9/13 Time: 10:13 PM
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeUrls()
                .antMatchers("/home*").permitAll()
                .antMatchers("/resources/**", "/css/*", "/js/*").permitAll()
                .antMatchers("/alunos/**").permitAll()
				.antMatchers("/aluno/**").permitAll()
				.antMatchers("/agendas/**").permitAll()
				.antMatchers("/agenda/**").permitAll()
				.antMatchers("/socios/**").permitAll()
				.antMatchers("/socio/**").permitAll()
				.antMatchers("/aulas/**").permitAll()
				.antMatchers("/aula/**").permitAll()
				.antMatchers("/instrutores/**").permitAll()
				.antMatchers("/instrutor/**").permitAll()
			
			
				.antMatchers("/aeronaves/**").permitAll()
				.antMatchers("/aeronave/**").permitAll().anyRequest()
				.authenticated().and().logout()
				.logoutSuccessUrl("/login.jsp?logout").logoutUrl("/logout.jsp")
				.permitAll().and().formLogin().defaultSuccessUrl("/alunos")
				.loginUrl("/login.jsp").failureUrl("/login.jsp?error")
				.permitAll();
	}

	@Override
	protected void registerAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("user1")
				.roles("USER").and().withUser("admin").password("admin1")
				.roles("ADMIN", "USER");
	}

}
