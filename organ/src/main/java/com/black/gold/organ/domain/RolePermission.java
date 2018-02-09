package com.black.gold.organ.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 角色权限
 *
 * @author huang.yuxiao on 2018.02.08
 */
@Entity
@Data
public class RolePermission {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 权限ID
     */
    private int permissionId;

    /**
     * 角色ID
     */
    private int roleId;

}
