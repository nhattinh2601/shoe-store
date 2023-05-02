package vn.iotstar.controller.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.dao.impl.DaoDBConection;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.entity.Product;

/**
 * Servlet implementation class AddQuantityControl
 */
@WebServlet("/addquantity")
public class AddQuantityControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuantityControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DaoDBConection DAO=new DaoDBConection();
		ProductDaoImpl DAOPro=new ProductDaoImpl();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int cartitemid=Integer.parseInt(request.getParameter("cartitemid"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		float unitprice=Float.parseFloat(request.getParameter("unitprice"));
		int pid=Integer.parseInt(request.getParameter("pid"));
		int cartid=Integer.parseInt(request.getParameter("cartid"));
		Product product=DAOPro.findProductByID(pid);
		float newprice = (float)product.getPrice()+unitprice;

		DAO.Update_CartItem(quantity+1, newprice, pid, cartid, cartitemid);
		response.sendRedirect("/ITProject/cart");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
