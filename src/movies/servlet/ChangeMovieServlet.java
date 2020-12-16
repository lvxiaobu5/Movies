package movies.servlet;

import movies.bean.Movie;
import movies.service.MovieService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * TODO
 * 修改和删除电影Servlet
 * @author KaYo
 * @date 2019/11/28 - 16:53
 */
public class ChangeMovieServlet extends HttpServlet {
    private MovieService movieService;

    @Override
    public void init() throws ServletException {
        super.init();
        movieService = new MovieService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathName = request.getServletPath();
        if (Objects.equals("/changedelete.do", pathName)) {
//            String pageStr = request.getParameter("page");//当前页码
//            int page = 1;//页码默认值为1
//            if (null != pageStr && (!"".equals(pageStr))) {
//                try {
//                    page = Integer.parseInt(pageStr);
//                } catch (NumberFormatException e) {
//                    e.printStackTrace();
//                }
//            }
//            List<Movie> movies = movieService.getPage(page, 10);//分页查询全部电影
//            //以上已完成分页查询，以下是显示在页面上
//            int count = movieService.countMovies();
//            int last = count % 10 == 0 ? (count / 10) : ((count / 10) + 1);
//            request.setAttribute("last", last);
            List<Movie> movies = movieService.getMovies();
            request.getSession().setAttribute("movies", movies);
//            request.setAttribute("page", page);
            request.getRequestDispatcher("/WEB-INF/views/biz/changemovie.jsp").forward(request,response);
        }else if (Objects.equals("/change.do", pathName)){
            String moviename = request.getParameter("moviename");
            System.out.println(moviename);
            Movie movie = movieService.getMovie(moviename);
//            movie.setMoviename(moviename);
//            movie.setFilename(filename);
            request.getSession().setAttribute("movie", movie);
            request.getRequestDispatcher("/WEB-INF/views/biz/change.jsp").forward(request, response);
        }else if (Objects.equals("/movie/update.do", pathName)){
            String fileName = null;
            // 数据的接收
            try {
                // 文件上传基本操作：
                // 1. 创建一个磁盘文件项工厂对象
                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
                // 2. 创建一个核心解析类
                ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
                // 3. 解析 request 请求，返回的是 List 集合，Lits 集合中存放的是 FileItem 对象，对应着每一个表单项
                List<FileItem> list = servletFileUpload.parseRequest(request);
                // 定义一个 Map 集合用于保存接收到的用户数据
                Map<String, String> movieDataMap = new HashMap<>();
                // 文件 url
                String url = null;
                // 4. 遍历集合，获得每个 FileItem，判断是普通表单项还是文件上传项
                for (FileItem fileItem : list) {
                    // 判断是普通表单项还是文件上传项
                    if (fileItem.isFormField()) {
                        // 普通表单项
                        // 接收表单项参数的值:
                        // 获得表单项的 name 属性对应的值
                        String name = fileItem.getFieldName();
                        // 获得表单项的值
                        String value = fileItem.getString("UTF-8");
//                        String moviename = request.getParameter("moviename");
//                        String introduce = request.getParameter("introduce");
                        // 打印出来测试
                        System.out.println(name + " ---> " + value);
                        // 将其他的数据存入到 Map 集合中
                        movieDataMap.put(name, value);
                    } else {
                        // 文件上传项
                        // 文件上传功能:
                        // 获得文件上传的名称
                        String name = fileItem.getFieldName();
                        // 获得表单项的值
                        String value = fileItem.getString("UTF-8");
                        fileName = fileItem.getName();
//                        System.out.println(fileName);
                        if (fileName != null && !"".equals(fileName)) {
                            // 通过工具类获得唯一文件名
//                        String uuidFileName = UploadUtils.getUUIDFileName(fileName);
                            // 获得文件上传的数据
                            InputStream is = fileItem.getInputStream();
                            // 获得文件上传的路径
                            String path = this.getServletContext().getRealPath("/img");
                            // 将输入流对接到输出流
                            url = path + "\\" + fileName;
                            OutputStream os = new FileOutputStream(url);
                            int len = 0;
                            byte[] bytes = new byte[1024];
                            while ((len = is.read(bytes)) != -1) {
                                os.write(bytes, 0, len);
                            }
                            is.close();
                            os.close();
                            movieDataMap.put(name, url);
                        }
                    }
                }
//                boolean flag = movieService.save(list.get(0),url,list.get(1),fileName);
                // 打印测试 Map 集合
                boolean flag = movieService.update(movieDataMap.get("moviename"),movieDataMap.get("moviepic"),movieDataMap.get("introduce"),fileName);
                if (flag){
                    System.out.println();
                }
                System.out.println(movieDataMap.get("moviename"));
                System.out.println(fileName);
                List<Movie> movies = movieService.getMovies();
                request.getSession().setAttribute("movies", movies);
//                String pageStr = request.getParameter("page");//当前页码
//                int page = 1;//页码默认值为1
//                if (null != pageStr && (!"".equals(pageStr))) {
//                    try {
//                        page = Integer.parseInt(pageStr);
//                    } catch (NumberFormatException e) {
//                        e.printStackTrace();
//                    }
//                }
//                List<Movie> movies = movieService.getPage(page, 10);//分页查询全部电影
//                //以上已完成分页查询，以下是显示在页面上
//                int count = movieService.countMovies();
//                int last = count % 10 == 0 ? (count / 10) : ((count / 10) + 1);
//                request.setAttribute("last", last);
//                request.getSession().setAttribute("movies", movies);
//                request.setAttribute("page", page);
                request.getRequestDispatcher("/WEB-INF/views/biz/changemovie.jsp").forward(request, response);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
//            request.getRequestDispatcher("/WEB-INF/views/biz/changemovie.jsp").forward(request, response);
        }else if (Objects.equals("/delete.do", pathName)){
            String moviename = request.getParameter("moviename");
            System.out.println(moviename);
            boolean flag = movieService.delete(moviename);
            if (flag){
                System.out.println("删除成功！");
                List<Movie> movies = movieService.getMovies();
                request.getSession().setAttribute("movies", movies);
//                request.setAttribute("page", page);
                request.getRequestDispatcher("/WEB-INF/views/biz/changemovie.jsp").forward(request,response);
            }else {
                System.out.println("删除失败！");
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
