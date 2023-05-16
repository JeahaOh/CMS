package com.portfolio.cms.webTest.config;

import com.portfolio.cms.webTest.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;

@Slf4j
public class Sha512PasswordEncoder implements PasswordEncoder {
    
    @Override
    public String encode(CharSequence rawPassword) {
        log.debug("rawPassword : {}", rawPassword);
        
        if (StringUtil.isEmpty((String) rawPassword)) {
            throw new IllegalArgumentException("password can not be empty");
        }
        
        return this.getSha512Str(rawPassword);
    }
    
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (StringUtil.isEmpty((String) rawPassword)) {
            throw new IllegalArgumentException("password can not be empty");
        }
    
        if (StringUtil.isEmpty(encodedPassword)) {
            return false;
        }
        
        String encoded = this.getSha512Str(rawPassword);
        return encoded.equals(encodedPassword);
    }
    
    private String getSha512Str(CharSequence rawPassword) {
        MessageDigest digest = null;
        
        try {
            digest = MessageDigest.getInstance("SHA-512");
            digest.update(rawPassword.toString().getBytes());
        } catch (Exception e) {
            log.error("CUZ : {}, MSG : {}", e.getCause(), e.getMessage());
            e.printStackTrace();
        }
        
        byte[] msg = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : msg) {
            String temp = Integer.toHexString(b & 0xFF);
            while (temp.length() < 2) {
                temp = "0" + temp;
            }
            sb.append(temp.substring(temp.length() - 2));
        }
        
        log.debug("getSha512Str : {}", sb);
        return sb.toString();
    }
}
