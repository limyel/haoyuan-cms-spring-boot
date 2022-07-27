package com.limyel.haoyuancms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.limyel.haoyuancms.entity.CmsRole;
import com.limyel.haoyuancms.mapper.CmsRoleMapper;
import com.limyel.haoyuancms.service.CmsRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * cms角色 服务实现类
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
@Service
public class CmsRoleServiceImpl extends ServiceImpl<CmsRoleMapper, CmsRole> implements CmsRoleService {

    @Autowired
    private CmsRoleMapper cmsRoleMapper;

}
