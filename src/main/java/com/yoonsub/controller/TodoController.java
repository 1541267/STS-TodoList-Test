package com.yoonsub.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yoonsub.domain.MemberVo;
import com.yoonsub.domain.TodoVo;
import com.yoonsub.mapper.TodoMapper;
import com.yoonsub.service.TodoService;
import com.yoonsub.todo.HomeController;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/todo")
public class TodoController {
    

    
    @Autowired
    private TodoService service;
    
    @Autowired
    private PasswordEncoder pwe;
    
    @Autowired
    private TodoMapper mapper;
    
    @GetMapping("/intro")
    public String intro(Authentication auth, Model model, Locale locale) {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);   //home의 시간 표시
        
        String formattedDate = dateFormat.format(date);
        
        model.addAttribute("serverTime", formattedDate );
        
            //로그인별 intro의 버튼 출력을 위해 로그인 확인
        if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
            // 로그인되어 있을 때
            model.addAttribute("isLoggedIn", true);
        } else {
            // 로그인되어 있지 않을 때
            model.addAttribute("isLoggedIn", false);
          
        }
        return "/todo/intro";
    }
    
    
    @GetMapping("/register")
    public void register() {
        log.info("Login Controller Get Register......");
    }
    
    @PostMapping("/register")
    public String register(MemberVo memberVo) {
        log.info("Login Controller Post Register......");
        
        //비밀번호 보내주기 전에 encode먼저
        memberVo.setUserpw(pwe.encode(memberVo.getUserpw())); 
        
        service.register(memberVo);
        service.registerAuth(memberVo);
            
       return "redirect:../todo/login";
    }

    @GetMapping("/login")
    public void login(String error, String logout, Model model){
        log.info("Todo Controller Get Login........");
        
     
        log.info("error: " + error);
        log.info("logout: " + logout);
        
        if (error != null) {
            model.addAttribute("error", "Login Error! 아이디/비밀번호 확인");
        }
        if (logout != null) {
            model.addAttribute("logout", "로그아웃 되었습니다.");
        }
        

    }

    @GetMapping("/list")
    public String getList(Authentication auth, Model model) {
        // 로그인한 사용자의 이름을 가져와 상단에 이름 표시
        String userid = auth.getName(); 
        
        log.info("username: " + userid);
        log.info("Todo Controller List.....");
        
        //사용자의 TodoList
        List<TodoVo> todoList = service.getList(userid);
        log.info("List.." + todoList);
        
        model.addAttribute("users", todoList);
        model.addAttribute("userid", userid);
        return "./todo/list";
    }
    
    @GetMapping("/add")
    public void todoAdd(Authentication auth){
        //확인용 로그
        log.info("Todo Controller Get Add.... username: " + auth.getName());
    }

    @PostMapping("/add")
    public String postTodoAdd(Authentication auth, TodoVo todoVo) {
        
        String username = auth.getName();
        String title = todoVo.getTitle();
        
        log.info("Todo Controller Post Add.... title : " + title + " username: " + username);
        
        service.addTitle(title, username);
        
        return "redirect:/todo/list";
               
        
    }
    
    @GetMapping("/complete")
    public String todoComplete(@RequestParam("tno") Long tno) {
        log.info("Todo Controller Update...... Tno : " + tno);

        service.todoComplete(tno);
        
        return "redirect:/todo/list";
    }

    @GetMapping("/delete")
    public String todoDelete(@RequestParam("tno") Long tno) {
        log.info("Todo Controller Delete...... tno: " + tno);
        
        service.todoDelete(tno);
        return "redirect:/todo/list";
    }
   
    
    @GetMapping("/logout")
    public String logout(Authentication auth, Model model) {
        log.info("Todo Controller Logout......... username : " + auth.getName());
        
        model.addAttribute("userid", auth.getName());
        

        return "./customLogout";
    }
    


    @GetMapping("/errorPage")
    public void errorPage(Authentication auth, Model model) {
        log.info("access denied : " + auth);

        model.addAttribute("msg", "Access Denied");

    }
    
    
    @GetMapping("/memberList")
    public String postMemberList(MemberVo memberVo, Model model) {
        log.info("Todo Controller....... Post Admin's MemberList");
        
       List<MemberVo> list = service.getAllList(memberVo);
       
       model.addAttribute("allMember", list);
       
       return "/todo/admin/memberList";
    }
    
    
    @GetMapping("/memberModify")
    public void memberModify(@RequestParam("userid") String userid, Model model) {      
        log.info("Todo Controller....... Get MemberMoidfy .......... userid " + userid);
        
        model.addAttribute("userid", userid);
    }   
    

    @PostMapping("/memberModify")
    public String postMemberModify(MemberVo memberVo, Authentication auth) {
        memberVo.setUserpw(pwe.encode(memberVo.getUserpw()));
        
        // 수정 후 권한에 따른 리다이렉트를 위해 권한 확인
        boolean userRole = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        log.info("Todo Controller....... Post MemberModify ...... userid : " + memberVo);
               
        service.memberModify(memberVo);
               
        
       if(userRole == true) {
           return "redirect:../todo/memberList";
       } else {
           return "redirect:../todo/list";
       }
    }

    @GetMapping("/memberDelete")
    public void memberDelete(@RequestParam("userid") String userid, Model model) {
        
        log.info("Todo Controller....... MemberModify ...... userid : " + userid);
        
        model.addAttribute("userid", userid);

    }       
    
    @Transactional
    @PostMapping("/memberDelete")
    public String postMemberDelete(@RequestParam("userid") String userid, Authentication auth) {
        log.info("Todo Controller....... Post MemberModify ...... userid : " + userid);
        
        // 수정 후 권한에 따른 리다이렉트를 위해 권한 확인
        boolean userRole = auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        mapper.memberDeleteTodo(userid);
        mapper.memberDeleteAuth(userid);
        mapper.memberDelete(userid);
        
        
        //회원탈퇴 -> 유저는 홈으로 어드민은 멤버리스트로
       if(userRole == true) {
           return "redirect:../todo/memberList";
       } else {
           return "redirect:../todo/intro";
       }
        
        
        
    }
    
   
}