package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import entities.Product;
import model.ProductModel;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String page="";
		HttpSession session = request.getSession();
		Connection cn = new MyConnect().getcn();
		if(cn==null)
			return;
		String masp = request.getParameter("txtmasp");
		String tensp = request.getParameter("txttensp");
		String hinh = request.getParameter("file");
		String price = request.getParameter("txtprice");
		int gia = Integer.parseInt(price);
		String madm = request.getParameter("txtmadm");
		String chuoi = request.getParameter("task");
		Product sanpham = new Product(masp, tensp, gia, hinh, madm);
		ProductModel spmodel = new ProductModel(sanpham);
		if(chuoi.equals("update"))
		{
			int kq = spmodel.updateProduct();
			if(kq==0)
			{
				System.out.println("Error");
			}
			else
			{
				session.setAttribute("productList", new ProductModel().getList());
				page = "index.jsp";
			}
			request.getRequestDispatcher(page).forward(request, response);
		}
	}

}
