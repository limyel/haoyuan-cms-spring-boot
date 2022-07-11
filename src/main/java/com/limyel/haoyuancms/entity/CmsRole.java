package com.limyel.haoyuancms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * cms角色
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
@TableName("cms_role")
public class CmsRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色信息
     */
    private String info;

    /**
     * 角色级别, 1:root, 2:guest, 3:user
     */
    private Integer level;

}
