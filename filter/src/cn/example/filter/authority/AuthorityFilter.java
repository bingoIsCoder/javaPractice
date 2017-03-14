package cn.example.filter.authority;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorityFilter implements Filter {

	private List<String> unCheckUrls;
	private String userInSession;
	private String backUrl;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		String uri = request.getRequestURI();
		Object user = request.getSession().getAttribute(userInSession);
		if (!unCheckUrls.contains(uri)) {
			if (user == null) {
				response.sendRedirect(backUrl);
				return;
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.unCheckUrls = Arrays.asList(config.getInitParameter("unCheckUrls").split(","));
		this.userInSession = config.getInitParameter("userInSession");
		this.backUrl = config.getInitParameter("backUrl");
	}

}
