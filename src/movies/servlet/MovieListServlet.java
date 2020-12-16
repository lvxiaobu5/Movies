package movies.servlet;

import movies.bean.Movie;
import movies.service.MovieService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * TODO
 * 电影列表Servlet
 * @author KaYo
 * @date 2019/11/21 - 23:19
 */
public class MovieListServlet extends HttpServlet {
    private MovieService movieService;

    @Override
    public void init() throws ServletException {
        super.init();
        movieService = new MovieService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(Objects.equals("/movie/list.do",path)){
            String pageStr = request.getParameter("page");//当前页码
            int page = 1;//页码默认值为1
            if (null != pageStr && (!"".equals(pageStr))) {
                try {
                    page = Integer.parseInt(pageStr);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            List<Movie> movies = movieService.getPage(page, 10);//分页查询全部电影
            //以上已完成分页查询，以下是显示在页面上
            int count = movieService.countMovies();
            int last = count % 10 == 0 ? (count / 10) : ((count / 10) + 1);
            request.setAttribute("last", last);
            request.getSession().setAttribute("movies", movies);
            request.setAttribute("page", page);
            request.getRequestDispatcher("/WEB-INF/views/biz/movie_list.jsp").forward(request, response);
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        movieService = null;
    }

}
