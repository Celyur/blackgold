package com.black.gold.organ.domain;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * 用户
 *
 * @author huang.yuxiao on 2018.02.08
 */
@Entity
@Data
@DynamicUpdate
public class User {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 帐号
     */
    private String userName;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 性别
     */
    private int gender;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 帐号是否有效
     */
    private int enable;

    /**
     * 标记是否删除
     */
    private int del;

    /**
     * 注册时间
     */
    private Timestamp registerTime;

    /**
     * 密盐
     */
    private String salt;

    /**
     * 帐号状态
     */
    private int status;

    /**
     * 帐号类别
     */
    private int type;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

}
