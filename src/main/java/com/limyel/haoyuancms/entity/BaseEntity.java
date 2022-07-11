package com.limyel.haoyuancms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.limyel.haoyuancms.common.api.LocalDateTimeToLongSerializer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public abstract class BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    protected Long id;

    @JsonIgnore
//    @JsonSerialize(using = LocalDateTimeToLongSerializer.class)
    protected LocalDateTime createTime;

    @JsonIgnore
//    @JsonSerialize(using = LocalDateTimeToLongSerializer.class)
    protected LocalDateTime updateTime;

    @TableLogic
    @JsonIgnore
//    @JsonSerialize(using = LocalDateTimeToLongSerializer.class)
    protected LocalDateTime deleteTime;
}
