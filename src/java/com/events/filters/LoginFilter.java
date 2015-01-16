package com.events.filters;

import com.events.model.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "LoginFilters",
        urlPatterns = {"/users", "/users/*", "/events", "/events/*"}
)
public class LoginFilter implements Filter {
    
    @Override
    public void init(FilterConfig fc) throws ServletException {}
    
    @Override
    public void doFilter(ServletRequest serverRequest, ServletResponse serverResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) serverRequest;
        HttpServletResponse response = (HttpServletResponse) serverResponse;
        HttpSession session = request.getSession(false);
        
        User user = (User) ((session != null) ? session.getAttribute("user") : null);
        
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
    
    @Override
    public void destroy() {}
    
}
