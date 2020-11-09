package com.ljc.security.config;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
public class SecurityConfigCustom extends WebSecurityConfigurerAdapter {
	
	private final Log logger = LogFactory.getLog(SecurityConfigCustom.class);
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	/**
	 * springsecurity的默认登录页面
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//通过配置类完成授权,指定使用那个接口服务来进行用户登录认证
		auth.userDetailsService(userDetailsService).passwordEncoder(password());
	}

	
	/**
	 * 自定义自己的登录页面
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
		
		
		//退出到登录页面
		http.logout().logoutUrl("/logout").logoutSuccessUrl("/hello/word").permitAll();
		
		//自定义自己的403页面
		http.exceptionHandling().accessDeniedPage("/unauth.html");   //配置没有权限访问跳转自定义页面
		
		http.formLogin()  //自定义自己编写的登录页面
			.loginPage("/login.html")   //登录页面设置
			.loginProcessingUrl("/user/login")   //登录访问路径
			
			.defaultSuccessUrl("/seccess.html").permitAll()   //登录成功之后，跳转路径
			
			
			.and().authorizeRequests()   //那些页面需要认证，那些不需要
				.antMatchers("/","/user/login","/hello/word").permitAll()  //设置那些路径可以直接访问，不需要认证
				
				//当前登录用户，只有具有root权限才可以访问这个路径
				//1、hasAuthority
				//.antMatchers("/hello/index").hasAuthority("root")
				
				//2、hasAnyAuthority
				//.antMatchers("/hello/index").hasAnyAuthority("root,admin")
				
				//3、hasRole；通过他的源码可知，他默认会加一个RELO_的前缀
				//.antMatchers("/hello/index").hasRole("root")
				
				//4、hasAnyRole；通过他的源码可知，他默认会加一个RELO_的前缀
				.antMatchers("/hello/update1").hasAnyRole("root,admin")
				
				
				.anyRequest().authenticated()
				
				
				//设置记住我的功能，实现自动登录
				.and().rememberMe().tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(60)  //设置有效时长，单位是秒
				.userDetailsService(userDetailsService);
			
			//.and().csrf().disable();  //关闭csrf防护
	}
	
	@Bean
	PasswordEncoder password() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	
	//注入数据源
	@Autowired
	private DataSource dataSource;
	
	//配置对象
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl = new JdbcTokenRepositoryImpl();
		jdbcTokenRepositoryImpl.setDataSource(dataSource);
		return jdbcTokenRepositoryImpl;
		
	}
}