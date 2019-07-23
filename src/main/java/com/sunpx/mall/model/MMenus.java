package com.sunpx.mall.model;

import lombok.Data;

@Data
public class MMenus {

    private Integer mId;

    private String mMenuCode;

    private String mMenuName;

    private String mMenuUrl;

    private String mMenuParentCode;

    private Integer mMenuLevel;

    private Integer mMenuSortNums;

    private String mMenuDesc;

}