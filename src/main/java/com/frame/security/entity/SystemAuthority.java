package com.frame.security.entity;

import com.frame.commons.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: 居泽平  Date: 14-3-31, 上午10:01
 */
@Entity
@Table(name = "MI_SYSTEM_AUTHORITY")
public class SystemAuthority extends BaseEntity {

	private String authorityName;

	private String authorityDescription;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "authoritySet")
	private Set<SystemRole> roleSet = new HashSet<SystemRole>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="MI_SYSTEM_AUTHORITY_2_RESOURCE",
			joinColumns={@JoinColumn(name="AUTHORITY_ID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="RESOURCE_id", referencedColumnName="ID")})
	private Set<SystemResource> resourceSet = new HashSet<SystemResource>();

	private boolean systemManager;

	private boolean enabled;

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityDescription() {
		return authorityDescription;
	}

	public void setAuthorityDescription(String authorityDescription) {
		this.authorityDescription = authorityDescription;
	}

	public Set<SystemRole> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<SystemRole> roleSet) {
		this.roleSet = roleSet;
	}

	public Set<SystemResource> getResourceSet() {
		return resourceSet;
	}

	public void setResourceSet(Set<SystemResource> resourceSet) {
		this.resourceSet = resourceSet;
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

	public void addResource(SystemResource systemResource) {
		this.resourceSet.add(systemResource);
	}

	public void removeResource(SystemResource systemResource) {
		this.resourceSet.remove(systemResource);
	}
}
