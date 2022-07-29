package com.limyel.haoyuancms.service;

import com.limyel.haoyuancms.entity.CmsUserIdentity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * cms用户身份凭证 服务类
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
public interface CmsUserIdentityService extends IService<CmsUserIdentity> {

    boolean verifyUsernamePassword(Long id, String username, String password);

}
