package com.sunpx.mall.dto;

import lombok.Data;

@Data
public class MUserstatusParam {
    private String username;
    private String password;
    private String phone;
    private String[] rules;
    private int mstatus;
}
