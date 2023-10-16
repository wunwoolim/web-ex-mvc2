package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserResponseDto;

public class LogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserResponseDto responseUser = (UserResponseDto) session.getAttribute("responseUser");
		
		if(responseUser != null){
			session.invalidate();
		}
		
		response.sendRedirect("/login");
	
	}

}
