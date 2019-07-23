package com.sunpx.mall.controller;

import com.sunpx.mall.common.CommonResult;
import com.sunpx.mall.services.IUserManagerServices;
import com.sunpx.mall.vo.UsersRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户管理
 */
@Controller
@RequestMapping("/api")
public class UserManagerController {


    @Autowired
    IUserManagerServices userManagerServices;

    @RequestMapping(value = "/user/userRolesList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult userRolesList(){
        List<UsersRoleVo> usersRoleVoList = userManagerServices.usersRoleList(null,null);
        return CommonResult.success(usersRoleVoList);
    }

    @RequestMapping(value = "/user/userRolesListConditions", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult userRolesListConditions(@RequestParam("username") String username, @RequestParam("phone") String phone){
        List<UsersRoleVo> usersRoleVoList = userManagerServices.usersRoleList(username, phone);
        return CommonResult.success(usersRoleVoList);
    }

    /**
     * 用户启用开关0:启用-1，未启用
     * @return
     */
    @RequestMapping(value = "/user/userSwitchStatus", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult userSwitchStatus(@RequestParam String username, @RequestParam int mstatus){
        int ret = userManagerServices.updateUserStatus(username, mstatus);
        CommonResult result;
        if(ret > 0){
            result = CommonResult.success(ret);
        }else {
            result = CommonResult.failed("用户启用功能出错!,请检查!");
        }
        return result;
    }
}
