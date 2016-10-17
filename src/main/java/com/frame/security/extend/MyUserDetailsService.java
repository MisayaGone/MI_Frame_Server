package com.frame.security.extend;

import com.frame.security.entity.SystemAuthority;
import com.frame.security.entity.SystemRole;
import com.frame.security.entity.SystemUser;
import com.frame.security.service.ISystemAuthorityService;
import com.frame.security.service.ISystemUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Author: 居泽平  Date: 14-3-27, 下午3:42
 */
public class MyUserDetailsService implements UserDetailsService {

	private final static Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

	private ISystemUserService systemUserService;

	private ISystemAuthorityService systemAuthorityService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

		// 获取角色具备权限
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		// 使用User服务类查询数据用户是否存在,如不存在或密码错误则抛出对应的异常
		SystemUser user = this.systemUserService.getByUserAccount(username);
		if (null == user) {
			throw new UsernameNotFoundException("用户/密码错误,请重新输入!");
		}
		logger.info("user info [{}]", user.getUserName());

		if ("admin".equals(user.getUserAccount())) {
			grantedAuthorities.add(new SimpleGrantedAuthority("仓库管理"));
			grantedAuthorities.add(new SimpleGrantedAuthority("系统用户"));
			grantedAuthorities.add(new SimpleGrantedAuthority("系统角色"));
			grantedAuthorities.add(new SimpleGrantedAuthority("系统权限"));

			user.setSystemRole(user.getSystemRole()==null?new SystemRole(): user.getSystemRole());
		}

		// 获取用户角色
		SystemRole role = user.getSystemRole();
		if (null == role) {
			throw new UsernameNotFoundException("权限不足!");
		}

		logger.info("用户角色:[{}]", role.getRoleName());
		List<SystemAuthority> authorityList = systemAuthorityService.getAuthoritiesByRoleId(role.getId());
		if (CollectionUtils.isEmpty(authorityList) && !"admin".equals(user.getUserAccount())) {
			throw new UsernameNotFoundException("权限不足!");
		}

		for (SystemAuthority auth : authorityList) {
			logger.info("拥有权限:[{}]", auth.getAuthorityName());
			grantedAuthorities.add(new SimpleGrantedAuthority(auth.getAuthorityName()));
		}

		return new User(username, user.getUserPassword(), true, true, true, true, grantedAuthorities);
	}

	public ISystemUserService getSystemUserService() {
		return systemUserService;
	}

	public void setSystemUserService(ISystemUserService systemUserService) {
		this.systemUserService = systemUserService;
	}

	public ISystemAuthorityService getSystemAuthorityService() {
		return systemAuthorityService;
	}

	public void setSystemAuthorityService(ISystemAuthorityService systemAuthorityService) {
		this.systemAuthorityService = systemAuthorityService;
	}
}