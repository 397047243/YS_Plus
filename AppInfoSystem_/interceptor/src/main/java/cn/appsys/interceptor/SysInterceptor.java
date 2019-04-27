package cn.appsys.interceptor;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;
import cn.appsys.tools.Constants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SysInterceptor extends HandlerInterceptorAdapter {
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{

		HttpSession session = request.getSession();
		
		BackendUser backendUser = (BackendUser)session.getAttribute(Constants.USER_SESSION_BAC);
		DevUser devUser = (DevUser)session.getAttribute(Constants.USER_SESSION_DEV);
		
		if(null != devUser || null != backendUser){
			System.err.println("=============================>不拦截");
			return true;
		}else{
			System.err.println("=============================>拦截");
			response.sendRedirect("/403.jsp");
			return false;
		}
		
	}
}
