package com.ljc.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ljc.security.dao.UsersDao;
import com.ljc.security.pojo.Users;


@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyUserDetailsService.class);
	
	@Autowired
	private UsersDao usersDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//调用UsersDao方法，根据用户查询数据库
		QueryWrapper<Users> queryWrapper = new QueryWrapper<Users>();  //mybatisplus中的一个条件构造器
		queryWrapper.eq("username", username);
		Users users = usersDao.selectOne(queryWrapper);
		//判断
		if (users == null) {
			LOGGER.info("登录失败");
			throw new UsernameNotFoundException("该用户不存在！");
			
		} 
		LOGGER.info("用户名为："+users.getUsername()+"密码为："+users.getPassword());
		 //用来控制获取的用户具有的角色配置
		List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_root");
		
		return new User(users.getUsername(),new BCryptPasswordEncoder().encode(users.getPassword()),auths);
	}

}
