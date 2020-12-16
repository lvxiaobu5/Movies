package movies.servlet;

import movies.bean.Movie;
import movies.service.MovieService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * TODO
 * 电影详情Servlet
 * @author KaYo
 * @date 2019/11/28 - 21:29
 */
public class DetailServlet extends HttpServlet {
    private MovieService movieService;

    @Override
    public void init() throws ServletException {
        super.init();
        movieService = new MovieService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (Objects.equals("/movie/detail.do", path)) {
            String moviename = request.getParameter("moviename");
            String filename = request.getParameter("filename");
            String introduce = request.getParameter("introduce");
            System.out.println(moviename);
            System.out.println(filename);
            System.out.println(introduce);
//            List<Movie>
            Movie movie = movieService.movieDetail(moviename);
            if (null != movie) {
                request.getSession().setAttribute("movie", movie);
//                request.setAttribute("movie", movie);
                System.out.println("电影存在，跳转到电影详情页面！");
                request.getRequestDispatcher("/WEB-INF/views/biz/detail.jsp").forward(request,response);
            } else {
                System.out.println("跳转失败！");
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
