package vn.iotstar.controller.web;

import java.io.IOException;
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

import com.ctc.wstx.dtd.FullDTDReader;

import vn.iotstar.controller.SendEmail;
import vn.iotstar.dao.impl.BillDaoImpl;
import vn.iotstar.dao.impl.CartDaoImpl;
import vn.iotstar.dao.impl.CartItemDaoImpl;
import vn.iotstar.dao.impl.DaoDBConection;
import vn.iotstar.entity.Cart;
import vn.iotstar.entity.CartItem;
import vn.iotstar.entity.User;
import vn.iotstar.entity.Bill;


/**
 * Servlet implementation class DatHangControl
 */
@WebServlet("/dathang")
public class DatHangControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatHangControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DatHang(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void DatHang(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		HttpSession sessionBill=request.getSession();
		User u = (User) session.getAttribute("USERMODEL");
		DaoDBConection DAO=new DaoDBConection();
		BillDaoImpl DAOBills=new BillDaoImpl();
		
		
		Date date = new Date();
		  Timestamp timestamp2 = new Timestamp(date.getTime());
		CartDaoImpl cartDAO= new CartDaoImpl();
		Cart cartid=cartDAO.CheckCartstatus(u.getUserId(),0);
		float total=DAO.totalPriceByCartId(cartid.getCartId());
		
		CartItemDaoImpl cartItem =new CartItemDaoImpl();
		  
		
		Cart cart =DAO.CheckCartStatus(u.getUserId(),0);
		List<CartItem> listcart=cartItem.hienthicart(cart.getCartId());	
		String address=request.getParameter("address");
		String note=request.getParameter("note");
		String name=request.getParameter("fullname");
		String payment=request.getParameter("payment");
		String email=request.getParameter("email");
		String phone=request.getParameter("sdt");
		DAO.Insert_Bills(total, timestamp2, cartid.getCartId(), u.getUserId(), payment, 0, address, note, name, email, phone);
		cartid.setStatus(1);
		
		cartDAO.update(cartid);
		Bill bills=DAOBills.findBillByCartID_UserId(cartid.getCartId(),u.getUserId());
		sessionBill.setAttribute("BILLS",bills);
		//send email
		//
		String danhsachSP ="";
		for (CartItem cartItem2 : listcart) {
			danhsachSP += cartItem2.getProduct().getProductName();
			danhsachSP +=" Số lượng: "+ cartItem2.getQuantity();
			danhsachSP += " \n";
		}
		String content = "Cảm ơn bạn đã đặt hàng ! \n " + "Đơn Hàng\n"+
		"Họ Và tên: "+bills.getFullname()+
		"\nSố Điện thoại: h"+bills.getPhone()+
		"\nĐịa chỉ giao hàng:"+bills.getAddress()+
		"\nSản phẩm:\n" + danhsachSP
		+"\n Tổng tiền hàng:"+ bills.getTotal();
		
		SendEmail sendemail = new SendEmail();
		try {
			sendemail.SendEmail(bills.getEmail(), content);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/ITProject/XemLaiDonHang");
		
		
	}

}
