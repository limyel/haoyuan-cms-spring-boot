package com.limyel.haoyuancms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.haoyuancms.entity.CmsPermission;
import com.limyel.haoyuancms.entity.CmsUser;
import com.limyel.haoyuancms.mapper.CmsPermissionMapper;
import com.limyel.haoyuancms.service.CmsAdminService;
import com.limyel.haoyuancms.service.CmsPermissionService;
import com.limyel.haoyuancms.service.CmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CmsAdminServiceImpl implements CmsAdminService {

    @Autowired
    private CmsPermissionService cmsPermissionService;

    @Autowired
    private CmsUserService cmsUserService;

    @Override
    public Map<String, List<CmsPermission>> listPermission() {
        LambdaQueryWrapper<CmsPermission> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(CmsPermission::getMount, true);
        List<CmsPermission> permissionList = this.cmsPermissionService.list(queryWrapper);
        Map<String, List<CmsPermission>> result = new HashMap<>();
        permissionList.forEach(cmsPermission -> {
            if (result.containsKey(cmsPermission.getModule())) {
                result.get(cmsPermission.getModule()).add(cmsPermission);
            } else {
                ArrayList<CmsPermission> t = new ArrayList<>();
                t.add(cmsPermission);
                result.put(cmsPermission.getModule(), t);
            }
        });
        return result;
    }

    @Override
    public IPage<CmsUser> listUserByRoleId(Long roleId, Integer pageNum, Integer pageSize) {
        Page<CmsUser> page = Page.of(pageNum, pageSize);
        IPage<CmsUser> iPage;
        if (ObjectUtils.isEmpty(roleId)) {
            LambdaQueryWrapper<CmsUser> queryWrapper = new LambdaQueryWrapper<>();
            List<Long> rootUserIdList = this.cmsUserService.listRootUserId();
            queryWrapper.notIn(CmsUser::getId, rootUserIdList);
            iPage = this.cmsUserService.page(page, queryWrapper);
        } else {

        }
        return null;
    }
}
