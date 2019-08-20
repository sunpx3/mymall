package com.sunpx.mall.mapper;

import com.sunpx.mall.model.MRoles;

import java.util.List;

public interface MRolesMapper {

    int insert(MRoles record);
    int updateRoleStatus(String roleCode, int mStatus);
    List<MRoles> findMRolesList();
}