package com.gstudio.saw.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
public class Auth implements GrantedAuthority {
    
    private String auth;
    
    @Override
    public String getAuthority() {
        return auth;
    }
}
