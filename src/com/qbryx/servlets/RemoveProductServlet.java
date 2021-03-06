package com.qbryx.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qbryx.domain.Customer;
import com.qbryx.util.ServiceFactory;

/**
 * Servlet implementation class RemoveProductServlet
 */
@WebServlet("/removeProductFromcart")
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public RemoveProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean productRemoved = false;
		
		String cartId = customer(request.getSession().getAttribute("customer")).getCartId();
		String upc = request.getParameter("username");
		
		productRemoved = ServiceFactory.customerService().removeToCart(cartId, upc);
		
		if(productRemoved){
			response.sendRedirect("customer");
		}else{
			
		}
	}

	private <T> Customer customer(T t){	
		return (Customer) t;
	}
}
