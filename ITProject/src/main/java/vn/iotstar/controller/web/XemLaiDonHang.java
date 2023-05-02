package vn.iotstar.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.dao.impl.CartItemDaoImpl;
import vn.iotstar.dao.impl.DaoDBConection;
import vn.iotstar.entity.Bill;
import vn.iotstar.entity.CartItem;
import vn.iotstar.entity.User;

/**
 * Servlet implementation class XemLaiDonHang
 */
@WebServlet("/XemLaiDonHang")
public class XemLaiDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XemLaiDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessionBill=request.getSession();
		Bill b = (Bill) sessionBill.getAttribute("BILLS");
		DaoDBConection DAO= new DaoDBConection();
		CartItemDaoImpl cartitemDao=new CartItemDaoImpl();
		request.setAttribute("fullname", b.getFullname());
		request.setAttribute("phone", b.getPhone());
		request.setAttribute("email", b.getEmail());
		request.setAttribute("address", b.getAddress());
		request.setAttribute("payment", b.getPaymentmethod());
		request.setAttribute("note1",b.getNote());
		request.setAttribute("total", DAO.totalPriceByCartId(b.getCart().getCartId()));
		List<CartItem> cartitem=cartitemDao.findCartItemByCartID(b.getCart().getCartId());
		request.setAttribute("listcart", cartitem);
		
		request.getRequestDispatcher("/views/web/camon.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
