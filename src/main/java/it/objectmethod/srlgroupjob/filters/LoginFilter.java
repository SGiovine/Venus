package it.objectmethod.srlgroupjob.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import it.objectmethod.srlgroupjob.controller.bean.UtenteBean;

@Component
public class LoginFilter implements Filter {

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("RequestLoggingFilter initialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession ses = httpRequest.getSession();
		String path = ((HttpServletRequest) request).getRequestURI();

		if (path.startsWith("/usercheck")) {
			chain.doFilter(request, response); // Just continue chain.
		} else {
			UtenteBean utenteBean = (UtenteBean) ses.getAttribute("agenteBean");
			if (utenteBean != null) {

				chain.doFilter(httpRequest, response);

			} else {

				request.getRequestDispatcher("/login").forward(request, response);

			}
		}

	}

	public void destroy() {
		// close any resources here
	}

}
