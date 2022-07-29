package com.limyel.haoyuancms.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

@Component
public class EncryptUtil {

    @Value("${haoyuan.encrypt.salt:123456}")
    private String salt;

    @Value("${haoyuan.encrypt.iteration:1000}")
    private Integer iteration;

    @Value("${haoyuan.encrypt.length:512}")
    private Integer length;

    //算法名称
    private static final String ALGORITHM_NAME = "PBKDF2WithHmacSHA256";

    public String encrypt(String password) {
        SecretKeyFactory keyFactory = null;
        try {
            keyFactory = SecretKeyFactory.getInstance(ALGORITHM_NAME);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("无法检索 pbkdf2_sha256 算法："+e);
        }
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(Charset.forName("UTF-8")), iteration, length);
        SecretKey secret = null;
        try {
            secret = keyFactory.generateSecret(keySpec);
        } catch (InvalidKeySpecException e) {
            System.out.println("无法生成密钥："+e);
        }
        byte[] rawHash = secret.getEncoded();
        byte[] hashBase64 = Base64.getEncoder().encode(rawHash);

        return new String(hashBase64);
    }

    public boolean verify(String encryptedPassword, String password) {
        return encryptedPassword.equals(this.encrypt(password));
    }

}
