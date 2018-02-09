package com.black.gold.organ.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 权限
 *
 * @author huang.yuxiao on 2018.02.08
 */
@Entity
@Data
public class Permission {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 权限值
     */
    private String code;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 父节点ID
     */
    private int pid;

    /**
     * 权限类型
     */
    private int type;

    /**
     * 权限url
     */
    private String url;

    /**
     * 排序值
     */
    private int weight;

}
