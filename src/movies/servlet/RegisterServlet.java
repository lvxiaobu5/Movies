package movies.servlet;

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
 * @date 2019/11/27 - 9:48
 */
public class RegisterServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (Objects.equals("/reg.do", path)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String success = null;
            if(success!=null){
                request.removeAttribute(success);
            }
            String error = null;
            if(error!=null){
                request.removeAttribute(error);
            }
            String fail = null;
            if(fail!=null){
                request.removeAttribute(fail);
            }


            System.out.println("进入注册Servlet");
            boolean flag = userService.check(username);

            System.out.println(flag);
            System.out.println("判断结束!");

            if(flag){
                /**
                 * 账号已被注册
                 * 返回提示信息跳转到 登录/注册 界面
                 */
                error = "该账号已被注册使用！";
                request.setAttribute("error",error);
                request.getRequestDispatcher("/WEB-INF/views/biz/register.jsp").forward(request,response);

            }else{
                /**
                 * 账号未被使用，执行注册功能
                 */
                System.out.println("添加1");
                boolean flag1 = userService.addUser(username,password);
                System.out.println("添加2");
                if(flag1){
                    System.out.println("注册成功!");
                    success = "注册成功！";
                    request.setAttribute("success",success);
                    request.getRequestDispatcher("/WEB-INF/views/biz/login.jsp").forward(request,response);
                }else {
                    fail = "注册失败,请重新注册！";
                    request.setAttribute("fail",fail);
                    request.getRequestDispatcher("/WEB-INF/views/biz/register.jsp").forward(request,response);
                }
            }
        }else if (Objects.equals("/regPrompt.do", path)){
            request.getRequestDispatcher("/WEB-INF/views/biz/register.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
