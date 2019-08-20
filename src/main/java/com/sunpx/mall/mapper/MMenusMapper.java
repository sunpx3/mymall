package com.sunpx.mall.mapper;

import com.sunpx.mall.model.MMenus;

import java.util.List;

public interface MMenusMapper {

    int insert(MMenus record);

    int insertSelective(MMenus record);

    int deleteMenusByMenusCode(String menusCode);

    List<MMenus> selectAllNodeTop();

    List<MMenus> selectAllNodeByMenuCode(String menuCode);
}
