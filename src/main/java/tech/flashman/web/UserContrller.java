package tech.flashman.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tech.flashman.server.UserServic;

@Controller
@RequestMapping("/user")
public class UserContrller {
	
	@Autowired
	UserServic userServic;
	
	private static Logger log = LoggerFactory.getLogger(UserContrller.class);
	
	
	@RequestMapping(value="/rigest",method=RequestMethod.POST)
	public String userRigest(HttpServletRequest request,HttpServletResponse response) {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		Cookie cookie = new Cookie("TEST_COOKIE", "ASDFHJLASHDFLKASDJHFADKFJASHDA");
		cookie.setMaxAge(3000);
		log.info("注册进入。。。。");
		log.info("account={},password={}");
		response.addCookie(cookie);
		return "forword:index.jsp";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String userLogin(HttpServletRequest request,HttpServletResponse response) {
		log.info("登录进入。。。。");
		return "";
	}
}
