package br.com.casadocodigo.loja.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import br.com.casadocodigo.loja.daos.UsuarioDAO;

@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		CharacterEncodingFilter filter = new CharacterEncodingFilter();
	    filter.setEncoding("UTF-8");
	    filter.setForceEncoding(true);
	    http.addFilterBefore(filter,CsrfFilter.class);
	    
		http.authorizeRequests()
			.antMatchers("/produtos/form").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN")
			.antMatchers(HttpMethod.GET, "/produtos").hasRole("ADMIN")
			.antMatchers("/produtos/**").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("file:/Kiko/Files/").permitAll()
			.antMatchers("/carrinho/**").permitAll()
			.antMatchers("/files/**").permitAll()
			.antMatchers("/resources/**").permitAll()
			.anyRequest().authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(usuarioDao)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
}
