package movies.servlet;

import movies.bean.Movie;
import movies.bean.User;
import movies.service.MovieService;
import movies.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * TODO
 *
 * @author KaYo
 * @date 2019/11/25 - 0:48
 */
public class LoginServlet extends HttpServlet {
    private UserService userService;
    private MovieService movieService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
        movieService = new MovieService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (Objects.equals(username,"99哥") && Objects.equals(password,"199896")){
            request.getRequestDispatcher("/WEB-INF/views/biz/admin.jsp").forward(request,response);
        }else {
            String fail = null;
            if(fail!=null){
                request.removeAttribute(fail);
            }
            User user = userService.login(username, password);
            if (null != user) {
                List<Movie> movies = movieService.getMovies();
                request.getSession().setAttribute("movies", movies);
                request.getSession().setAttribute("user", user);
                System.out.println("登录成功！");
                request.getRequestDispatcher("/WEB-INF/views/biz/user_movie_list.jsp").forward(request, response);
            } else {
                fail = "登录失败,请重新登录！";
                request.setAttribute("fail",fail);
                request.getRequestDispatcher("/login.do").forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
