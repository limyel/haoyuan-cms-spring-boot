package com.limyel.haoyuancms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.haoyuancms.entity.CmsPermission;
import com.limyel.haoyuancms.entity.CmsUser;

import java.util.List;
import java.util.Map;

public interface CmsAdminService {

    Map<String, List<CmsPermission>> listPermission();

    IPage<CmsUser> listUserByRoleId(Long roleId, Integer pageNum, Integer pageSize);

}
