package testPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.config.DBConnection;
import vn.iotstar.controller.SendEmail;
import vn.iotstar.dao.impl.CartDaoImpl;
import vn.iotstar.dao.impl.CartItemDaoImpl;
import vn.iotstar.dao.impl.DaoDBConection;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.entity.Cart;
import vn.iotstar.entity.CartItem;
import vn.iotstar.entity.User;

/**
 * Servlet implementation class testUser
 */
@WebServlet("/testUser")
public class testUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * CartItemDaoImpl dao = new CartItemDaoImpl();
		 * 
		 * HttpSession session = request.getSession(); User u = (User)
		 * session.getAttribute("USERMODEL"); //session.getAttribute("USERMODEL");
		 * //User lg= (User) session.getAttribute("USERMODEL");; DaoDBConection DAO=new
		 * DaoDBConection DAO=new DaoDBConection(); CartItem cart=DAO.Update_CartItem(2,
		 * 200, 2, 13,32); printWriter.println(cart);
		 */
		 CartDaoImpl cartDao = new CartDaoImpl();
//		 List<Cart> list = cartDao.ListOrder();
//		 PrintWriter printWriter =
//				  response.getWriter();
//		 printWriter.println(list);
//		 Cart cart = cartDao.findCartByID(1);
		 PrintWriter printWriter =
				  response.getWriter();
		 
//		 cart.setStatus(2);
//		 
//		 cartDao.update(cart);
//		 int status = cart.getStatus();
		 
//		 CartItemDaoImpl cartItemDao = new CartItemDaoImpl()
//		 List<CartItem> list = cartItemDao.OrderDetail(5);
		 DaoDBConection DAO=new DaoDBConection();
		 DAO.Insert_Cart(5, null, 0);
		 //printWriter.println(DAO.Insert_Bills(120, null, 1, 5,"tiền mặt", 0,"HCM","giao nhanh","Khánh","khanh@gmail.com","0326359823"));
		 printWriter.println(DAO.countCartItemByCartID(3));
			/*
			 * SendEmail sendEmail = new SendEmail(); try {
			 * sendEmail.SendEmail("20110576@student.hcmute.edu.vn", "hello"); } catch
			 * (UnsupportedEncodingException | MessagingException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
