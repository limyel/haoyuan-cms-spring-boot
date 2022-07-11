package com.limyel.haoyuancms.controller.cms;

import com.limyel.haoyuancms.common.api.Result;
import com.limyel.haoyuancms.core.annotation.CosmoController;
import com.limyel.haoyuancms.entity.CmsPermission;
import com.limyel.haoyuancms.service.CmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CosmoController
@Validated
@RestController
@RequestMapping("/cms/admin")
public class AdminController {

    @Autowired
    private CmsAdminService cmsAdminService;

    @GetMapping("/permission")
    public Map<String, List<CmsPermission>> listPermission() {
        return cmsAdminService.listPermission();
    }
}
