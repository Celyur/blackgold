package com.black.gold.organ.enums;

import lombok.Getter;

/**
 * @author huang.yuxiao on 2018.02.09
 */
@Getter
public enum PermissionEnum {

    MENU(0, "菜单"),
    BUTTON(1, "按钮"),
    OPERATE(2, "操作");

    private Integer code;
    private String message;

    PermissionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
