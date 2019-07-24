package com.sunpx.mall.controller;

import com.alibaba.druid.util.StringUtils;
import com.sunpx.mall.common.CommonResult;
import com.sunpx.mall.common.ResultCode;
import com.sunpx.mall.dto.MUsersParam;
import com.sunpx.mall.services.IMallAdminServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/api")
public class MallAdminController {


    @Autowired
    private IMallAdminServices mallAdminServices;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody MUsersParam mUsersParam){

        if(StringUtils.isEmpty(mUsersParam.getUsername()) || StringUtils.isEmpty(mUsersParam.getPassword())){
            System.out.println(ResultCode.USERNAME_OR_PASSWORD_NOTNULL_EXCEPTION);
        }
        try {
            String token = mallAdminServices.login(mUsersParam.getUsername(), mUsersParam.getPassword());
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token", token);
            tokenMap.put("tokenHead", this.tokenHead);
            return CommonResult.success(tokenMap);
        }catch (UsernameNotFoundException exp){
            return CommonResult.userNameOrPasswordNotnullException(exp.getMessage());
        }catch (BadCredentialsException exp){
            return CommonResult.badCredentialsException(exp.getMessage());
        }catch (AuthenticationException exp){
            return CommonResult.failed(exp.getMessage());
        }
    }
}
