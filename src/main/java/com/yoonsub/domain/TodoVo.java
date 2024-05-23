package com.yoonsub.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
public class TodoVo {
    
    private Long tno;   
    private String title;
    private String userid;
    private String username;
    private Date regDate;
    private Date endDate;

}
