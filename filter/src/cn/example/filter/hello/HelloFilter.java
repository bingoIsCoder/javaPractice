package cn.example.filter.hello;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("我是Base filter");
		chain.doFilter(req, resp);
		System.out.println("Base over");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String name = config.getInitParameter("name");
		String email = config.getInitParameter("email");
		System.out.println("name: " + name);
		System.out.println("email: " + email);
	}

}
