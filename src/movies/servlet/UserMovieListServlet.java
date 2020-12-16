package movies.servlet;

import movies.service.MovieService;
import movies.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * TODO
 *
 * @author KaYo
 * @date 2019/12/1 - 17:02
 */
public class UserMovieListServlet extends HttpServlet {
    private MovieService movieService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        movieService = new MovieService();
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(Objects.equals("/usermovielist.do",path)){
//            String username = request.getParameter("username");
////            String password = request.getParameter("password");
//            System.out.println(username);
//            String fail = null;
//            if(fail!=null){
//                request.removeAttribute(fail);
//            }
//            User user = userService.getUserByName(username);
//            System.out.println(user.getRealName());
//            if (null != user) {
//                List<Movie> movies = movieService.getMovies();
//                request.getSession().setAttribute("movies", movies);
//                request.getSession().setAttribute("user", user);
//                System.out.println("登录成功！");
                request.getRequestDispatcher("/WEB-INF/views/biz/user_movie_list.jsp").forward(request, response);
//            } else {
//                fail = "登录失败,请重新登录！";
//                request.setAttribute("fail",fail);
//                request.getRequestDispatcher("/login.do").forward(request, response);
//            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        movieService = null;
    }

}
