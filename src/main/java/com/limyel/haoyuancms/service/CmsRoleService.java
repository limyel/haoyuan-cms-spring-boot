package com.limyel.haoyuancms.service;

import com.limyel.haoyuancms.entity.CmsRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.limyel.haoyuancms.entity.enumeration.CmsRoleLevelEnum;

import java.util.List;

/**
 * <p>
 * cms角色 服务类
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
public interface CmsRoleService extends IService<CmsRole> {

    List<CmsRole> listRoleByLevel(CmsRoleLevelEnum level);

    List<Long> listRoleIdByLevel(CmsRoleLevelEnum level);

    List<CmsRole> listRoleByUserId(Long userId);

}
