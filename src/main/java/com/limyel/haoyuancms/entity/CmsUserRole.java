package com.limyel.haoyuancms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * cms用户角色
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
@Getter
@Setter
@TableName("cms_user_role")
public class CmsUserRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

}
