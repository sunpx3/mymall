package com.sunpx.mall.controller;

import com.alibaba.druid.util.StringUtils;
import com.sunpx.mall.common.BaseController;
import com.sunpx.mall.common.CommonResult;
import com.sunpx.mall.common.ResultCode;
import com.sunpx.mall.services.MallAdminServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/admin")
public class MallAdminController extends BaseController {


    @Autowired
    private MallAdminServices mallAdminServices;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestParam String username, @RequestParam String password){

        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            System.out.println(ResultCode.USERNAME_OR_PASSWORD_NOTNULL_EXCEPTION);
        }
        try {
            String token = mallAdminServices.login(username, password);
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token", token);
            tokenMap.put("tokenHead", this.tokenHead);
            return CommonResult.success(tokenMap);
        }catch (UsernameNotFoundException exp){
            return CommonResult.failed(exp.getMessage());
        }catch (BadCredentialsException exp){
            return CommonResult.validateFailed("用户名或密码错误");
        }catch (AuthenticationException exp){
            return CommonResult.failed(exp.getMessage());
        }
    }
}
