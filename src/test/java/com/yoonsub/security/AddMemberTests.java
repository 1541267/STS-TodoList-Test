package com.yoonsub.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/security-context.xml" })
public class AddMemberTests {
    // 암호화
    @Setter(onMethod_ = @Autowired)
    private PasswordEncoder pwencoder;

    @Setter(onMethod_ = @Autowired)
    private DataSource ds;

    
  @Test
  public void testInsertMember() {
      String sql = "insert into yoonsub_member(userid, userpw, username, tel, regdate, updatedate, enabled) values (?,?,?, '010-1234-5678', sysdate, null, 1)";
  
      for(int i = 0; i < 30; i++) {
          Connection con = null;
          PreparedStatement pstmt = null;
          
          try {
              con = ds.getConnection();
              pstmt = con.prepareStatement(sql);
              
              
//              pstmt.setString(1, "testmember");
//              pstmt.setString(2, pwencoder.encode("pw"));
//              pstmt.setString(3, "일반사용자");
              
              
              
              if(i<10) {
                  pstmt.setString(1, "user"+i);
                  pstmt.setString(3, "일반사용자"+i);
                  
              } else if(i<20) { 
                  pstmt.setString(1,  "manager"+i);
                  pstmt.setString(3, "운영자"+i);
                  
              } else {
               
                  pstmt.setString(1,  "admin"+i);
                  pstmt.setString(3, "관리자"+i);
              }
              
              pstmt.executeUpdate();
          } catch(Exception e) {
              e.printStackTrace();
          } finally 
          {if(con != null) {try {con.close(); } catch(Exception e) {}}
          if(pstmt != null) {try {pstmt.close(); } catch(Exception e) {}}

          }

      }
  }
  
  
  @Test
  public void testInsertAuth() {
      
      String sql = "insert into yoonsub_member_auth (userid, auth) values (?,?)";
      
      for(int i = 0; i < 30; i ++) {
          Connection con = null;
          
          PreparedStatement pstmt = null; 
          try {
              con = ds.getConnection();
              pstmt = con.prepareStatement(sql);
              
//              pstmt.setString(1, "testadmin");
//              pstmt.setString(2, "ROLE_MEMBER");
              
              
              if (i < 10) {
                  pstmt.setString(1, "user" + i);
                  pstmt.setString(2, "ROLE_USER");
              } else if (i < 20) {

                  pstmt.setString(1, "manager" + i);
                  pstmt.setString(2, "ROLE_MEMBER");
              } else {

                  pstmt.setString(1, "admin" + i);
                  pstmt.setString(2, "ROLE_ADMIN");
              }
              pstmt.executeUpdate();
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              if(pstmt != null) { try { pstmt.close();} catch(Exception e) {} }
              if(con != null) { try { con.close(); } catch(Exception e) {} }
          }
      }
  }

}
