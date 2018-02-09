package com.black.gold.organ.enums;

import lombok.Getter;

/**
 * @author huang.yuxiao on 2018.02.09
 */
@Getter
public enum UserEnum {
    /**
     * 用户类型
     */
    GENERAL(0, "普通用户"),
    VIP(1, "VIP用户"),
    ADMIN(-1, "管理员"),

    /**
     * 性别
     */
    UNDEFINED(0, "未设置"),
    MALE(1, "男"),
    FEMALE(2, "女"),

    /**
     * 帐号是否有效
     */
    ENABLE(1, "有效"),
    DISABLED(0, "无效"),

    /**
     * 是否删除
     */
    UN_DELETED(0, "未删除"),
    DELETED(1, "已删除"),

    /**
     * 帐号状态
     */
    STATUS_UNAUDIT(0, "已注册未审核"),
    STATUS_WAIT_AUDIT(1, "待审核"),
    STATUS_AUDIT_PASS(2, "审核通过"),
    STATUS_AUDIT_UNPASS(-1, "未通过");

    private Integer code;
    private String message;

    UserEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
