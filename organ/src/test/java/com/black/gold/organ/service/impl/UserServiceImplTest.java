package com.black.gold.organ.service.impl;

import com.black.gold.organ.dao.UserDao;
import com.black.gold.organ.domain.User;
import com.black.gold.organ.enums.UserEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author huang.yuxiao on 2018.02.09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void save() throws Exception {
        User user = new User();
        user.setId(1);
        user.setAvatar("http://xxx.jpg");
        user.setUserName("Celyur");
        user.setName("Celyur");
        user.setNickName("H");
        user.setGender(UserEnum.MALE.getCode());
        user.setPwd("123456");
        user.setEmail("Celyur@qq.com");
        user.setMobile("13788889999");
        user.setEnable(UserEnum.ENABLE.getCode());
        user.setDel(UserEnum.UN_DELETED.getCode());
        user.setStatus(UserEnum.STATUS_UNAUDIT.getCode());
        user.setType(UserEnum.ADMIN.getCode());

        User result = userDao.save(user);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByUserName() throws Exception {
    }

}