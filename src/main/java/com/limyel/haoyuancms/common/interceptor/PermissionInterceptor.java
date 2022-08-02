package com.limyel.haoyuancms.common.interceptor;

import com.limyel.haoyuancms.common.annotation.ScopeLevel;
import com.limyel.haoyuancms.common.exception.HttpException;
import com.limyel.haoyuancms.common.util.JwtUtil;
import com.limyel.haoyuancms.common.util.ThreadLocalUtil;
import com.limyel.haoyuancms.entity.CmsUser;
import com.limyel.haoyuancms.service.CmsUserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CmsUserService cmsUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Optional<ScopeLevel> scopeLevel = this.getScopeLevel(handler);
        if (!scopeLevel.isPresent()) {
            return true;
        }

        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.isEmpty(bearerToken)) {
            throw new HttpException(10011);
        }
        if (!bearerToken.startsWith("Bearer")) {
            throw new HttpException(10011);
        }
        String[] tokens = bearerToken.split(" ");
        if (tokens.length != 2) {
            throw new HttpException(10011);
        }
        String token = tokens[1];
        CmsUser cmsUser = this.getCurrentUser(token);

        // todo 权限
        return true;
    }

    private Optional<ScopeLevel> getScopeLevel(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            ScopeLevel scopeLevel = handlerMethod.getMethod().getAnnotation(ScopeLevel.class);
            return Optional.ofNullable(scopeLevel);
        }
        return Optional.empty();
    }

    private CmsUser getCurrentUser(String token) {
        Claims claims = this.jwtUtil.getClaims(token);
        Long cmsUserId = (Long) claims.get(JwtUtil.CLAIM_KEY_ID);
        CmsUser cmsUser = cmsUserService.getById(cmsUserId);
        ThreadLocalUtil.put(ThreadLocalUtil.CURRENT_USER, cmsUser);
        return cmsUser;
    }
}
