package com.frame.security.entity;

import com.frame.commons.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: MISAYA
 */
@Entity
@Table(name = "MI_SYSTEM_ROLE")
public class SystemRole extends BaseEntity {

	private String roleName;

	private String roleDescription;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="MI_SYSTEM_ROLE_2_AUTHORITY",
			joinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="AUTHORITY_ID", referencedColumnName="ID")})
	private Set<SystemAuthority> authoritySet = new HashSet<SystemAuthority>();

	private boolean systemManager;

	private boolean enabled;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Set<SystemAuthority> getAuthoritySet() {
		return authoritySet;
	}

	public void setAuthoritySet(Set<SystemAuthority> authoritySet) {
		this.authoritySet = authoritySet;
	}

	public boolean isSystemManager() {
		return systemManager;
	}

	public void setSystemManager(boolean systemManager) {
		this.systemManager = systemManager;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void addAuthority(SystemAuthority systemAuthority) {
		this.authoritySet.add(systemAuthority);
	}

	public void removeAuthority(SystemAuthority systemAuthority) {
		this.authoritySet.remove(systemAuthority);
	}
}
