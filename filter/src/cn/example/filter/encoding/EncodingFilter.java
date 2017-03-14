package cn.example.filter.encoding;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding;
	private boolean forceEncoding;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		if ((req.getCharacterEncoding() == null || forceEncoding) && hasLength(encoding)) {
			req.setCharacterEncoding(encoding);
		}
		chain.doFilter(req, resp);		
	}

	private boolean hasLength(String str) {
		return str != null && !"".equals(str);
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.encoding = config.getInitParameter("encoding");
		this.forceEncoding = Boolean.parseBoolean(config.getInitParameter("forceEncoding"));
	}

}
