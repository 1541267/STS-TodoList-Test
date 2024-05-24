package com.yoonsub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoonsub.domain.MemberVo;
import com.yoonsub.domain.TodoVo;
import com.yoonsub.mapper.TodoMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoMapper mapper;

//    @Setter(onMethod_ = @Autowired)
//    private MemberMapper mapper1;

    @Override
    public void register(MemberVo memberVo) {
        log.info("LoginServiceImpl Register......");
        mapper.register(memberVo);
    }

    @Override
    public void registerAuth(MemberVo memberVo) {
        log.info("LoginServiceImpl RegisterAuth......");
        mapper.registerAuth(memberVo);
    }

    @Override
    public List<TodoVo> getList(String username) {
        log.info("Todo Service GetList....");

        return mapper.getList(username);
    }
    
    @Override
    public void addTitle(String title, String username) {
        log.info("Todo Service getList.... username: " + username + " title : " + title);
 
        mapper.addTitle(title, username);
    }

    @Override
    public void todoComplete(Long tno) {
        log.info("Todo Service TodoComplete Update.......");
        mapper.todoComplete(tno);       
    }
    
    @Override
    public void todoDelete(Long tno) {
        log.info("Todo Service TodoDelete...............");
        mapper.todoDelete(tno);       
    }

    @Override
    public List<MemberVo> getAllList(MemberVo memberVo) {
        log.info("Todo Service Admin's Member GetAllList.......");
        
        return mapper.getAllList(memberVo);
        
    }

    @Override
    public void memberModify(MemberVo memberVo) {
        log.info("Todo Service Member Modify.......");
        
        mapper.memberModify(memberVo);
    }

    @Override
    public void modifyTodo(String title, Long tno) {
        log.info("LoginServiceImpl Modify Todo........");
        mapper.modifyTodo(title, tno);
        
    }

}
