package com.yoonsub.security;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yoonsub.controller.TodoController;
import com.yoonsub.domain.MemberVo;
import com.yoonsub.mapper.TodoMapper;
import com.yoonsub.service.TodoService;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/security-context.xml" })
public class MemberModifyTests {
    
    @Autowired
    PasswordEncoder pwe;

    @Autowired
    TodoMapper mapper;
    
    @Test
    public void modify() {
        
        String userid = "testadmin";
        String username = "테스트어드민";
        String tel = "010-9876-5432";
        String pw = "1";
        
        MemberVo vo = new MemberVo();
        vo.setUserid(userid);
        vo.setUserName(username);
        vo.setTel(tel);
        vo.setUserpw(pwe.encode(pw));
        

//        service.memberModify(vo);
        mapper.memberModify(vo);
        
    }
    
}
