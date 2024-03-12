package a.b.c.com.os.mem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.os.mem.service.OsMemService;
import a.b.c.com.os.mem.vo.OsMemVO;

@Controller
public class OsMemController {
	Logger logger = LogManager.getLogger(OsMemController.class);
	//서비스 연결
	@Autowired
	private OsMemService osMemService;
	
	@RequestMapping("mainlink")
	public String mainlink() {
		logger.info(" mainlink() 함수 진입 >>> : ");
				         return "main/osMain";
	}
	
	//로그인폼
	@RequestMapping(value= "osLoginForm", method = RequestMethod.GET)
	public String loginForm() {
		logger.info("OsLoginController loginForm() 함수 진입 >>> : ");
		return"main/osLoginForm";
	}
	
	//자동로그인
	@RequestMapping("autologin")
	public String autologin(HttpServletRequest req, Model model, OsMemVO ovo) {
		logger.info("OsLoginController autologin() 함수 진입 >>> : ");
		
		Cookie[] cookies = req.getCookies(); // 모든 쿠키 가져오기
		logger.info("Cookie[] cookies=req.getCookies(); 모든 쿠키 가져오기 >>> : " + cookies );
		
		    if(cookies!=null){
		        for (Cookie c : cookies) {
		           String name = c.getName(); // 쿠키 이름 가져오기
		            String value = c.getValue(); // 쿠키 값 가져오기
		            logger.info("name >>> : " + name );
		            logger.info("value >>> :" + value );

		            if (name.equals("ID")) {
		            	 ovo.setMid(value);
		            	 model.addAttribute("listLogin", ovo.getMid());
		            	 logger.info("ifname >>> : " + name );
				         logger.info("ifvalue >>> :" + value );
				         return "main/osMain";
		            }
		        } 
		    }
		 return "main/osLoginForm";
	}
	
	//로그인
	@RequestMapping(value = "login",method=RequestMethod.POST)
	public String login(HttpServletResponse response, HttpServletRequest req, OsMemVO ovo, Model model) {
		logger.info("login() 함수 진입 >>> : ");
		
		//자동로그인 쿠키 생성
		if(req.getParameter("chek")!=null) {
         	logger.info("remember me..." + ovo.getMid());
        	Cookie ck = new Cookie("ID",ovo.getMid());

        	ck.setMaxAge(60*30*24);
        	
        	response.addCookie(ck);
        }
		
		String remoteIP = req.getRemoteAddr();
		String remoteHost = req.getRemoteHost();
		String browser = req.getHeader("User-Agent").toUpperCase();
		String browserName = "";
		
		if (browser.indexOf("CHROME") >= 0) {
				browserName = "CHROME";
		}else if (browser.indexOf("SAFARI") >= 0) {
				browserName = "SAFARI";
		}else if (browser.indexOf("EDG") >= 0) {
				browserName = "EDGE";
		}else if (browserName.indexOf("TRIDENT") >= 0) {
				browserName = "IE";
		}else if(browser.indexOf("FIREFOX") >= 0) {
				browserName = "FIREFOX";
		}else {
			browserName="";
		}
		
		logger.info("remoteIP >>> : " + remoteIP);
		logger.info("remoteHost >>> : " + remoteHost);
		logger.info("browser >>> : " + browser);
		logger.info("browserName >>> : " + browserName);
		
		List<String> remoteInfo = new ArrayList<String>();
		remoteInfo.add(remoteIP);
		remoteInfo.add(browserName);
		
		List<OsMemVO> listLogin = osMemService.loginCheck(ovo);
		logger.info("list size >>> " + listLogin.size());
		
		if (listLogin.size() == 1) { 
			model.addAttribute("listLogin", listLogin);
			 return "main/osMain";
		}	
		return "login/osLoginForm";
	}
	
	// 로그 아웃	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout() {	
		logger.info("OsLoginController logout() 함수 진입 >>> : ");		
			
		return "main/osLoginForm";
	}
	
	@RequestMapping(value="osMemInsertForm", method=RequestMethod.GET)
	public String osInsertForm() {
		logger.info(" osInsertForm 함수 진입 >>> : ");
			
		return "main/osInsertForm";
		
		}
	//회원가입
	@RequestMapping(value="osMemInsert", method=RequestMethod.GET)
	public String osMemInsert(OsMemVO ovo, Model model) {
		logger.info(" osMemInsert 함수 진입 >>> : ");
		logger.info(" getMid() >>> : " + ovo.getMid());
		logger.info(" getMpw() >>> : " + ovo.getMpw());
		logger.info(" getMname() >>> : " + ovo.getMname());
		logger.info(" getMtel() >>> : " + ovo.getMtel());
		logger.info(" getMemail() >>> : " + ovo.getMemail());
		
		int insertCnt = osMemService.osMemInsert(ovo);
		if(insertCnt > 0){
			logger.info("insertCnt >>> : " + insertCnt);
			model.addAttribute("insertCnt", insertCnt);
			return "main/osInsert";
		}
		
	return "main/osInsertForm";
		
}
	
	//아이디중복체크
	@RequestMapping(value="idCheck", method=RequestMethod.POST)
	@ResponseBody
	public Object idCheck(OsMemVO ovo) {
		logger.info("idCheck 함수 진입 >>> :");		
		logger.info("idCheck ovo.getmid()() >>> : " + ovo.getMid());
		
		List<OsMemVO> list = osMemService.idCheck(ovo);
		logger.info("idCheck list.size() >>> :" + list.size());
		
		String msg = "";
		if(list.size() == 0) {msg = "ID_YES";}
		else { msg = "ID_NO";}
		
		return msg;
	}
	
	//마이페이지 로그인
		@RequestMapping("osMypage")
		public String osMypage() {
			
			return "main/osMypage";
		}
		
		@RequestMapping(value = "osMypageForm", method=RequestMethod.GET)
		public String osMypageForm(OsMemVO ovo, Model model) {
			logger.info("osMypageFormcontroller >>> :");
			List<OsMemVO> list = osMemService.mypageCheck(ovo);
			
			if (list.size()>0) {
				
				model.addAttribute("list", list);
				return "main/osMypageForm";
			}
			
			return "main/osMain";
		}
	
	
}
