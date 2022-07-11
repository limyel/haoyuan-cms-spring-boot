package com.limyel.haoyuancms.controller.cms;

import com.limyel.haoyuancms.common.api.Result;
import com.limyel.haoyuancms.core.annotation.CosmoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CosmoController
@Validated
@RestController
@RequestMapping("/cms/admin")
public class AdminController {

    @GetMapping("/test")
    public String test() {
        return "123";
    }

}
