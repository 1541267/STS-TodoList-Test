package com.yoonsub.domain;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MemberVo {

    private String userid;
    private String userpw;
    private String userName;
    private String tel;
    private int enabled;
    
    private Date regDate;
    private Date updateDate;
    private List<AuthVo> authList;

}
