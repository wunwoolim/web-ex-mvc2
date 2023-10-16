package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.UserDao;
import user.UserRequestDto;
import user.UserResponseDto;


public class LoginFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 처리 로직
		// 파마미터 값 넘어옴
		// 유저의 비밀번호가 일치하는지
		// 일치하면 -> mypage
		// session log
		// 불일치하면 -> login
		request.setCharacterEncoding("UTF-8");
		String username =	request.getParameter("username");
		String password =	request.getParameter("userpassword");
		
		UserDao userDao = UserDao.getInstance();
		
		UserResponseDto responseUser = userDao.findByUsername(username,password);
		
		System.out.println("responseUser : "+ responseUser);
		String url ="";
		
		if(responseUser != null){
			HttpSession session = request.getSession();
			session.setAttribute("responseUser", responseUser);
			url ="/mypage";
			
		}else {
			url="/login";
		}
		
		response.sendRedirect(url);
		
	}

}
