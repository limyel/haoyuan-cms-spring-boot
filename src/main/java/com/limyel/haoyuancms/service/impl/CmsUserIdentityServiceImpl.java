package com.limyel.haoyuancms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.limyel.haoyuancms.common.util.EncryptUtil;
import com.limyel.haoyuancms.entity.CmsUserIdentity;
import com.limyel.haoyuancms.entity.enumeration.CmsUserIdentityTypeEnum;
import com.limyel.haoyuancms.mapper.CmsUserIdentityMapper;
import com.limyel.haoyuancms.service.CmsUserIdentityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * cms用户身份凭证 服务实现类
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
@Service
public class CmsUserIdentityServiceImpl extends ServiceImpl<CmsUserIdentityMapper, CmsUserIdentity> implements CmsUserIdentityService {

    @Autowired
    private CmsUserIdentityMapper cmsUserIdentityMapper;

    @Autowired
    private EncryptUtil encryptUtil;

    @Override
    public boolean verifyUsernamePassword(Long id, String username, String password) {
        LambdaQueryWrapper<CmsUserIdentity> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(CmsUserIdentity::getUserId, id);
        queryWrapper.eq(CmsUserIdentity::getIdentifier, username);
        queryWrapper.eq(CmsUserIdentity::getIdentityType, CmsUserIdentityTypeEnum.USERNAME_PASSWORD);
        CmsUserIdentity cmsUserIdentity = cmsUserIdentityMapper.selectOne(queryWrapper);

        String encryptPassword = encryptUtil.encrypt(password);

        return encryptPassword.equals(cmsUserIdentity.getCredential());
    }
}
