package com.limyel.haoyuancms.controller.cms;

import com.limyel.haoyuancms.core.token.Token;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cms/user")
public class UserController {

    @PostMapping("/login")
    public Token login(
            @RequestBody LoginDTO loginDTO,
            @RequestHeader
    )

}
