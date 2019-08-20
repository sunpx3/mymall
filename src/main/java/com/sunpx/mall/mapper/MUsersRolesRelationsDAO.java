package com.sunpx.mall.mapper;

import com.sunpx.mall.model.MRoles;
import com.sunpx.mall.model.MUsersRolesRelations;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface MUsersRolesRelationsDAO {

    List<MRoles> findRolesByUsername(String username);
}