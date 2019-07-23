package com.sunpx.mall.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MRolesMenusRelations implements Serializable {
    private Integer mId;

    /**
     * 角色代码
     */
    private String mRolesCode;

    /**
     * 菜单代码
     */
    private String mMenusCode;

    private static final long serialVersionUID = 1L;
}