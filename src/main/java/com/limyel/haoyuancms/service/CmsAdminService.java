package com.limyel.haoyuancms.service;

import com.limyel.haoyuancms.entity.CmsPermission;

import java.util.List;
import java.util.Map;

public interface CmsAdminService {

    Map<String, List<CmsPermission>> listPermission();

}
