package sg.edu.iss.team8.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class MappingInterceptor extends HandlerInterceptorAdapter{
//	
//	@Autowired
//	private RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
//		Map<RequestMappingInfo, HandlerMethod> mapping = requestMappingHandlerMapping.getHandlerMethods();
		//handle mappings
//		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
//		if(path.equals("/")||path.equals("/login")) {
//			response.sendRedirect("403");
//		}
		/*if(path.endsWith("/*")||path.endsWith("/**")) {
			return "404";
		}
		for (Map.Entry<RequestMappingInfo, HandlerMethod> info : mapping.entrySet()) {			
			if (info.getKey().getPatternsCondition().toString().equals(path)) {
				if (session.getAttribute("USERSESSION") != null) {					
					return "redirect:" + path;
				} else {
					return "403";
				}
			}
		}
		return "404";*/
		
		String scheme = request.getScheme();
		String localName = request.getLocalName();
		String serverPort = Integer.toString(request.getServerPort());
		String contextPath = request.getContextPath();
		
		String url = scheme + "://" + localName + ":" + serverPort + contextPath;
		
		
		if( request.getRequestURI().equals(contextPath + "/hello") )
			  {
//				  User user = (User) request.getSession().getAttribute("USERSESSION");
//			   if(userData == null)
//			   {
//			    response.sendRedirect("/sample-interc/");
//			    return false;
//			   }   
			
				response.sendRedirect(url + "/login");
				return false;
		}
		return true;
	}

}
