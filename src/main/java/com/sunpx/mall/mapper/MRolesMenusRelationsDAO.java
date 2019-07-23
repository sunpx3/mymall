package com.sunpx.mall.mapper;

import com.sunpx.mall.model.MRolesMenusRelations;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface MRolesMenusRelationsDAO {
    int deleteByPrimaryKey(Integer mId);

    int insert(MRolesMenusRelations record);

    int insertSelective(MRolesMenusRelations record);

    MRolesMenusRelations selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(MRolesMenusRelations record);

    int updateByPrimaryKey(MRolesMenusRelations record);
}