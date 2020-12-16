package movies.bean;

/**
 * TODO
 * Movie Bean
 * @author KaYo
 * @date 2019/11/21 - 23:42
 */
public class Movie {
    public Movie(){}
    public Movie(String moviename, String picpath, String introduce,String filename) {
        this.moviename = moviename;

        this.picpath = picpath;

        this.introduce = introduce;

        this.filename = filename;

    }
    public Movie(String moviename, String picpath, String introduce,String filename,long id) {
        this.id = id;

        this.moviename = moviename;

        this.picpath = picpath;

        this.introduce = introduce;

        this.filename = filename;

    }

    public Movie(long id,String moviename, String picpath, String introduce,String filename) {
        this.id = id;

        this.moviename = moviename;

        this.picpath = picpath;

        this.introduce = introduce;

        this.filename = filename;

    }

    private String picpath;

    private long id;

    private String filename;

//    private String username;

    private String moviename;

    private String introduce;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPicpath() {
        return picpath;
    }

    public void setPicpath(String picpath) {
        this.picpath = picpath;
    }



    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }


}
