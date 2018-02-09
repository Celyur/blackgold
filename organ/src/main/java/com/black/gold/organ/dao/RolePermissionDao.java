package com.black.gold.organ.dao;

import com.black.gold.organ.domain.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * @author huang.yuxiao on 2018.02.08
 */
public interface RolePermissionDao extends JpaRepository<RolePermission, String> {
    /**
     * 根据角色ID查找角色所有的权限
     *
     * @param roleId
     * @return
     */
    List<RolePermission> findRolePermissionByRoleId(int roleId);

    /**
     * 查找角色权限
     *
     * @param roles
     * @return
     */
    List<RolePermission> findByRoleIdIn(Set<Integer> roles);
}
