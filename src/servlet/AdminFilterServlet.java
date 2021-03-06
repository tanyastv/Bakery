package servlet;

import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter modifies the response to the client server
 *
 * @author Sarnavskaya
 */
@WebFilter({"/addProduct", "/product"})
public class AdminFilterServlet implements Filter {

    /**
     * Method takes initialization parameters and adjusts the filter configuration object
     *
     * @param config filter configuration object
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
    }

    /**
     * Method by which each filter receives the current request and response
     *
     * @param req   query objects
     * @param resp  response objects
     * @param chain filter chain
     * @throws ServletException
     * @throws IOException
     */
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

    /**
     * Method that is called when the end of the filter
     */
    public void destroy() {
    }

}
