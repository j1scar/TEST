package com.groupin.command.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 * @Component를 이용해서 스프링 컨테이너가 해당 클래스 객체를 생성하도록 설정할 수 있지만
 * 모든 클래스에 @Component를 할당하면 어떤 클래스가 어떤 역할을 수행하는지 파악하기
 * 어렵다. 스프링 프레임워크에서는 이런 클래스들을 분류하기 위해서
 * @Component를 상속하여 다음과 같은 세개의 애노테이션을 제공한다.
 * 
 *  1. @Controller - 사용자의 요청을 제어하는 Controller클래스
 *  2. @Reposistory - 
 *  3. @Service - 
 */
@Controller
public class MemberController {
		
	//로그인 폼 이동
	@RequestMapping(value="/login.net", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mv, 
			  @CookieValue(value="saveid", required=false) Cookie readCookie) {
	if(readCookie != null){
		mv.addObject("saveid", readCookie.getValue());
	}
	mv.setViewName("member/loginForm");
	return mv;
}
	
	//회원가입 폼 이동
    @RequestMapping(value="/join.net", method = RequestMethod.GET)
	public String join() {
		return "member/joinForm";
	}
    
    @RequestMapping(value="/main.net")
    public String main() {
    	return "main/mainpage_01";
    }

   
  
}
