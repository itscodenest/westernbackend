package com.tourcoreservice.account.pojo;

import java.util.List;
import java.util.Set;

public class RolePojo {
	private long id;

	private String name;

	private String code;

	private List<UserPojo> users;

	private List<PrivilegePojo> privileges;

	private RolePojo parentGroup;

	private Set<RolePojo> childGroup;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<UserPojo> getUsers() {
		return users;
	}

	public void setUsers(List<UserPojo> users) {
		this.users = users;
	}

	public List<PrivilegePojo> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<PrivilegePojo> privileges) {
		this.privileges = privileges;
	}

	public RolePojo getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(RolePojo parentGroup) {
		this.parentGroup = parentGroup;
	}

	public Set<RolePojo> getChildGroup() {
		return childGroup;
	}

	public void setChildGroup(Set<RolePojo> childGroup) {
		this.childGroup = childGroup;
	}

}
