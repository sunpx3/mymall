package com.sunpx.mall.services.impl;

import com.sunpx.mall.dto.UserRolesDto;
import com.sunpx.mall.mapper.MUsersModelMapper;
import com.sunpx.mall.services.IUserManagerServices;
import com.sunpx.mall.vo.UsersRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserManagerServiceImpl implements IUserManagerServices {

    @Autowired
    MUsersModelMapper mUsersModelMapper;

    @Override
    public List<UsersRoleVo> usersRoleList(String username, String phone) {

        List<UserRolesDto> userRolesDtoList = mUsersModelMapper.findUserRolesList(username, phone);
        List<UsersRoleVo> usersRoleVoList = new ArrayList<>();

        userRolesDtoList.forEach(userRoles ->{
            usersRoleVoList.add(convertDtoToVo(userRoles));
        });
        return usersRoleVoList;
    }


    @Override
    public int updateUserStatus(String username, int mstatus) {
        return mUsersModelMapper.updateUserStatus(username, mstatus);
    }

    private UsersRoleVo convertDtoToVo(UserRolesDto userRolesDto){
        UsersRoleVo vo = new UsersRoleVo();
        vo.setUsername(userRolesDto.getUsername());
        vo.setRolecode(userRolesDto.getRolecode());
        vo.setRolename(userRolesDto.getRolename());
        vo.setMstatus(userRolesDto.getMstatus());
        vo.setMphone(userRolesDto.getMphone());
        return vo;
    }
}
