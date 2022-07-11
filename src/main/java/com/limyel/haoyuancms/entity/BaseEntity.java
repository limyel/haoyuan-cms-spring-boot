package com.limyel.haoyuancms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    protected Long id;

    @JsonIgnore
    protected LocalDateTime createTime;

    @JsonIgnore
    protected LocalDateTime updateTime;

    @TableLogic
    @JsonIgnore
    protected LocalDateTime deleteTime;
}
