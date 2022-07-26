package com.limyel.haoyuancms.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.limyel.haoyuancms.entity.CmsUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * cms用户 Mapper 接口
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
@Repository
public interface CmsUserMapper extends BaseMapper<CmsUser> {

    IPage<CmsUser> selectPageByRoleId(Page<CmsUser> page, Long roleId, List<Long> excludeRoleIdList);

}
