package com.frame.security.entity;

import com.frame.commons.entity.base.BaseEntity;

import javax.persistence.*;

/**
 *  Author: MISAYA
 */
@Entity
@Table(name = "MI_SYSTEM_USER")
public class SystemUser extends BaseEntity {

	/**
	 * 用户登陆帐号
	 */
	private String userAccount;

	/**
	 * 用户登陆密码
	 */
	private String userPassword;

	/**
	 * 用户姓名
	 */
	private String userName;

	/**
	 * 是否平台管理员 true-平台管理员 false-xx管理员
	 */
	private boolean systemManager;

	/**
	 * 用户角色
	 */
	@ManyToOne()
	@JoinColumn(name = "role_id")
	private SystemRole systemRole;

	/**
	 * 是否被禁用 true-正常 false-已禁用
	 */
	private boolean enabled;

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isSystemManager() {
		return systemManager;
	}

	public void setSystemManager(boolean systemManager) {
		this.systemManager = systemManager;
	}

	public SystemRole getSystemRole() {
		return systemRole;
	}

	public void setSystemRole(SystemRole systemRole) {
		this.systemRole = systemRole;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
