package com.scau.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	
	private static String[] staticResourcesSuffixes = {
		".css", ".js", ".ico", ".png", ".jpg", 
		".gif", ".ttf", ".woff", ".svg"
	};
	
	// 根据请求路径判断是否请求静态资源，如：css、js等文件。
	private boolean isStaticResources(String path){
		boolean result = false;
		
		if(path.lastIndexOf(".") != -1){
			// 获取请求路径的后缀
			String suffix = path.substring(path.lastIndexOf("."));
//			System.out.print(suffix);
			
			// 与静态资源的后缀逐个比对
			for(String s : staticResourcesSuffixes){
				if(suffix.equals(s)){
					result = true;
					break;
				}
			}
		}
		
		return result;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.print("login interceptor: ");
		String path = request.getServletPath();
//		System.out.println(path);
		
		if(path.equals("/login") || path.equals("/register") || isStaticResources(path)){
			return true;
		}
		
		if(request.getSession().getAttribute("user") != null)
			return true;
		
		response.sendRedirect(request.getContextPath() + "/login");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
