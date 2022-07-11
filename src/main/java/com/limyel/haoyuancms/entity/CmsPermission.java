package com.limyel.haoyuancms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * cms权限
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
@TableName("cms_permission")
public class CmsPermission extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限所属模块
     */
    private String module;

    /**
     * 是否挂载, 0:关闭, 1:开启
     */
    private Boolean mount;

}
