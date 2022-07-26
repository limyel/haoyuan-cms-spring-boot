package com.limyel.haoyuancms.common.util;

import com.limyel.haoyuancms.common.exception.HttpException;
import com.limyel.haoyuancms.entity.CmsUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.text.html.Option;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class JwtUtil {

    public static final String CLAIM_KEY_ID = "id";

    public static final String CLAIM_KEY_CREATE_TIME = "createTime";

    @Value("${haoyuan.jwt.secret}")
    private String secret;

    @Value("${haoyuan.jwt.expiration}")
    private Integer expiration;

    /**
     * 生成token
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(this.generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, this.secret)
                .compact();
    }

    public Claims getClaims(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(this.secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new HttpException(10011);
        }
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    public String generateToken(CmsUser cmsUser) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_ID, cmsUser.getId());
        claims.put(CLAIM_KEY_CREATE_TIME, new Date());
        return this.generateToken(claims);
    }
}
