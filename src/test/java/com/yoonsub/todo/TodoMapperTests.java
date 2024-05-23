package com.yoonsub.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yoonsub.mapper.TodoMapper;
import com.yoonsub.service.TodoService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
@Log4j
public class TodoMapperTests {
    
    @Setter(onMethod_ = @Autowired)
    private TodoMapper mapper;
    
    @Setter(onMethod_ = @Autowired)
    private DataSource ds;

    @Setter(onMethod_ = @Autowired)
    private TodoService service;
    
    @Test
    public void insertTitleTests() {
        
       String sql = "INSERT INTO yoonsub_todo (tno, title, userid, regdate, enddate) values (?, ?, 'testmember', sysdate, null)";
       for(int i = 1 ; i < 20; i++) {
       Connection con = null;
       PreparedStatement pstmt = null;

       try {
           con = ds.getConnection();
           pstmt = con.prepareStatement(sql);
           
           pstmt.setLong(1, i);
           pstmt.setString(2, "테스트 Todo " + i);

          pstmt.executeQuery();

       } catch (Exception e) { 
           e.printStackTrace();
       } finally { 
         if(con != null) { try { con.close(); } catch (Exception e) {}}
         if(pstmt != null) { try { pstmt.close(); } catch (Exception e) {}}
       }
    }
  }

 
 
//    @Test
//    public void completeUpdateTests() {
//        Long tno = 2L;
//       
//        mapper.todoComplete(tno);
//        
//        
//        
//    }
}
