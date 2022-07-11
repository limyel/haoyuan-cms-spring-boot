package com.limyel.haoyuancms.common.api;

import com.limyel.haoyuancms.core.annotation.CosmoController;
import com.limyel.haoyuancms.core.annotation.IgnoreCosmoResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        // 对 @CosmoController 注解的 Controller 进行处理，对 @IgnoreCosmoResult 注解的 Controller、方法放行。
        return returnType.getDeclaringClass().isAnnotationPresent(CosmoController.class)
                && !returnType.getDeclaringClass().isAnnotationPresent(IgnoreCosmoResult.class)
                && !returnType.getMethod().isAnnotationPresent(IgnoreCosmoResult.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 避免重复包装
        if (body instanceof Result) {
            return body;
        }
        return Result.success(body);
    }
}
