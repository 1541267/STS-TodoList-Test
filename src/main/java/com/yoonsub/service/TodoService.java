package com.yoonsub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yoonsub.domain.MemberVo;
import com.yoonsub.domain.TodoVo;

@Service
public interface TodoService {

    public List<TodoVo> getList(String username);
    
    //회원등록, Controller에서 Auth를 같이 호출.
    public void register(MemberVo membervo);

    public void registerAuth(MemberVo memberVo);

    //add Todo
    public void addTitle(String title, String username);
    
    //Todo의 완료 설정
    public void todoComplete(Long tno);
    
    //Todo 삭제
    public void todoDelete(Long tno);
    
    //어드민의 전체 멤버 조회
    public List<MemberVo> getAllList(MemberVo memberVo);

    //멤버 수정
    public void memberModify(MemberVo memberVo);
}
