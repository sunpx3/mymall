package com.sunpx.mall.mapper;

import com.sunpx.mall.dto.UserRolesDto;
import com.sunpx.mall.model.MUsersModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MUsersModelMapper {
    /**
     * 根据用户名查询对象
     * @param username
     * @return
     */
    public MUsersModel findUserByUsername(String username);

    /**
     * 查询用户列表,用户权限
     * @return
     */
    public List<UserRolesDto> findUserRolesList(@Param("username") String username, @Param("phone") String phone);



    /**
     * 用户启用开头
     * @return
     */
    public int updateUserStatus(@Param("username") String username, @Param("mstatus") int mstatus);

    /**
     * 添加用户
     * @param usersModel
     * @return
     */
    public int insertUsers(@Param("usersModel") MUsersModel usersModel);

}
