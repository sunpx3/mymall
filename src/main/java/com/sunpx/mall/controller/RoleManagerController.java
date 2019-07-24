package com.sunpx.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 角色管理
 */
@Controller
@RequestMapping("/api")
public class RoleManagerController {

    /**
     * 获取角色列表
     * @return
     */
    @RequestMapping(value = "/role/roles", method = RequestMethod.GET)
    @ResponseBody
    public String roles(){
        return null;
    }

    /**
     * 添加角色
     * @return
     */
    @RequestMapping(value = "/role/addRole", method = RequestMethod.POST)
    @ResponseBody
    public int addRole(){
        return 0;
    }

    /**
     * 角色启用开关 0:启用,-1未启用
     * @return
     */
    @RequestMapping(value = "/roleSwitchOptions", method = RequestMethod.PUT)
    @ResponseBody
    public int roleSwitchOptions(){
        return 0;
    }

}
