package com.black.gold.organ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.black.gold.organ.domain.Permission;

import java.util.List;

/**
 * @author huang.yuxiao on 2018.02.08
 */
public interface PermissionDao extends JpaRepository<Permission, String> {
    /**
     * 根据权限编码查找权限
     *
     * @param code
     * @return
     */
    List<Permission> findByCode(String code);
}
