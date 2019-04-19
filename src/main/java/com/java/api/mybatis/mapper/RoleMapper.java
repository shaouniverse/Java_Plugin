package com.java.api.mybatis.mapper;
import java.util.List;

import com.java.api.mybatis.pojo.Role;
public interface RoleMapper {
	public int insertRole(Role role);
	public int deleteRole(Long id);
	public int updateRole(Role role);
	public Role getRole(Long id);
	public List<Role> findRoles(String roleName);
}