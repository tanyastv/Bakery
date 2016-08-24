package servlet;

import entity.User;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Sarnavskaya
 */

/**
 * AdminFilterServlet - класс
 * init -
 * doFilter -
 * destroy -
 */

@WebFilter({"/addProduct", "/product"})
public class AdminFilterServlet implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession(false);

        if (session != null) {
            User user = (User) session.getAttribute("user");

            if ((user != null) && (user.is_admin())) {
                chain.doFilter(req, resp);
                return;
            }
        }

        request.setAttribute("filterMessage", "To perform this action , you must be an administrator");
        request.getRequestDispatcher("filter.jsp").forward(request, response);
    }

    public void destroy() {
    }

}
