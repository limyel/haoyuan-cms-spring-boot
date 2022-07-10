package com.limyel.haoyuancms.entity.enumeration;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum CmsFileTypeEnum implements IEnum<Integer> {
    LOCAL(1, "本地"),
    REMOTE(2, "远程");

    private int value;
    private String desc;

    @Override
    public Integer getValue() {
        return this.value;
    }

    CmsFileTypeEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
