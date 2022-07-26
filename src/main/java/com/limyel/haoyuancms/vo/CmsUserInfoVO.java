package com.limyel.haoyuancms.vo;

import com.limyel.haoyuancms.entity.CmsRole;
import com.limyel.haoyuancms.entity.CmsUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CmsUserInfoVO {

    private Long id;

    private String username;

    private String nickname;

    private String avatar;

    private String email;

    private List<CmsRole> roleList;

    public CmsUserInfoVO(CmsUser cmsUser, List<CmsRole> roleList) {
        BeanUtils.copyProperties(cmsUser, this);
        this.roleList = roleList;
    }

}
