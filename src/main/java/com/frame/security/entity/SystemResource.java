package com.frame.security.entity;

import com.frame.commons.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: 居泽平  Date: 14-3-31, 上午10:01
 */
@Entity
@Table(name = "MI_SYSYTEM_RESOURCE")
public class SystemResource extends BaseEntity {

	private String resourceName;

	private String resourceDescription;

	private String resourceType;

	private String resourceString;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "resourceSet")
	private Set<SystemAuthority> authoritySet = new HashSet<SystemAuthority>();

	private boolean systemManager;

	private boolean enabled;

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceDescription() {
		return resourceDescription;
	}

	public void setResourceDescription(String resourceDescription) {
		this.resourceDescription = resourceDescription;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceString() {
		return resourceString;
	}

	public void setResourceString(String resourceString) {
		this.resourceString = resourceString;
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
}
