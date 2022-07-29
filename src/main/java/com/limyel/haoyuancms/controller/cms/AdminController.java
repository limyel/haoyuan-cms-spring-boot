package com.limyel.haoyuancms.controller.cms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.limyel.haoyuancms.common.api.PageData;
import com.limyel.haoyuancms.common.annotation.CosmoController;
import com.limyel.haoyuancms.entity.CmsPermission;
import com.limyel.haoyuancms.entity.CmsUser;
import com.limyel.haoyuancms.service.CmsAdminService;
import com.limyel.haoyuancms.vo.CmsUserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CosmoController
@RestController
@RequestMapping("/cms/admin")
public class AdminController {

    @Autowired
    private CmsAdminService cmsAdminService;

}
