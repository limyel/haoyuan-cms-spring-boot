package com.limyel.haoyuancms.mapper;

import com.limyel.haoyuancms.entity.CmsRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * cms角色 Mapper 接口
 * </p>
 *
 * @author limyel
 * @since 2022-07-10
 */
@Repository
public interface CmsRoleMapper extends BaseMapper<CmsRole> {

    List<CmsRole> selectRoleByUserId(Long userId);

}
