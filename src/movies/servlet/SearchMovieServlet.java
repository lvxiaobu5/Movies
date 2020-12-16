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
 *
 * @author KaYo
 * @date 2019/11/30 - 4:43
 */
public class SearchMovieServlet extends HttpServlet {
    private MovieService movieService;

    @Override
    public void init() throws ServletException {
        super.init();
        movieService = new MovieService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (Objects.equals("/movie/search.do", path)) {
            String fail = null;
            if(fail!=null){
                request.removeAttribute(fail);
            }
            String moviename = request.getParameter("title");
            System.out.println(moviename);
            Movie movie = movieService.getMovieByName(moviename);
            if (null != movie) {
                request.getSession().setAttribute("movie", movie);
//                request.setAttribute("movie", movie);
                System.out.println("电影存在，跳转到电影详情页面！");
                request.getRequestDispatcher("/WEB-INF/views/biz/detail.jsp").forward(request,response);
            } else {
                fail = "电影查找失败，请输入正确的电影名称！";
                request.setAttribute("fail",fail);
                System.out.println("电影查找失败！");
                request.getRequestDispatcher("/movie/list.do").forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
