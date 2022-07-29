package com.limyel.haoyuancms.entity.enumeration;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum CmsUserIdentityTypeEnum implements IEnum<Integer> {

    USERNAME_PASSWORD(1, "用户名和密码")
    ;

    private int value;
    private String desc;

    @Override
    public Integer getValue() {
        return this.value;
    }

    CmsUserIdentityTypeEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
