package movies.service;

import movies.bean.Movie;
import movies.dao.MovieDAO;

import java.util.List;

/**
 * TODO
 * 电影列表Service
 * @author KaYo
 * @date 2019/11/21 - 23:23
 */
public class MovieService {
    private MovieDAO movieDAO;

    public MovieService(){
        movieDAO = new MovieDAO();
    }

    /**
     * 添加电影信息
     * @param
     * @param
     * @return
     */
    public boolean save(String moviename,String picpath,String introduce,String filename) {

        return movieDAO.save(moviename,picpath,introduce,filename);
    }


    /**
     * 分页查询全部电影
     * @param page 当前页码
     * @param pageSize 每页记录数
     * @return
     */
    public List<Movie> getPage(int page,int pageSize){
        return movieDAO.getPage(page,pageSize);
    }


    /**
     * 显示全部电影
     * @return
     */
    public List<Movie> getMovies(){
        return movieDAO.getMovies();
    }


    /**
     * 计算所有电影数量
     * @return
     */
    public int countMovies(){
        return movieDAO.countMovies();
    }


    /**
     * 电影详情
     * @param moviename
     * @return
     */
    public Movie movieDetail(String moviename){
        return movieDAO.movieDetail(moviename);
    }


    /**
     * 修改电影信息
     * @param
     * @return
     */
    public boolean update(String moviename,String picpath,String introduce,String filename) {
        return movieDAO.update(moviename,picpath,introduce,filename);
    }


    /**
     * 删除电影信息
     * @param
     * @return
     */
    public boolean delete(String moviename) {
        return movieDAO.delete(moviename);
    }


    /**
     * 显示单部电影
     * @return
     */
    public Movie getMovie(String moviename){
        return movieDAO.getMovie(moviename);
    }


    /**
     * 根据电影名查询电影详情
     * @param moviename
     * @return
     */
    public Movie getMovieByName(String moviename) {
        return movieDAO.getMovieByName(moviename);
    }
}
