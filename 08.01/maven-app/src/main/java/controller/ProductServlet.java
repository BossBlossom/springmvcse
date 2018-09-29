package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.jdbc.Connection;

import entities.Product;
import model.ProductModel;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String page="";
		HttpSession session = request.getSession();
		String chuoi = request.getParameter("task");
		String masp = request.getParameter("txtid");
		String tensp = request.getParameter("txtname");
		String price = request.getParameter("txtprice");
		int gia = Integer.parseInt(price);
		String hinh = request.getParameter("file");
		String madm = request.getParameter("madm");
		Product sanpham = new Product(masp, tensp, gia, hinh, madm);
		ProductModel promodel = new ProductModel(sanpham);
		Connection cn = new MyConnect().getcn();
		if(cn==null)
			System.out.println("disconnect");
		if(chuoi.equals("insert"))
		{
			int kq = promodel.insertProduct();
			if(kq==0)
				System.out.println("error");
			else
			{
				session.setAttribute("productList", new ProductModel().getList());
				page = "index.jsp";
			}
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
