package com.limyel.haoyuancms.entity.enumeration;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum CmsPermissionMountEnum implements IEnum<Integer> {

    CLOSE(0, "关闭"),
    OPEN(1, "开启");

    private int value;
    private String desc;

    @Override
    public Integer getValue() {
        return this.value;
    }

    CmsPermissionMountEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
