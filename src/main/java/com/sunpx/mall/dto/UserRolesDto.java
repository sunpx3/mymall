package com.sunpx.mall.dto;

import lombok.Data;

/**
 * @Data 注解在类上，会为类的所有属性自动生成setter/getter、equals、canEqual、hashCode、toString方法
 */
@Data
public class UserRolesDto {
    private String username;
    private String rolename;
    private String rolecode;
    private int mstatus; //是否启用该用户 -1: 不启用 1: 启用
    private long mphone;
}
