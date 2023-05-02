package vn.iotstar.controller.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.impl.DaoDBConection;
import vn.iotstar.entity.Cart;
import vn.iotstar.entity.CartItem;
import vn.iotstar.entity.User;

/**
 * Servlet implementation class AddCartItemOnDeital
 */
@WebServlet("/addcartitemondetail")
public class AddCartItemOnDeital extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartItemOnDeital() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USERMODEL");
		DaoDBConection DAO=new DaoDBConection();
	   
		int productId=Integer.parseInt(request.getParameter("productid"));
		int quantity=Integer.parseInt(request.getParameter("quantity2"));
		//float floatquantity=(float)quantity;
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
				float pricenew=(float)(cartitem.getUnitPrice())+price2*(float)quantity;
						
				DAO.Update_CartItem(cartitem.getQuantity()+quantity, pricenew, productId, cart.getCartId(),cartitem.getCartItemId());
			}else {
				DAO.Insert_CartItem(quantity,price2*(float)quantity,productId , cart.getCartId());
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
			DAO.Insert_CartItem(quantity, price2*(float)quantity, productId, cart2.getCartId());
			int i=1;
			request.setAttribute("thongbao", i);

		}
	
		int i=1;
		request.setAttribute("thongbao", i);
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
