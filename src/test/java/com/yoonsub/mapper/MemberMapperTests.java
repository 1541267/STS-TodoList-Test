package com.yoonsub.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yoonsub.domain.MemberVo;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class MemberMapperTests {
    @Setter(onMethod_ = @Autowired)
    private MemberMapper mapper;
    
    @Test
    public void testRead() {
        MemberVo vo = mapper.read("testmember");
        
        log.info(vo);
        vo.getAuthList().forEach(authVO -> log.info(authVO));
    }
    
}
