package gdut.servlet;

import gdut.Dao.GoodsDao;
import gdut.entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/GoodServlet")
public class GoodServlet extends HttpServlet {


    public GoodServlet() {
        super();
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Goods one=GoodsDao.getOneGoods(Integer.parseInt(req.getParameter("id")));
            req.getSession().setAttribute("one", one);
            req.getRequestDispatcher("/GoodsDetail.jsp").forward(req, resp);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
//        int goods_id =Integer.parseInt(req.getParameter("goods_id"));
//
//        Goods one = null;
//        try {
//            one = GoodsDao.getOneGoods(goods_id);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            req.setAttribute("one", one);
//            req.getRequestDispatcher("/GoodsDetail.jsp").forward(req, resp);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


//    public void findGoodsById(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException {
//
//
//        int goods_id =Integer.parseInt(req.getParameter("goods_id"));
//
//        Goods one = GoodsDao.getOneGoods(goods_id);
//
//        try {
//            req.setAttribute("one", one);
//            req.getRequestDispatcher("/GoodsDetail.jsp").forward(req, resp);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
    }

