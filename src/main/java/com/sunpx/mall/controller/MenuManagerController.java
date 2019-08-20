package com.sunpx.mall.controller;

import cn.hutool.json.JSONArray;
import com.sunpx.mall.common.CommonResult;
import com.sunpx.mall.dto.MMenusParam;
import com.sunpx.mall.model.MMenus;
import com.sunpx.mall.services.IMenusServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class MenuManagerController {

    @Autowired
    IMenusServices iMenusServices;


    @RequestMapping(value = "/menu/menusList/", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult menus(){
        JSONArray menusDatas = iMenusServices.getMenusNodeList();
        return CommonResult.success(menusDatas);
    }

    @RequestMapping(value = "/menu/addMenus/", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult addMenus(@RequestBody MMenus mMenus){
        int ret = iMenusServices.addMenus(mMenus);
        if(ret > 0){
            return CommonResult.success(ret);
        }else{
            return CommonResult.failed("添加菜单失败，请检查!");
        }
    }

        @RequestMapping(value = "/menu/deleteMenus/", method = RequestMethod.PUT)
        @ResponseBody
        public CommonResult deleteMenusByMenuCode(@RequestBody MMenusParam menusCode){
            int ret = iMenusServices.deleteMenusByMenuCode(menusCode.getMenusCode());
            if(ret > 0){
                return CommonResult.success(ret);
            }else{
                return CommonResult.failed("菜单删除失败，请检查!");
            }
    }
}
