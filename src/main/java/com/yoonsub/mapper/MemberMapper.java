package com.yoonsub.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.yoonsub.domain.MemberVo;
@Mapper
public interface MemberMapper {
        public MemberVo read(String userid);
}
