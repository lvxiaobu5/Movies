package movies.servlet;

import movies.bean.Party;
import movies.service.PartyService;
import movies.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;

/**
 * TODO
 *
 * @author KaYo
 * @date 2019/12/3 - 0:06
 */
public class PartyServlet extends HttpServlet {
    private UserService userService;
    private PartyService partyService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserService();
        partyService = new PartyService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(Objects.equals("/party.do",path)){
            request.getRequestDispatcher("/WEB-INF/views/biz/userparty.jsp").forward(request, response);
        }else if (Objects.equals("/add.do",path)){
            String address = request.getParameter("address");
            long perprice = Long.parseLong(request.getParameter("perprice"));
            String introduce = request.getParameter("introduce");
            String partydate = request.getParameter("partydate");
            Party party = new Party();
            party.setAddress(address);
            party.setPerprice(perprice);
            party.setIntroduce(introduce);
            try {
                party.setPartydate(new SimpleDateFormat("yyyy-MM-dd").parse(partydate));
            } catch (ParseException e) {
                System.out.println("格式化Partydate字段失败!");
                e.printStackTrace();
            }
            boolean result = partyService.add(address,perprice,introduce,partydate);
            if (result) {
                request.getSession().setAttribute("party", party);
                request.getRequestDispatcher("/WEB-INF/views/biz/admin.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
            }
        }else if (Objects.equals("/addparty.do",path)){
            request.getRequestDispatcher("/WEB-INF/views/biz/rootparty.jsp").forward(request, response);
        }else if (Objects.equals("/partyimg.do",path)){
            Party party = partyService.getParty();
            if (null != party) {
                request.setAttribute("party", party);
                System.out.println("跳转到出游信息页面！");
                request.getRequestDispatcher("/WEB-INF/views/biz/partyimg.jsp").forward(request, response);
            } else {
                System.out.println("跳转失败！");
                request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
            }
        }else if (Objects.equals("/apply.do",path)){
            String username = request.getParameter("username");
            long perprice = Long.parseLong(request.getParameter("perprice"));
            String phone = request.getParameter("phone");
            boolean result = partyService.addUser(username,perprice,phone);
            if (result) {
                request.getRequestDispatcher("/WEB-INF/views/biz/success.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
            }
        }else if (Objects.equals("/check.do",path)){
            List<Party> partys = partyService.getUser();
            if (null != partys) {
                request.setAttribute("partys", partys);
                System.out.println("跳转到用户报名信息页面！");
                request.getRequestDispatcher("/WEB-INF/views/biz/check.jsp").forward(request, response);
            } else {
                System.out.println("跳转失败！");
                request.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(request, response);
            }
        } else if (Objects.equals("/adminmovielist.do", path)){
            request.getRequestDispatcher("/WEB-INF/views/biz/changemovie.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
