package com.sunpx.mall.services;

import com.sunpx.mall.vo.UsersRoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserManagerServices {

    /**
     * 获取用户表
     * @return
     */
    public List<UsersRoleVo> usersRoleList(String username, String phone);


    public int updateUserStatus(@Param("username") String username, @Param("mstatus") int mstatus);


}
