package gdut.servlet;
import gdut.Dao.GoodsDao;
import gdut.Dao.GoodsDaoImpl;
import gdut.service.GoodService;
import gdut.entity.Goods;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {

    private GoodService goodService = new GoodService();

    public DetailServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Goods one = goodService.getOneGoods(Integer.parseInt(req.getParameter("id")));
        req.getSession().setAttribute("one", one);
        req.getRequestDispatcher("/GoodsDetail.jsp").forward(req, resp);
    }
}
