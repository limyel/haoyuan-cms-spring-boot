package com.limyel.haoyuancms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.haoyuancms.entity.CmsUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * cms用户 服务类
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
public interface CmsUserService extends IService<CmsUser> {

    /**
     * 获取超级管理员 id。
     *
     * @return
     */
    List<Long> listRootUserId();

    IPage<CmsUser> pageUserByRoleId(Page<CmsUser> page, Long roleId);

}
