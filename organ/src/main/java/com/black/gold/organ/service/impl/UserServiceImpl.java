package com.black.gold.organ.service.impl;

import com.black.gold.organ.dao.UserDao;
import com.black.gold.organ.domain.User;
import com.black.gold.organ.enums.UserEnum;
import com.black.gold.organ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huang.yuxiao on 2018.02.09
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUserNameAndDel(userName, UserEnum.UN_DELETED.getCode());
    }

}
