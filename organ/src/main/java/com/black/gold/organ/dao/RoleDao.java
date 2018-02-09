package com.black.gold.organ.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.black.gold.organ.domain.Role;

import java.util.List;

/**
 * @author huang.yuxiao on 2018.02.08
 */
public interface RoleDao extends JpaRepository<Role, String> {

    /**
     * 查找角色列表
     *
     * @return
     */
    List<Role> findAll();
}
