package com.sunpx.mall.mapper;

import com.sunpx.mall.model.MUsersRolesRelations;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface MUsersRolesRelationsDAO {
    int deleteByPrimaryKey(Integer mId);

    int insert(MUsersRolesRelations record);

    int insertSelective(MUsersRolesRelations record);

    MUsersRolesRelations selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(MUsersRolesRelations record);

    int updateByPrimaryKey(MUsersRolesRelations record);
}