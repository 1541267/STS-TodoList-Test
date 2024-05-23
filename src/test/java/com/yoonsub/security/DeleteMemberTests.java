package com.yoonsub.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yoonsub.controller.TodoController;
import com.yoonsub.mapper.TodoMapper;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/security-context.xml" })
public class DeleteMemberTests {

    @Autowired
    TodoMapper tm;
        
    
    @Test
    public void deleteMemberTests() {
        
        String userid = "이건아이디5";
        
        tm.memberDeleteTodo(userid);
        tm.memberDeleteAuth(userid);
        tm.memberDelete(userid);
 
   }

}
