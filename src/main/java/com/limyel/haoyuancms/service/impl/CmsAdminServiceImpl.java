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


}
