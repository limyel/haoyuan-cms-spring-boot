package com.limyel.haoyuancms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.haoyuancms.entity.CmsUser;
import com.limyel.haoyuancms.entity.CmsUserRole;
import com.limyel.haoyuancms.mapper.CmsUserMapper;
import com.limyel.haoyuancms.mapper.CmsUserRoleMapper;
import com.limyel.haoyuancms.service.CmsRoleService;
import com.limyel.haoyuancms.service.CmsUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * cms用户 服务实现类
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
@Service
public class CmsUserServiceImpl extends ServiceImpl<CmsUserMapper, CmsUser> implements CmsUserService {

    @Autowired
    private CmsUserMapper cmsUserMapper;

    @Autowired
    private CmsRoleService cmsRoleService;

    @Autowired
    private CmsUserRoleMapper cmsUserRoleMapper;

    @Override
    public CmsUser getCmsUserByUsername(String username) {
        LambdaQueryWrapper<CmsUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CmsUser::getUsername, username);
        return cmsUserMapper.selectOne(queryWrapper);
    }
}
