package com.black.gold.organ.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户角色
 *
 * @author huang.yuxiao on 2018.02.08
 */
@Entity
@Data
public class UserRole {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 角色ID
     */
    private int roleId;

    /**
     * 用户ID
     */
    private int userId;
}
