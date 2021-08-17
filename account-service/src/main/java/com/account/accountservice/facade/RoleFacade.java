package com.account.accountservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.account.accountservice.service.PrivilegeService;
import com.account.accountservice.service.RoleService;
import com.tourcoreservice.account.pojo.RolePojo;
import com.tourcoreservice.account.response.RolePojoListResponse;
import com.tourcoreservice.account.response.RolePojoResponse;
import com.tourcoreservice.entity.Privilege;
import com.tourcoreservice.entity.Role;
import com.tourcoreservice.generic.pojo.ResponseMessagePojo;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class RoleFacade {

	@Autowired
	RoleService roleService;

	@Value("${created.success}")
	private String createdSuccess;

	@Value("${updated.success}")
	private String updateSuccess;

	@Value("${deleted.success}")
	private String deleteSuccess;

	@Value("${privilege.not.found}")
	private String privilegeNotFound;

	@Autowired
	private PrivilegeService privilegeService;

	public RolePojoResponse create(RolePojo rolePojo) {
		Role role = ObjectMapperUtils.map(rolePojo, Role.class);
		role = roleService.create(role);
		rolePojo = ObjectMapperUtils.map(role, RolePojo.class);
		return createUpdateDeleteRespnse(createdSuccess, rolePojo);
	}

	public RolePojoListResponse getAllRoles() {
		RolePojoListResponse rolePojoListResponse = new RolePojoListResponse();
		List<Role> roles = roleService.findAllRoles();
		List<RolePojo> rolePojo = ObjectMapperUtils.mapAll(roles, RolePojo.class);
		rolePojoListResponse.setRolePojoList(rolePojo);
		return rolePojoListResponse;
	}

	public RolePojoResponse update(RolePojo rolePojo) {
		Role role = roleService.findRoleById(rolePojo.getId());
		deleteExistingPrivileges(role.getPrivileges(), role);
		ObjectMapperUtils.map(rolePojo, role);
		role = roleService.update(role);
		rolePojo = ObjectMapperUtils.map(role, RolePojo.class);
		return createUpdateDeleteRespnse(updateSuccess, rolePojo);
	}

	private void deleteExistingPrivileges(List<Privilege> privileges, Role role) {
		role.getPrivileges().removeAll(privileges);
		roleService.save(role);
	}

	private RolePojoResponse createUpdateDeleteRespnse(String message, RolePojo rolePojo) {
		RolePojoResponse response = new RolePojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessaages = new ArrayList<ResponseMessagePojo>();
		responseMessagePojo.setMessage(createdSuccess);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		response.setRolePojo(rolePojo);
		response.setSuccessMessaages(successMessaages);
		return response;
	}

	public RolePojoResponse delete(long id) {
		Role role = roleService.findRoleById(id);
		roleService.delete(role);
		return createUpdateDeleteRespnse(deleteSuccess, null);
	}

	public RolePojoResponse addPrivilegeToRole(long roleId, long priviegeId) {
		Role role = roleService.findRoleById(roleId);
		List<Privilege> privilegeList = role.getPrivileges();
		Privilege privilege = privilegeService.findPrivilegeById(priviegeId);
		privilegeList.add(privilege);
		role.setPrivileges(privilegeList);
		role = roleService.update(role);
		RolePojo rolePojo = ObjectMapperUtils.map(role, RolePojo.class);
		return createUpdateDeleteRespnse(updateSuccess, rolePojo);
	}

	public RolePojoResponse deletePrivilegeForRole(long roleId, long priviegeId) {
		Role role = roleService.findRoleById(roleId);
		if (!CollectionUtils.isEmpty(role.getPrivileges())) {
			Privilege privilege = privilegeService.findPrivilegeById(priviegeId);
			role.getPrivileges().remove(privilege);
			role = roleService.update(role);
			return createUpdateDeleteRespnse(deleteSuccess, null);
		} else {
			return createUpdateDeleteRespnse(privilegeNotFound, null);
		}

	}

	public RolePojoResponse getRoleById(long roleId) {
		Role role = roleService.findRoleById(roleId);
		RolePojo rolePojo = ObjectMapperUtils.map(role, RolePojo.class);
		return createUpdateDeleteRespnse(null, rolePojo);
	}

}
