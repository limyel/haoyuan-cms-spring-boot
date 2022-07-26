package com.limyel.haoyuancms.entity.enumeration;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum CmsRoleLevelEnum implements IEnum<Integer> {
    ROOT(1, "超级管理员"),
    GUEST(2, "游客"),
    USER(3, "普通用户")
    ;

    private int value;
    private String desc;

    @Override
    public Integer getValue() {
        return this.value;
    }

    CmsRoleLevelEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

}
