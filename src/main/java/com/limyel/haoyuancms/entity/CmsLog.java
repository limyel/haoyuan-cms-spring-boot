package com.limyel.haoyuancms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * cms日志
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
@Getter
@Setter
@TableName("cms_log")
public class CmsLog extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志信息
     */
    private String message;

    /**
     * 操作用户id
     */
    private Long userId;

    /**
     * 操作用户名
     */
    private String username;

    /**
     * 状态代码
     */
    private Integer statusCode;

    /**
     * 操作方法
     */
    private String method;

    /**
     * 操作路径
     */
    private String path;

    /**
     * 权限
     */
    private String permission;

}
