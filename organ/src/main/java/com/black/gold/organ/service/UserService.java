package com.black.gold.organ.service;

import com.black.gold.organ.domain.User;

/**
 * @author huang.yuxiao on 2018.02.09
 */
public interface UserService {

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    User save(User user);

    /**
     * 帐号查找
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}
