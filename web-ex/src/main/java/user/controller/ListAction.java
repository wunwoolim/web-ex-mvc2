package user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDao;
import user.UserResponseDto;



public class ListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ListAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		UserDao userDao = UserDao.getInstance();
		
		ArrayList<UserResponseDto> responseUser = userDao.findAll();

		String url ="";
		
		if(responseUser != null){
			HttpSession session = request.getSession();
			session.setAttribute("list", responseUser);
			url ="/memberList";
			
		}else {
			url="/index";
		}
		
		response.sendRedirect(url);
	}

	

}
