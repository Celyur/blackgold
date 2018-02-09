package com.black.gold.organ.dao;

import com.black.gold.organ.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author huang.yuxiao on 2018.02.08
 */
public interface UserDao extends JpaRepository<User, String> {

    /**
     * 根据状态查找用户
     *
     * @param status
     * @return
     */
    List<User> findUsersByStatus(int status);

    /**
     * 帐号查找
     *
     * @param userName
     * @param del
     * @return
     */
    User findByUserNameAndDel(String userName, int del);
}
