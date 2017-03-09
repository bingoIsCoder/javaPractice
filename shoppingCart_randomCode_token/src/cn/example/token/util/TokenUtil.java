package cn.example.token.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class TokenUtil {
	public static void createToken(HttpServletRequest req, 
			String sessionTokenName, String requestTokenName) {
		String token = UUID.randomUUID().toString();
		req.getSession().setAttribute(sessionTokenName, token);
		req.setAttribute(requestTokenName, token);
	}
	
	public static boolean equalsToken(HttpServletRequest req, 
			String sessionTokenName, String requestTokenName) {
		String reqToken = req.getParameter(requestTokenName);
		String sessionToken = (String)req.getSession().getAttribute(sessionTokenName);
		req.getSession().removeAttribute(sessionTokenName);
		
		return reqToken.equals(sessionToken);
	}
}
