package com.limyel.haoyuancms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.limyel.haoyuancms.entity.enumeration.CmsUserIdentityTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * cms用户身份凭证
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
@Getter
@Setter
@TableName("cms_user_identity")
public class CmsUserIdentity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 登录类型
     */
    private CmsUserIdentityTypeEnum identityType;

    /**
     * 登录标识
     */
    private String identifier;

    /**
     * 密码凭证
     */
    private String credential;

}
