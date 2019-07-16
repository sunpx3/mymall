package com.sunpx.mall.services.impl;

import com.sunpx.mall.common.ResultCode;
import com.sunpx.mall.config.MyUserDetailsService;
import com.sunpx.mall.services.MallAdminServices;
import com.sunpx.mall.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MallAdminServicesImpl implements MallAdminServices {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String login(String username, String password) {

        String token = "";
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
        if(userDetails == null){
            throw new UsernameNotFoundException(ResultCode.USERNAME_NOT_FOUND_EXCEPTION.getMessage());
        }
        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException(ResultCode.BAD_CREDENTIALS_EXCEPTION.getMessage());
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        token = jwtTokenUtil.generateToken(userDetails);

        return token;
    }
}
