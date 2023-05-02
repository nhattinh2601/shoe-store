package vn.iotstar.controller.web;

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

import com.ctc.wstx.shaded.msv_core.util.xml.DOMBuilder;
import com.twilio.rest.preview.sync.service.Document;

import vn.iotstar.dao.impl.CartDaoImpl;
import vn.iotstar.dao.impl.CartItemDaoImpl;
import vn.iotstar.dao.impl.DaoDBConection;
import vn.iotstar.entity.Cart;
import vn.iotstar.entity.CartItem;
import vn.iotstar.entity.User;

/**
 * Servlet implementation class CheckoutControl
 */
@WebServlet(urlPatterns = { "/checkout/xacnhan"})
public class CheckoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURL().toString();
		loadcheckout(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void loadcheckout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USERMODEL");
		DaoDBConection DAO=new DaoDBConection();
		
		CartItemDaoImpl cartItem =new CartItemDaoImpl();
			  
		
			Cart cart =DAO.CheckCartStatus(u.getUserId(),0);
			List<CartItem> listcart=cartItem.hienthicart(cart.getCartId());
			
			//document.getElementById("firstName").value=u.getFullname();
			request.setAttribute("fullname", u.getFullname());
			request.setAttribute("email", u.getEmail());
			request.setAttribute("sdt", u.getPhone());
			request.setAttribute("listcart",listcart);
			request.setAttribute("total", DAO.totalPriceByCartId(cart.getCartId()));
	
		
		
		request.getRequestDispatcher("/views/web/thanhtoan.jsp").forward(request, response);
		
	}
	protected void DatHang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("USERMODEL");
		DaoDBConection DAO=new DaoDBConection();
		float total=Float.parseFloat(request.getParameter("total"));
		Date date = new Date();
		  Timestamp timestamp2 = new Timestamp(date.getTime());
		CartDaoImpl cartDAO= new CartDaoImpl();
		Cart cartid=cartDAO.CheckCartstatus(u.getUserId(),0);
		String address=request.getParameter("address");
		String note=request.getParameter("ghichu");
		String name=request.getParameter("fullname");
		DAO.Insert_Bills(total, timestamp2, cartid.getCartId(), u.getUserId(), "tien mat", 0, address, note, name, "email", "phone");
		response.sendRedirect("/ITProject/category/list");
	}

}
