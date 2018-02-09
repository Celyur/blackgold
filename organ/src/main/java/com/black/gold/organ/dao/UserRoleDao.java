package com.black.gold.organ.dao;

import com.black.gold.organ.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author huang.yuxiao on 2018.02.08
 */
public interface UserRoleDao extends JpaRepository<UserRole, String> {
    /**
     * 根据用户ID查找用户的角色
     *
     * @param uid
     * @return
     */
    List<UserRole> findByUserId(int uid);
}
