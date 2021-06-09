package gdut.servlet;

import gdut.service.GoodService;
import gdut.entity.Goods;
import gdut.entity.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FindNameServlet")
public class FindNameServlet extends HttpServlet {

    private GoodService goodService = new GoodService();


    public FindNameServlet() {
        super();
    }


    private int getPc(HttpServletRequest req){
        int pc = 1;
        String parm = req.getParameter("pc");
        if(parm != null&& !parm.trim().isEmpty()){
            pc = Integer.parseInt(parm);
        }
        return pc;
    }



    private String getUrl(HttpServletRequest req){
        String url = req.getRequestURI()+"?"+req.getQueryString();

        int index = url.lastIndexOf("&pc=");
        if(index != -1){
            url = url.substring(0,index);
        }
        return url;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        int pc = getPc(req);
        String url = getUrl(req);
        PageBean<Goods> pageBean = goodService.findNamePage(req.getParameter("ss"));
        pageBean.setUrl(url);
        req.setAttribute("page",pageBean);
        req.getRequestDispatcher("/GoodsList.jsp").forward(req,resp);
    }
}

