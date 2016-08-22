package servlet;

import entity.User;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

        request.setAttribute("filterMessage", "You need to be authenticated as admin");
        request.getRequestDispatcher("../filter.jsp").forward(request, response);
    }

    public void destroy() {
    }

}
