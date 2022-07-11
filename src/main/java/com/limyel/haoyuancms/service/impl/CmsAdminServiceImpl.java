package com.limyel.haoyuancms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.limyel.haoyuancms.entity.CmsPermission;
import com.limyel.haoyuancms.mapper.CmsPermissionMapper;
import com.limyel.haoyuancms.service.CmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CmsAdminServiceImpl implements CmsAdminService {

    @Autowired
    private CmsPermissionMapper cmsPermissionMapper;

    @Override
    public Map<String, List<CmsPermission>> listPermission() {
        LambdaQueryWrapper<CmsPermission> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(CmsPermission::getMount, true);
        List<CmsPermission> permissionList = this.cmsPermissionMapper.selectList(queryWrapper);
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
}
