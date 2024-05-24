package com.yoonsub.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yoonsub.domain.MemberVo;
import com.yoonsub.domain.TodoVo;

@Mapper
public interface TodoMapper {

    public List<TodoVo> getList(String username);

    public void register(MemberVo memberVo);

    public void registerAuth(MemberVo memberVo);

    public void addTitle(@Param("title") String title, @Param("userName") String username);

    public void modifyTodo(@Param("title") String title,@Param("tno") Long tno);
    
    public void todoComplete(Long tno);

    public void todoDelete(Long tno);

    public List<MemberVo> getAllList(MemberVo memberVo);

    public void memberModify(MemberVo memberVo);

    public void memberDeleteTodo(String userid);

    public void memberDeleteAuth(String userid);

    public void memberDelete(String userid);

}
