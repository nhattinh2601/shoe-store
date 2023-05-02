package vn.iotstar.controller.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.impl.CartDaoImpl;
import vn.iotstar.dao.impl.CartItemDaoImpl;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.dao.impl.DaoDBConection;
import vn.iotstar.dao.impl.ProductDaoImpl;
import vn.iotstar.entity.Cart;
import vn.iotstar.entity.CartItem;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Product;
import vn.iotstar.entity.User;

import vn.iotstar.dao.impl.CartDaoImpl;
import vn.iotstar.dao.impl.CartItemDaoImpl;
import vn.iotstar.dao.impl.DaoDBConection;
import vn.iotstar.entity.Cart;
import vn.iotstar.entity.CartItem;

/**
 * Servlet implementation class WebCartAdd
 */
@WebServlet("/cart/add")
public class WebCartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WebCartAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USERMODEL");
		DaoDBConection DAO=new DaoDBConection();
	   
		int productId=Integer.parseInt(request.getParameter("productid"));
		String price=request.getParameter("price");
		float price2= Float.parseFloat(price);
		Cart cart = new Cart();
			
		if(u != null) {
			cart =DAO.CheckCartStatus(u.getUserId(),0);
		}
		if(cart !=null) {
			
			CartItem cartitem=DAO.CheckCartItemStatus(cart.getCartId(),productId);
			if(cartitem != null)
			{
				float pricenew=(float)(cartitem.getUnitPrice())+price2;
						
				DAO.Update_CartItem(cartitem.getQuantity()+1, pricenew, productId, cart.getCartId(),cartitem.getCartItemId());
			}else {
				DAO.Insert_CartItem(1,price2,productId , cart.getCartId());
			}
			
			int i=1;
			request.setAttribute("thongbao", i);
			//response.sendRedirect("/ITProject/category/list");
		}
		else
		{
			
			Date date = new Date();
			  Timestamp timestamp2 = new Timestamp(date.getTime());
			DAO.Insert_Cart(u.getUserId(),timestamp2,0);
			Cart cart2 =DAO.CheckCartStatus(u.getUserId(),0);
			DAO.Insert_CartItem(1, price2, productId, cart2.getCartId());
			int i=1;
			request.setAttribute("thongbao", i);

		}
	
		int i=1;
		request.setAttribute("thongbao", i);
		response.sendRedirect("/ITProject/category/list");

		
	}
	ProductDaoImpl productdao = new ProductDaoImpl();
	protected void loadHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		Product top1 = productdao.findTop1Price();

		List<Product> top4last = productdao.findLastProduct();
		List<Product> top4best = productdao.findBestAmount();
		request.setAttribute("top1", top1);
		request.setAttribute("top4last", top4last);
		request.setAttribute("top4best", top4best);

		request.getRequestDispatcher("/views/web/homemain.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
